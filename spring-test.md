# Spring & JPA 기반 테스트

## Spring / JPA 훑어보기 & 기본 엔티티 설계
### Library vs Framework
- Library - 라이브러리는 내 코드가 주체. 내가 코드를 짜다가 필요한 기능이 있으면 가져다가 쓰는 것. 이미 개발된 기능을 가져다 씀
- Framework - 프레임워크는 내 코드가 수동적인 존재.

### Spring
- IoC (Inversion of Control)
- DI (Dependency Injection)
- AOP (Aspect Oriented Programming)

### JPA
- ORM (Object Relational Mapping)
    - 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑해주는 것
    - 객체 지향 패러다임과 관계형 DB 패러다임의 불일치
    - 이전에는 개발자가 객체의 데이터를 한땀한땀 매핑하여 DB에 저장 및 조회(CRUD)
    - ORM을 사용함으로써 개발자는 단순 작업을 줄이고, 비즈니스 로직에 집중할 수 있다.
- JPA(Java Persistence API)
  - Java 진영의 ORM 기술 표준
  - 인터페이스이고, 여러 구현체가 있지만 보통 Hibernate를 많이 사용한다.
  - 반복적인 CRU SQL을 생성 및 실행해주고, 여러 부가 기능들을 제공한다.
  - 편리하지만 쿼리를 직접 작성하지 않기 때문에, 어떤 식으로 쿼리가 만들어지고 실행되는지 명확하게 이해하고 있어야 한다.
  - Spring 진영에서는 JPA를 한번 더 추상화한 Spring Data JPA를 제공한다.
  - QueryDSL과 조합하여 많이 사용한다.(타입 체크, 동적 쿼리)
  - @Entity, @Id, @Column
  - @ManyToOne, @OneToMany, @OneToOne, @ManyToMany(일대다 - 다대일 관계로 풀어서 사용)

### Persistence Layer 테스트
- 요구사항
  - 키오스크 주문을 위한 상품 후보 리스트 조회하기
  - 상품의 판매 상태 : 판매중, 판매보류, 판매중지
    - 판매중, 판매 보류인 상태의 상품을 화면에 보여준다.
  - id, 상품 번호, 상품 타입, 판매 상태, 상품 이름, 가격
- Data Access의 역할
- 비즈니스 가공 로직이 포함되어서는 안 된다. Data에 대한 CRUD에만 집중한 레이어

### Business Layer 테스트
- Business Layer
  - 비즈니스 로직을 구현하는 역할
  - Persistence Layer와의 상호작용(Data를 읽고 쓰는 행위)을 통해 비즈니스 로직을 전개시킨다.
  - 트랜잭션을 보장해야 한다.
- 요구사항
  - 상품 번호 리스트를 받아 주문 생성하기
  - 주문은 주문 상태. 주문 등록 시간을 가진다.
  - 주문의 총 금액을 계산할 수 있어야 한다.
  - 주문 생성 시 재고 확인 및 개수 차감 후 생성하기
  - 재고는 상품번호를 가진다.
  - 재고와 관련 있는 상품 타입은 병 음료, 베이커리이다.