// Scanner를 사용하여 사용자로부터 두 개의 숫자를 입력받고,
// 중첩된 조건 연산자(삼항 연산자)를 활용하여 두 숫자의 크기를 비교하는 예제입니다.

import java.util.Scanner;

public class _04_Scanner_Operator {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성: 사용자 입력을 받기 위해 필요합니다.
        Scanner sc = new Scanner(System.in);

        // 2. 첫 번째 숫자 입력받기
        System.out.print("숫자 a를 입력해주세요 : ");
        int a = sc.nextInt(); // 사용자로부터 정수 값을 입력받아 변수 a에 저장

        // 3. 두 번째 숫자 입력받기
        System.out.print("숫자 b를 입력해주세요 : ");
        int b = sc.nextInt(); // 사용자로부터 정수 값을 입력받아 변수 b에 저장

        // 4. 중첩된 조건 연산자를 사용하여 a와 b의 크기 비교
        // (a >= b) ? (a == b ? "a와 b는 같다." : "a는 b보다 크다.") : "a가 b보다 작다.";
        // - 만약 a가 b보다 크거나 같으면 (a >= b)가 참(true)이 됩니다.
        //   - 이 경우, 다시 (a == b)를 평가합니다.
        //     - (a == b)가 참이면 "a와 b는 같다."를 결과로 반환합니다.
        //     - (a == b)가 거짓이면 (즉, a > b 이면) "a는 b보다 크다."를 결과로 반환합니다.
        // - 만약 a가 b보다 크거나 같지 않으면 (a >= b)가 거짓(false)이 됩니다.
        //   - 이 경우, 콜론(:) 뒤의 값인 "a가 b보다 작다."를 결과로 반환합니다.
        String result = (a >= b) ? ((a == b) ? "a와 b는 같다." : "a는 b보다 크다.") : "a가 b보다 작다.";

        // 5. 비교 결과 출력
        System.out.println(result);

        // 6. Scanner 자원 해제
        sc.close();
    }
}
