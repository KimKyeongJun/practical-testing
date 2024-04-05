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