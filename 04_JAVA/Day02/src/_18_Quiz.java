// 사용자로부터 키를 입력받아 놀이기구 탑승 가능 여부를 판단하는 퀴즈입니다.
// 조건 연산자(삼항 연산자)를 활용합니다.

import java.util.Scanner;

public class _18_Quiz {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성: 사용자 입력을 받기 위해 필요합니다.
        Scanner sc = new Scanner(System.in);

        // 2. 사용자에게 키 입력 요청 메시지 출력
        System.out.print("당신의 키는 몇 cm입니까? : ");

        // 3. 사용자로부터 키(실수)를 입력받아 height 변수에 저장
        double height = sc.nextDouble();

        // 4. 조건 연산자(삼항 연산자)를 사용하여 탑승 가능 여부 판단
        // 조건식: height > 120 (키가 120cm보다 큰가?)
        // 참일 경우: "탑승 가능하십니다."
        // 거짓일 경우: "탑승 불가능하십니다."
        String result = (height > 120) ? "탑승 가능하십니다." : "탑승 불가능하십니다.";

        // 5. 결과 출력
        System.out.println(result);

        // 6. Scanner 자원 해제
        sc.close();
    }
}
