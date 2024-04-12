package sample.cafekiosk.spring.api.service.product;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import sample.cafekiosk.spring.IntegrationTestSupport;
import sample.cafekiosk.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.cafekiosk.spring.api.service.product.response.ProductResponse;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


class ProductServiceTest extends IntegrationTestSupport {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeAll
    static void beforeAll() {
        // before class
        // 테스트 클래스를 실행하기 전에 작업을 하는 상태
    }

    @BeforeEach
    void setUp() {
        // before method
        // 각각의 테스트 메소드가 실행되기 전에 실행되는

        // 각 테스트 입장에서 봤을 때 : 아예 몰라도 테스트 내용을 이해하는 데에 문제가 없는가?
        // 수정해도 모든 테스트에 영향을 주지 않는가?
        // 위 조건을 만족하면 setUp() 메소드를 사용해도 된다.
    }


    @AfterEach
    void tearDown() {
        productRepository.deleteAllInBatch();
    }

    @DisplayName("신규 상품을 등록한다. 상품번호는 가장 최근 상품의 상품번호에서 1 증가한 값이다.")
    @Test
    void crateProduct() {
        // given
        Product product1 = createProduct( "001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 4000);
        productRepository.saveAll(List.of(product1));

        ProductCreateRequest request = ProductCreateRequest.builder()
                .name("카푸치노")
                .price(5000)
                .type(ProductType.HANDMADE)
                .sellingStatus(ProductSellingStatus.SELLING)
                .build();

        // when
        ProductResponse productResponse = productService.createProduct(request.toServiceRequest());

        // then
        assertThat(productResponse)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .contains("002", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000);

        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(2)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .containsExactlyInAnyOrder(
                        tuple("002", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000),
                        tuple("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "아메리카노", 4000)
                );
    }

    @DisplayName("상품이 하나도 없는 경우 신규 상품을 등록하면 상품번호는 001이다.")
    @Test
    void crateProductWhenProductsIsEmpty() {
        // given

        ProductCreateRequest request = ProductCreateRequest.builder()
                .name("카푸치노")
                .price(5000)
                .type(ProductType.HANDMADE)
                .sellingStatus(ProductSellingStatus.SELLING)
                .build();

        // when
        ProductResponse productResponse = productService.createProduct(request.toServiceRequest());

        // then
        assertThat(productResponse)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .contains("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000);

        List<Product> products = productRepository.findAll();
        assertThat(products).hasSize(1)
                .extracting("productNumber", "type", "sellingStatus", "name", "price")
                .containsExactlyInAnyOrder(
                        tuple("001", ProductType.HANDMADE, ProductSellingStatus.SELLING, "카푸치노", 5000)
                );
    }

    private static Product createProduct(String productNumber, ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        return Product
                .builder()
                .productNumber(productNumber)
                .type(type)
                .sellingStatus(sellingStatus)
                .name(name)
                .price(price)
                .build();
    }

}