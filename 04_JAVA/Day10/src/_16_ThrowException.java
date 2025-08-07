import java.util.InputMismatchException;
import java.util.Scanner;

public class _16_ThrowException {
    public static void checkYourself(Scanner scanner) throws InputMismatchException {
        System.out.println("1. 사람과 어울리는 것이 좋다. 2. 혼자 있는 것이 좋다.");
        System.out.print("선택 : ");
        int check = scanner.nextInt();

        if (check == 1) {
            System.out.println("당신은 ENFP");
        } else {
            System.out.println("당신은 ISFP");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("===== 성격 유형 검사를 시작합니다 =====");
            // 메서드 호출
            _16_ThrowException.checkYourself(scanner);
        } catch(InputMismatchException e) {
            System.out.println("키보드 입력이 잘못 되었습니다.");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
