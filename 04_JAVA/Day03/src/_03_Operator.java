// 중첩된 조건 연산자(삼항 연산자)를 사용하여 세 가지 경우를 판별하는 예제입니다.

public class _03_Operator {
    public static void main(String[] args) {

        // [1] 기본적인 삼항 연산자: 두 가지 경우(크다/작다) 판별
        int a = 11;
        int b = 11;

        // 조건식: a > b
        // 참일 경우: "a가 크다!"
        // 거짓일 경우: "a가 작다!" (여기서는 같다는 경우를 고려하지 않음)
        String result = a > b ? "a가 크다!" : "a가 작다!";
        System.out.println("단순 비교 결과: " + result);

        System.out.println("
----------------------------------------
");

        // [2] 중첩된 삼항 연산자: 세 가지 경우(크다/작다/같다) 판별
        // 구조: (첫 번째 조건식) ? (첫 번째 조건식이 참일 때의 결과) : (첫 번째 조건식이 거짓일 때의 결과)
        // 거짓일 때의 결과 자리에 또 다른 삼항 연산자를 넣어서 중첩시킵니다.

        // (a >= b) ? (a == b ? "a와 b는 같다." : "a는 b보다 크다.") : "a는 b보다 작다.";
        // 1. (a >= b)를 먼저 평가합니다.
        //    - 만약 참(true)이면, (a == b ? "a와 b는 같다." : "a는 b보다 크다.") 이 부분을 평가합니다.
        //      - (a == b)가 참이면 "a와 b는 같다." 반환
        //      - (a == b)가 거짓이면 "a는 b보다 크다." 반환
        //    - 만약 거짓(false)이면, "a는 b보다 작다."를 반환합니다.
        result = (a >= b) ? (a == b ? "a와 b는 같다." : "a는 b보다 크다.") : "a는 b보다 작다.";
        System.out.println("중첩 비교 결과: " + result);

        /*
        // 위 중첩 삼항 연산자는 아래의 if-else if-else 문과 동일한 로직입니다.
        // 가독성 측면에서는 if-else if-else 문이 더 좋을 수 있습니다.
        if (a >= b) {
            if (a == b) {
                System.out.println("a와 b는 같다.");
            } else { // a > b 인 경우
                System.out.println("a는 b보다 크다.");
            }
        } else { // a < b 인 경우
            System.out.println("a는 b보다 작다.");
        }
        */
    }
}
