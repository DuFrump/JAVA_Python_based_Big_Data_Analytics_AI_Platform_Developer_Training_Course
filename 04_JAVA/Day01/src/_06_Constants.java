// 상수(Constant)의 개념과 사용 이유를 배우는 예제입니다.

public class _06_Constants {
    public static void main(String[] args) {

        /*
         * [상수 (Constant)란?]
         * - 변수와 마찬가지로 데이터를 저장하는 공간이지만, "한 번만 값을 할당할 수 있는" 특별한 변수입니다.
         * - 즉, 프로그램이 실행되는 동안 절대 변하지 않는 값을 저장할 때 사용합니다.
         * - `final` 키워드를 사용하여 선언합니다.
         * - 이름은 관례적으로 모두 대문자로, 단어 사이는 밑줄(_)로 구분합니다. (SCREAMING_SNAKE_CASE)
         */

        // --- 상수 선언 예시 ---

        // 원주율(PI) 값은 변하지 않으므로 상수로 선언하는 것이 적합합니다.
        final double PI = 3.14159265359;

        // 대한민국의 국가 번호 또한 고정된 값입니다.
        final String KR_COUNTRY_CODE = "+82";

        // 태어난 날짜는 바뀌지 않는 정보이므로 상수로 관리할 수 있습니다.
        final String DATE_OF_BIRTH = "2001-07-18";


        // --- 상수는 값을 변경할 수 없습니다 ---
        // 아래 코드의 주석을 해제하면 컴파일 에러가 발생합니다.
        // PI = 3.14; // Error: cannot assign a value to final variable PI


        /*
         * [왜 변수 대신 상수를 사용할까?]
         *
         * 1. 실수의 방지 (안정성 향상)
         *    - 중요한 값이 코드 중간에 실수로 변경되는 것을 막아줍니다.
         *    - 예를 들어, 세금 계산에 사용되는 세율(TAX_RATE)이 실수로 변경되면 큰 문제가 발생할 수 있습니다.
         *
         * 2. 코드 가독성 향상
         *    - 이름만 보고도 "이 값은 절대 변하지 않는 중요한 값이구나"라고 즉시 파악할 수 있습니다.
         *    - `if (userGrade == 8)` 보다 `if (userGrade == ADMIN_GRADE)` 가 훨씬 이해하기 쉽습니다.
         *
         * 3. 유지보수 용이성
         *    - 프로그램 전체에서 사용되는 고정 값을 변경해야 할 때, 상수 선언부 한 곳만 수정하면 됩니다.
         *    - 예: 부가세율이 10%에서 11%로 변경될 경우, 상수 값만 0.10에서 0.11로 바꾸면 모든 계산에 일괄 적용됩니다.
         */

        // --- 상수 활용 예시: 원의 넓이 계산 ---
        int radius = 10; // 반지름
        // double area = 3.14159265359 * radius * radius; // PI 값을 직접 쓰는 것보다...
        double area = PI * radius * radius; // 상수를 사용하면 코드가 더 명확하고 안전해집니다.

        System.out.println("--- 상수 활용 예시 ---");
        System.out.println("반지름이 " + radius + "인 원의 넓이: " + area);
        System.out.println("제 생일은 " + DATE_OF_BIRTH + "이고, 국가코드는 " + KR_COUNTRY_CODE + " 입니다.");

    }
}