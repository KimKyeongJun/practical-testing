# TDD: Test Driven Development

## TDD란

- 프로덕션 코드보다 테스트 코드를 먼저 작성하여 테스트가 구현 과정을 주도하도록 하는 방법론

  ![](https://prod-files-secure.s3.us-west-2.amazonaws.com/57a2c828-bc2e-430b-833d-4192e22e6373/d6183328-a9a8-45a2-81cd-20cedaf678a9/Untitled.png)

- TDD에서 이야기하는 가장 핵심 방법은 RED, GREEN, REFACTOR 라고 하는 3가지 단계를 거치게 된다
    - RED → 실패하는 테스트를 작성
    - GREEN → 테스트 통과 최소한의 코딩
    - REFACTOR → 구현 코드 개선 테스트 통과 유지
- TDD의 핵심 가치 → 피드백
    - 작성하는 구현 코드, 프로덕션 코드에 대해 빠른 피드백을 받을 수 있다.
- 선 기능 구현, 후 테스트 작성
    - 테스트 자체의 누락 가능성
    - 특정 테스트 케이스(해피 케이스)만 검증할 가능성
    - 잘못된 구현을 다소 늦게 발견할 가능성
- 선 테스트 작성, 후 기능 구현
    - 복잡도가 낮은(유연하며 유지보수가 쉬운), 테스트 가능한 코드로 구현할 수 있게 한다.
    - 쉽게 발견하기 어려운 경계(Edge) 케이스를 놓치지 않게 해준다.
    - 구현에 대한 빠른 피드백을 받을 수 있다.
    - 과감한 리팩토링이 가능해진다.
- 관점의 변화
    - 이전 → 테스트는 구현부 검증을 위한 보조 수단

      ![](https://prod-files-secure.s3.us-west-2.amazonaws.com/57a2c828-bc2e-430b-833d-4192e22e6373/96afa990-4361-4e29-9340-c4f4c4ee9983/Untitled.png)

    - 현재 → 테스트와 상호 작용하며 발전하는 구현부

      ![](https://prod-files-secure.s3.us-west-2.amazonaws.com/57a2c828-bc2e-430b-833d-4192e22e6373/9f1217ba-c805-4ebf-859a-32fc7db59e20/Untitled.png)

    - 클라이언트 관점에서의 피드백을 주는 Test Driven