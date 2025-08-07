import java.util.InputMismatchException;
import java.util.Scanner;

public class _14_Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] cards = {4, 5, 1, 2, 7, 8};
            System.out.print("몇 번째 카드를 뽑겠습니까? : ");
            int cardIndex = scanner.nextInt();
            System.out.println("뽑은 카드 번호는 : " + cards[cardIndex - 1]);
        } catch(InputMismatchException e) {
            System.out.println("정수만 입력해주세요.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 번호에 해당하는 카드가 존재하지 않습니다.");
        } catch(Exception e) {
            System.out.println("예외 클래스 : " + e.getClass().getName());
        }

        System.out.println("프로그램 종료");
        scanner.close();
    }
}
