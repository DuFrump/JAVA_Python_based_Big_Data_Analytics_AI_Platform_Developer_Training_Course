// 조건문(Conditional Statement) `if`에 대해 배우는 예제입니다.
// `if` 문은 특정 조건이 참(true)일 때만 코드 블록을 실행합니다.

import java.util.Scanner;

public class _10_If1 {
    public static void main(String[] args) {
        int result = 0;

        // [1] 기본적인 if 문
        // 조건식 (3 > 4)은 거짓(false)이므로, if 블록 안의 코드는 실행되지 않습니다.
        if(3 > 4) { // 조건식이 거짓이므로 이 블록은 건너뜀
            result = 3;
        }
        System.out.println("if (3 > 4) 결과: " + result); // 출력: 0 (result는 초기값 그대로)

        System.out.println("
----------------------------------------
");

        // [2] if-else if-else 문
        // 여러 개의 조건을 순차적으로 검사하여, 가장 먼저 참이 되는 조건의 블록을 실행합니다.
        // 모든 조건이 거짓일 경우 `else` 블록이 실행됩니다.

        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요 : ");

        int age = sc.nextInt();

        if (age >= 19) { // 첫 번째 조건: 나이가 19세 이상인가?
            System.out.println("성인입니다.");
        } else if(age >= 8) { // 두 번째 조건: 나이가 8세 이상인가? (첫 번째 조건이 거짓일 때만 검사)
            System.out.println("학생입니다.");
        } else { // 모든 조건이 거짓일 때 (나이가 8세 미만일 때)
            System.out.println("어린이/유아입니다.");
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close(); // Scanner 자원 해제
    }
}
