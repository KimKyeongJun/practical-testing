package sample.cafekiosk.unit.beverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : kimkyeongjun
 * @packageName : sample.cafekiosk.unit.beverage
 * @fileName : AmericanoTest
 * @Date : 4/2/24
 * @description :
 */
class AmericanoTest {

 @Test
    void getName() {
    Americano americano = new Americano();
//    assertEquals("아메리카노", americano.getName());
    assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    void getPrice() {
        Americano americano = new Americano();
        assertEquals(4000, americano.getPrice());
        assertThat(americano.getPrice()).isEqualTo(4000);
    }


}