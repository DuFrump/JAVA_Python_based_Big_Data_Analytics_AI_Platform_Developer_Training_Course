// 조건문 `switch`에 대해 배우는 예제입니다.
// `switch` 문은 하나의 변수(또는 표현식)의 값에 따라 여러 경우 중 하나를 선택하여 실행할 때 사용합니다.

import java.util.Scanner;

public class _17_Switch {
    public static void main(String[] args) {
        // [1] 기본적인 switch 문
        int num = 1;

        System.out.println("--- switch 예제 1 ---");
        switch(num) { // num 변수의 값을 기준으로 분기합니다.
            case 1: // num의 값이 1일 경우 이 블록을 실행합니다.
                System.out.println("숫자는 1입니다.");
                break; // `break`를 만나면 switch 문을 빠져나갑니다.
            case 7: // num의 값이 7일 경우 이 블록을 실행합니다.
                System.out.println("숫자는 7입니다.");
                break;
            default: // 위에 나열된 어떤 case에도 해당하지 않을 경우 이 블록을 실행합니다.
                System.out.println("1도 7도 아닙니다.");
                // default에는 보통 break를 생략하지만, switch 문 마지막에 위치하지 않는다면 break를 붙여야 합니다.
        }

        System.out.println("
----------------------------------------
");

        // [2] 사용자 입력을 받는 switch 문
        Scanner sc = new Scanner(System.in);

        System.out.print("1 ~ 5 사이의 숫자를 입력하세요 : ");
        int num1 = sc.nextInt();

        System.out.println("--- switch 예제 2 ---");
        switch(num1) {
            case 1:
                System.out.println("숫자는 1입니다.");
                break;
            case 2:
                System.out.println("숫자는 2입니다.");
                break;
            case 3:
                System.out.println("숫자는 3입니다.");
                break;
            case 4:
                System.out.println("숫자는 4입니다.");
                break;
            case 5:
                System.out.println("숫자는 5입니다.");
                break;
            default:
                System.out.println("1 ~ 5 사이의 숫자가 아닙니다.");
        }

        sc.close(); // Scanner 자원 해제

        // [중요] break 문이 없을 경우 (Fall-through)
        // break 문이 없으면 해당 case가 실행된 후 다음 case로 계속 진행됩니다.
        // 의도적으로 사용할 수도 있지만, 대부분의 경우 버그의 원인이 됩니다.
        System.out.println("
--- break 없는 switch (Fall-through) ---");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("월요일");
            case 2:
                System.out.println("화요일");
            case 3:
                System.out.println("수요일"); // day가 3이므로 여기서부터 실행
            case 4:
                System.out.println("목요일"); // break가 없으므로 이어서 실행
            default:
                System.out.println("주말"); // break가 없으므로 이어서 실행
        }
        // 출력: 수요일
        //       목요일
        //       주말
    }
}
