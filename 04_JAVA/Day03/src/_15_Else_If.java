import java.util.Scanner;

public class _15_Else_If {
    public static void main(String[] args) {
        int fav_num = 10;

        if(fav_num < 10) {
            System.out.println("좋아하는 숫자가 10보다 작군요.");
        } else if(fav_num > 10) {
            System.out.println("좋아하는 숫자가 10보다 크군요.");
        } else {
            System.out.println("좋아하는 숫자가 10이군요.");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력하세요 : ");
        int age = sc.nextInt();

        if(age > 19) {
            System.out.println("성인입니다");
        } else if(age > 13) {
            System.out.println("청소년입니다.");
        } else if(age > 6) {
            System.out.println("어린이입니다.");
        } else {
            System.out.println("유아입니다.");
        }

    }
}
