import java.util.InputMismatchException;
import java.util.Scanner;

public class _15_Finally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("정수를 입력하세요 : ");
            int score = scanner.nextInt();

            if (score >= 60) {
                System.out.println("합격입니다.");
            } else {
                System.out.println("불합격입니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("키보드 입력이 올바르지 않습니다.");
        } catch (Exception e) {
            System.out.println("Error 발생 : " + e.getClass().getName());
        } finally {
            scanner.close();
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
