// `switch` 문에서 여러 `case`를 묶어서 처리하는 방법과 이를 `if-else if-else` 문으로 구현하는 예제입니다.

import java.util.Scanner;

public class _18_Switch2 {
    public static void main(String[] args) {
        // 장학금 지급 기준:
        // 1등: 100만원
        // 2등, 3등: 50만원
        // 그 외: 없음

        Scanner sc = new Scanner(System.in);

        System.out.print("당신의 등수를 입력하세요 : ");
        int ranking = sc.nextInt();

        System.out.println("
--- switch 문으로 구현 ---");
        // Java 12부터는 `case`에 여러 값을 콤마(,)로 구분하여 지정할 수 있습니다.
        switch(ranking) {
            case 1: // ranking이 1일 경우
                System.out.println("장학금 100만원.");
                break;
            case 2, 3: // ranking이 2 또는 3일 경우
                System.out.println("장학금 50만원.");
                break;
            default: // 위에 해당하지 않는 모든 경우
                System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
        }

        System.out.println("
--- if-else if-else 문으로 구현 ---");
        // 동일한 로직을 if-else if-else 문으로 구현할 수 있습니다.
        if(ranking == 1) {
            System.out.println("장학금 100만원.");
        } else if(ranking == 2 || ranking == 3) { // ranking이 2이거나 3일 경우
            System.out.println("장학금 50만원.");
        } else {
            System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
        }

        sc.close(); // Scanner 자원 해제
    }
}
