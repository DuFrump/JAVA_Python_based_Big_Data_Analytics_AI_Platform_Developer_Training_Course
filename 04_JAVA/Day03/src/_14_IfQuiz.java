// 사용자로부터 나이를 입력받아 성인 또는 미성년자를 판별하는 퀴즈입니다.
// `if-else` 조건문을 활용합니다.

import java.util.Scanner;

public class _14_IfQuiz {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성: 사용자 입력을 받기 위해 필요합니다.
        Scanner sc = new Scanner(System.in);

        // 2. 사용자에게 나이 입력 요청 메시지 출력
        System.out.print("나이를 입력하세요 : ");

        // 3. 사용자로부터 정수형 나이를 입력받아 age 변수에 저장
        int age = sc.nextInt();

        // 4. `if-else` 조건문을 사용하여 나이에 따라 다른 메시지 출력
        // 조건식: age >= 19 (나이가 19세 이상인가?)
        if (age >= 19) {
            // 조건식이 참(true)일 때 실행: 성인인 경우
            System.out.println("성인입니다.");
        } else {
            // 조건식이 거짓(false)일 때 실행: 미성년자인 경우
            System.out.println("미성년자입니다.");
        }

        // 5. Scanner 자원 해제
        sc.close();
    }
}
