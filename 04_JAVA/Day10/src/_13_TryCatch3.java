import java.util.InputMismatchException;
import java.util.Scanner;

public class _13_TryCatch3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] cards = {4, 5, 1, 2, 7, 8};
            System.out.print("몇 번째 카드를 뽑겠습니까? : ");
            int cardIndex = scanner.nextInt();
            System.out.println("뽑은 카드 번호는 : " + cards[cardIndex - 1]);
        } catch(InputMismatchException e) {
            System.out.println("잘못 입력 하셨습니다. 정수만 입력해주세요.");
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 번호의 카드는 존재하지 않습니다.");
        }

        System.out.println("프로그램 종료");
        scanner.close();
    }
}
