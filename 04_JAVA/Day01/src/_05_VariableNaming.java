// 변수 이름을 짓는 규칙(Naming Convention)과 좋은 이름의 중요성에 대해 배우는 예제입니다.

public class _05_VariableNaming {
    public static void main(String[] args) {

        /*
         * [변수 이름, 왜 중요할까?]
         * - 좋은 변수 이름은 코드의 가독성을 높여 다른 사람(그리고 미래의 나)이 코드를 쉽게 이해하도록 돕습니다.
         * - 변수 이름만 보고도 "이 변수가 어떤 데이터를 담고 있겠구나"라고 예측할 수 있어야 합니다.
         * - 예시: `int a = 20;` (나쁜 예) vs `int userAge = 20;` (좋은 예)
         */

        // --- 1. 변수 명명 규칙 (필수) ---
        // 1-1. 사용 가능 문자: 영문자(a-z, A-Z), 숫자(0-9), 밑줄(_), 달러($) 기호를 사용할 수 있습니다.
        // 1-2. 시작 문자: 숫자로 시작할 수 없습니다. (예: `int 1stPlace;` -> 에러)
        // 1-3. 공백 사용 불가: 단어 사이에 공백을 넣을 수 없습니다. (예: `String user name;` -> 에러)
        // 1-4. 예약어 사용 불가: `public`, `class`, `static`, `int` 등 자바 문법에서 사용하는 키워드는 이름으로 쓸 수 없습니다.

        // --- 2. 명명 관례 (권장) ---
        // 자바 개발자들 사이의 약속으로, 코드의 일관성과 가독성을 위해 지키는 것이 좋습니다.
        /*
         * ----------------------------------------------------------------------
         * | 구분          | 명명 규칙          | 예시                           |
         * |---------------|--------------------|--------------------------------|
         * | 클래스 (Class)  | 파스칼 케이스      | public class UserInfo          |
         * |               | (PascalCase)       | public class CarController     |
         * |---------------|--------------------|--------------------------------|
         * | 변수 (Variable) | 카멜 케이스        | String userName;               |
         * | 메소드 (Method) | (camelCase)        | int userAge;                   |
         * |               |                    | void printUserInfo() {}        |
         * |---------------|--------------------|--------------------------------|
         * | 상수 (Constant) | 스크리밍 스네이크  | final int MAX_SPEED = 300;     |
         * |               | (SCREAMING_SNAKE)  | final double PI = 3.14159;    |
         * ----------------------------------------------------------------------
         */

        // --- 예시 코드로 규칙 살펴보기 ---

        // 입국 신고서(arrival card) 정보를 변수에 저장하는 예시
        String nationality = "대한민국";         // 국적
        String firstName = "길동";             // 이름 (성을 제외)
        String lastName = "홍";              // 성
        String dateOfBirth = "2001-07-18";   // 생년월일
        String residentialAddress = "서울시 강남구"; // 거주지 주소
        String purposeOfVisit = "관광";        // 방문 목적

        // 숫자를 포함한 변수명 (주로 여러 개를 구분할 때 사용)
        String flightNo1 = "KE234";
        String flightNo2 = "OZ102";

        // 의미를 알기 어려운 변수명 (나쁜 예시)
        String a = "여권";
        int b = 1;
        // 위 보다는 아래처럼 의미를 명확하게 작성하는 것이 훨씬 좋습니다.
        String item = "여권";
        int itemCount = 1;


        // 상수(Constant) 선언: `final` 키워드를 사용합니다.
        // 상수는 프로그램이 실행되는 동안 절대 변하지 않는 값을 의미합니다.
        // 예: 원주율(PI), 최대 허용 속도, 국가 코드 등
        final String COUNTRY_CODE = "KR"; // 국가 코드는 바뀌지 않는 값이므로 상수로 선언

        // COUNTRY_CODE = "US"; // 주석을 해제하면 컴파일 에러가 발생합니다. (final 변수에는 값을 다시 할당할 수 없음)

        System.out.println("국가 코드는 " + COUNTRY_CODE + "입니다.");
    }
}