import java.util.Scanner;

public class _04_Scanner_Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 a을 입력해주세요 : ");
        int a = sc.nextInt();

        System.out.println("숫자 b을 입력해주세요 : ");
        int b = sc.nextInt();

        String result = (a >= b) ? ((a == b) ? "a와 b는 같다." : "a는 b보다 크다.") : "a가 b보다 작다.";
        System.out.println(result);
    }
}
