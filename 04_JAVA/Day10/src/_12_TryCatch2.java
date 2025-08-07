import java.util.InputMismatchException;
import java.util.Scanner;

public class _12_TryCatch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("점수를 입력하세요 : ");
            int score = scanner.nextInt();

            if (score >= 65) {
                System.out.println("합격입니다.");
            } else {
                System.out.println("불합격입니다.");
            }
        } catch(InputMismatchException inputMismatchException) {
            System.out.println("숫자를 입력해주세요.");
        }

        scanner.close();
        System.out.println("프로그램 종료");
    }
}
