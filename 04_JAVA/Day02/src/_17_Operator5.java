/**
 * 자바의 연산자 중에서 "조건 연산자(Conditional Operator)"에 대해 배웁니다.
 * 이 연산자는 피연산자가 세 개라고 해서 "삼항 연산자(Ternary Operator)"라고도 부릅니다.
 * 간단한 `if-else` 문을 한 줄로 간결하게 표현할 수 있어 코드를 더 깔끔하게 만들 때 유용합니다.
 */

public class _17_Operator5 {
    public static void main(String[] args) {

        // ------------------- 조건 연산자의 기본 구조 -------------------
        // `조건식 ? 값1(참일 때) : 값2(거짓일 때);`
        // - `조건식`: `true` 또는 `false`를 반환하는 식 (주로 비교 연산자나 논리 연산자를 사용)
        // - `값1`: 조건식이 `true`일 때 선택될 값
        // - `값2`: 조건식이 `false`일 때 선택될 값

        // 예제 1: 간단한 조건에 따른 값 선택
        // (7 > 1)은 참(true)이므로, 콜론(:) 앞의 값인 1이 선택되어 `num` 변수에 저장됩니다.
        int num = (7 > 1) ? 1 : 2;
        System.out.println("조건 (7 > 1)이 참일 때 결과: " + num); // 출력: 1

        // 위 코드는 아래의 `if-else` 문과 완전히 동일한 기능을 합니다.
        /*
        int numIfElse;
        if (7 > 1) {
            numIfElse = 1;
        } else {
            numIfElse = 2;
        }
        System.out.println("if-else 결과: " + numIfElse); // 출력: 1
        */

        System.out.println("--------------------------");

        // 예제 2: 두 수 중 더 큰 수(max)와 더 작은 수(min) 찾기
        int x = 1;
        int y = 5;

        // 최대값 찾기:
        // `(x > y)`는 `(1 > 5)`이므로 거짓(false)입니다.
        // 따라서 콜론(:) 뒤의 값인 `y` (5)가 선택되어 `max` 변수에 저장됩니다.
        int max = (x > y) ? x : y;
        System.out.println("최대값: " + max); // 출력: 5

        // 최소값 찾기:
        // `(x < y)`는 `(1 < 5)`이므로 참(true)입니다.
        // 따라서 콜론(:) 앞의 값인 `x` (1)가 선택되어 `min` 변수에 저장됩니다.
        int min = (x < y) ? x : y;
        System.out.println("최소값: " + min); // 출력: 1

        System.out.println("--------------------------");

        // 예제 3: 홀수/짝수 판별
        int number = 7;
        // `number % 2 == 0`은 `7 % 2 == 0` (1 == 0)이므로 거짓(false)입니다.
        // 따라서 콜론(:) 뒤의 문자열 "홀수입니다."가 선택되어 `resultString`에 저장됩니다.
        String resultString = (number % 2 == 0) ? "짝수입니다." : "홀수입니다.";
        System.out.println(number + "은(는) " + resultString); // 출력: 7은(는) 홀수입니다.

        number = 10;
        // `number % 2 == 0`은 `10 % 2 == 0` (0 == 0)이므로 참(true)입니다.
        // 따라서 콜론(:) 앞의 문자열 "짝수입니다."가 선택되어 `resultString`에 저장됩니다.
        resultString = (number % 2 == 0) ? "짝수입니다." : "홀수입니다.";
        System.out.println(number + "은(는) " + resultString); // 출력: 10은(는) 짝수입니다.

        // [활용] 조건에 따라 다른 값을 변수에 대입하거나, 메소드의 인자로 전달할 때 유용합니다.
        // 코드를 더 간결하고 가독성 있게 만들 수 있습니다.
    }
}