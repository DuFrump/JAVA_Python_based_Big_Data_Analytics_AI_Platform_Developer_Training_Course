import java.util.Scanner;

public class _18_Switch2 {
    public static void main(String[] args) {
        // 1등 100만원, 2등 50만원, 3등 50만원
        // 그 외 없음

        Scanner sc = new Scanner(System.in);

        System.out.printf("당신의 등수를 입력하세요 : ");
        int ranking = sc.nextInt();

        switch(ranking) {
            case 1:
                System.out.println("장학금 100만원.");
                break;
            case 2, 3:
                System.out.println("장학금 50만원.");
                break;
            default:
                System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
        }

        // if else if else로 구현하기
        if(ranking == 1) {
            System.out.println("장학금 100만원.");
        } else if(ranking == 2 || ranking == 3) {
            System.out.println("장학금 50만원.");
        } else {
            System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
        }
    }
}
