# Mock을 마주하는 자세
## Test Double
- Dummy : 아무 것도 하지 않는 깡통 객체
- Fake : 단순한 형태로 동일한 기능은 수행하나, 프로덕션에서 쓰기에는 부족한 객체(ex.Fake Repository)
- Stub : 테스트에서 요청한 것에 대해 미리 준비한 결과를 제공하는 객체. 그 외에는 응답하지 않는다.
- Spy : Stub이면서 호출된 내용을 기록하여 보여줄 수 있는 객체. 일부는 실제 객체처럼 동작시키고 일부만 Stubbing 할 수 있다.
- Mock : 행위에 대한 기대를 명세하고, 그에 따라 동작하도록 만들어진 객체
- Stub은 상태 검증(Status Verification)이고 Mock은 행위 검증(Behavior Verification)이다.
## Classicist vs Mockist
- Classicist : 테스트 코드에서 Mock을 사용하지 않는다. 테스트 대상 코드와 테스트 코드를 분리하고, 테스트 대상 코드의 행위를 검증한다.
  - 외부 시스템은 모킹하고 내부 시스템은 모킹을 하지 않는다. 외부 시스템은 에러가 발생할 케이스만 대응해서 테스트 코드를 작성한다.
- Mockist : 테스트 코드에서 Mock을 사용한다. 테스트 대상 코드의 행위를 검증한다.

