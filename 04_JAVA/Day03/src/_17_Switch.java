import java.util.Scanner;

public class _17_Switch {
    public static void main(String[] args) {
        int num = 1;

        switch(num) {
            case 1 :
                System.out.println("숫자는 1입니다.");
                break;
            case 7 :
                System.out.println("숫자는 7입니다.");
                break;
            default :
                System.out.println("1도 7도 아닙니다.");
        }

        Scanner sc = new Scanner(System.in);

        System.out.printf("1 ~ 5 사이의 숫자를 입력하세요 : ");
        int num1 = sc.nextInt();

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



    }
}
