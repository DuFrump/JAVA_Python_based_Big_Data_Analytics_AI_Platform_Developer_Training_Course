// 조건 연산자(Conditional Operator)에 대해 배우는 예제입니다.
// 항이 3개라고 해서 "삼항 연산자(Ternary Operator)"라고도 부릅니다.
// 간단한 if-else 문을 한 줄로 표현할 수 있어 코드를 간결하게 만들어 줍니다.

public class _17_Operator5 {
    public static void main(String[] args) {
        // [기본 구조]
        // 조건식 ? 값1(참일 때) : 값2(거짓일 때);

        // 예제 1: 조건식이 참인 경우
        // (7 > 1)은 참(true)이므로, 콜론(:) 앞의 값인 1이 선택되어 num 변수에 저장됩니다.
        int num = (7 > 1) ? 1 : 2;
        System.out.println("결과: " + num); // 출력: 1

        /*
        // 위 코드는 아래의 if-else 문과 완전히 동일합니다.
        if (7 > 1) {
            num = 1;
        } else {
            num = 2;
        }
        */

        System.out.println("--------------------------");

        // 예제 2: 두 수 중 더 큰 수(max)와 더 작은 수(min) 찾기
        int x = 1;
        int y = 5;

        // (x > y)는 거짓(false)이므로, 콜론(:) 뒤의 값인 y가 선택되어 max 변수에 저장됩니다.
        int max = (x > y) ? x : y;
        System.out.println("최대값: " + max); // 출력: 5

        // (x > y)는 거짓(false)이므로, 콜론(:) 뒤의 값인 x가 선택되어 min 변수에 저장됩니다.
        // (x < y) ? x : y; 로 조건을 바꾸면 더 직관적으로 이해할 수 있습니다.
        int min = (x < y) ? x : y;
        System.out.println("최소값: " + min); // 출력: 1
    }
}
