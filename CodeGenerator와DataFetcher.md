## Code Generator
- Code Genertator는 작성한 Schema를 기반으로 Java나 Kotlin 코드를 생성합니다.
- 해당 기능을 통해 개발자의 생선성을 늘릴 수 있고 코드 작성에서 발생할 수 있는 오류를 줄여줌.

### 특징
- 타입 안정성
  - GraphQL 스키마를 기반으로 타입 안전한 Kotlin 또는 Java 코드를 생성하여 런타입 시 발생할 수 있는 오류를 줄여줍니다. 
  [이를 통해서 컴파일 단계에서 오류를 발견할 수 있습니다.]()
- 개발 속도 향상
  - 수동으로 작성해야 할 모델, 요청 및 응답 클래스를 자동으로 생성해서 개발 시간을 절약할 수 있습니다.
  [특히 스키마가 자주 변경될 때 유용합니다.]()
- 류지보수성 향상
  - 스키마가 변경될 때마다 코드가 자동으로 갱신되므로, 개발자가 직접 코드를 수정할 필요가 줄어들어 유지보수가 쉬워집니다.

### 사용 방법
- gradle에 플러그인 삽입으로 사용가능
<img src="https://i.postimg.cc/HkychBjg/44.png">
- 추가 설정
<img src="https://i.postimg.cc/TPjyR1rN/55.png">
- Language : 생성된 코드의 언어 설정
- packageName : 생성된 패키지를 지정할 수 있는 패키지 이름
- typeMapping : 스키마에 작성된 타입이 코드로 변환될 때 타입을 지정


## DataFetcher

- GraphQL 쿼리, 뮤테이션, 서브스크립션 요청이 들어왓을 때, 특정 필드에 대한 데이터를 가져오는 로직을 구현한 컴포넌트
- 필요에 따라 데이터베이스나 API를 호출해서 데이터를 가져올 수 있다.
- CompletableFuture 반환을 통해 비동기 작업을 처리할 수 있다.

### REST API vs DataFetcher
<img src="https://i.postimg.cc/jdGCPPck/66.png" alt="same"/>

- 유사한 기능으로는 REST API의 Controller가 있습니다.
- 다른 점
  - 컨트롤러는 엔드포인트에 맵핑되지만, 데이터 패처는 반환할 Query의 필드에 맵핑된다.
  - 맵핑되는 필드는 객체 단위가 될 수도 단일 필드 단위가 될 수도 있다.

### 구현 방법
#### Annotation
1. @DgsComponent: DataFetcher 클래스를 선언하기 위해서 사용됨 (@RestController, @Controller와 유사)
2. @DgsData
<img src="https://i.postimg.cc/vBNGMwSS/77.png">
   - 사용 방법 : 맵핑 시킬 메서드를 선언하고 두 가지 매개변수를 사용합니다.
   - parentType : 해당 필드의 부모 타입을 지정, 해당 필드가 최상위라면 query, mutation, subscription 중 해당 하는 타입 지정
   - field : 맵핑할 필드명을 입력
   - 맵핑할 필드명이 메서드의 이름과 동일할 경우 생략 가능!
3. @DgsQuery @DgsMutation @DgsSubscription
   <img src="https://i.postimg.cc/13mRpB6B/88.png">
   - 사용법 : DgsData의 최상위 필드를 지정해줄때 parentType을 생략하여 타입을 지정해줄 수 있습니다.
4. @InputArgument
   - InputArgument는 RequestParam과 RequestBody와 같이 사용할 수 있습니다.
   <img src="https://i.postimg.cc/L8Wdn3Vn/99.png">