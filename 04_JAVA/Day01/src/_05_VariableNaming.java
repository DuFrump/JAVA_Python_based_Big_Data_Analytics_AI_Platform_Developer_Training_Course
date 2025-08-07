// 변수 이름을 짓는 규칙(Naming Convention)에 대해 배우는 예제입니다.
public class _05_VariableNaming {
    public static void main(String[] args) {
        /**
         * 자바 변수 명명 규칙 (Java Variable Naming Conventions)
         *
         * 1. 저장할 값에 어울리는 이름: 변수가 어떤 데이터를 저장하는지 명확히 알 수 있도록 이름을 짓습니다. (예: 'a' 보다는 'age')
         * 2. 사용 가능 문자: 밑줄(_), 문자(a-z, A-Z), 숫자(0-9)를 사용할 수 있습니다. (공백 사용 불가)
         * 3. 시작 문자: 숫자로 시작할 수 없습니다. 밑줄(_)이나 문자로 시작해야 합니다.
         * 4. 단어 조합 방식 (자바에서는 주로 카멜 케이스를 권장합니다):
         *    - 카멜 케이스(Camel Case): 첫 단어는 소문자로, 이후 단어들의 첫 글자는 대문자로 작성합니다. (예: flightNumber)
         *    - 스네이크 케이스(Snake Case): 단어들을 밑줄(_)로 연결하고 모두 소문자로 작성합니다. (예: flight_number)
         * 5. 예약어 사용 불가: 자바에서 문법적으로 의미를 가지는 단어(public, static, void, int 등)는 변수명으로 사용할 수 없습니다.
         * 6. 상수(Constant) 명명 규칙: 모든 글자를 대문자로 작성하고, 단어 사이는 밑줄(_)로 구분합니다. (예: MAX_VALUE)
         */

        // 아래는 입국 신고서(arrival card)를 예시로 변수명을 지어본 것입니다.

        // 스네이크 케이스(snake_case) 명명 규칙을 사용한 예시
        String nationality = "대한민국";
        String first_name = "길동";
        String last_name = "홍";
        String date_of_birth = "2001-07-18";
        String residental_address = "라마호텔";
        String purpose_of_visit = "business";

        // 변수명에는 숫자도 포함될 수 있습니다.
        String flight_no_01 = "KE234";
        String flight_no_02 = "ER345";

        // 의미를 알기 어려운 변수명 (나쁜 예시)
        String item1 = "passport";
        String item2 = "mobile_phone";
        // 아래처럼 의미를 명확하게 작성하는 것이 좋습니다.
        String personalItem1 = "iPad";


        // 상수(Constant) 선언: final 키워드를 사용합니다.
        // 상수는 프로그램 실행 중에 값을 변경할 수 없는 변수입니다.
        // 상수명은 관례적으로 '모두 대문자'로 작성합니다.
        final String CODE ="KR";
        // CODE = "US"; // 주석을 해제하면 컴파일 에러가 발생합니다. (final 변수에는 새로운 값을 할당할 수 없음)
        System.out.println("국가 코드는 " + CODE + "입니다.");
    }
}
