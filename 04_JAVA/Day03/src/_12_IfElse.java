// 조건문 `if-else`에 대해 배우는 예제입니다.
// `if-else` 문은 조건식이 참(true)일 때와 거짓(false)일 때 각각 다른 코드 블록을 실행합니다.

public class _12_IfElse {
    public static void main(String[] args) {
        // [1] 기본적인 if-else 문
        int num = 5;

        // 조건식: num > 4 (5는 4보다 큰가? -> true)
        if (num > 4) {
            // 조건식이 참(true)일 때 실행되는 블록
            System.out.println(num + "는 4보다 큽니다.");
        } else {
            // 조건식이 거짓(false)일 때 실행되는 블록
            System.out.println(num + "는 4보다 작거나 같습니다.");
        }

        System.out.println("
----------------------------------------
");

        // [2] 다른 변수를 이용한 if-else 문
        int a = 3;
        int b = 10;

        // 조건식: a > b (3은 10보다 큰가? -> false)
        if (a > b) {
            // 조건식이 참(true)일 때 실행되는 블록
            System.out.printf("%d는 %d보다 큽니다.
", a, b);
        } else {
            // 조건식이 거짓(false)일 때 실행되는 블록
            System.out.printf("%d는 %d보다 작거나 같습니다.
", a, b);
        }
    }
}
