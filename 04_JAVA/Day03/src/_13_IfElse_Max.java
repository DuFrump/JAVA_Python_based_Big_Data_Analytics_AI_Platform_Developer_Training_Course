// `if-else` 문을 사용하여 두 숫자 중 더 큰 값(최대값)을 찾는 예제입니다.

public class _13_IfElse_Max {
    public static void main(String[] args) {
        int a = 4;  // 첫 번째 숫자
        int b = 10; // 두 번째 숫자
        int max = 0; // 최대값을 저장할 변수, 초기값은 0으로 설정

        // 조건식: a > b (a가 b보다 큰가?)
        // 4 > 10 은 거짓(false)입니다.
        if(a > b) {
            // 조건식이 참(true)일 때 실행되는 블록: a가 더 크면 max에 a를 저장
            max = a;
        } else {
            // 조건식이 거짓(false)일 때 실행되는 블록: b가 더 크거나 같으면 max에 b를 저장
            max = b;
        }

        // 최종적으로 찾아낸 최대값을 출력합니다.
        System.out.printf("%d와 %d 중에 큰 수는 %d입니다.\n", a, b, max); // 출력: 4와 10 중에 큰 수는 10입니다.

        // 참고: 이 로직은 조건 연산자(삼항 연산자)로도 간단하게 표현할 수 있습니다.
        // int max_ternary = (a > b) ? a : b;
        // System.out.println("삼항 연산자 사용: " + max_ternary);
    }
}
