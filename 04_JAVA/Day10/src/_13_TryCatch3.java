/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 하나의 'try' 블록에서 발생할 수 있는 여러 종류의 예외를
 * 각각 다른 'catch' 블록으로 처리하는 방법을 보여줍니다.
 * 이는 프로그램의 안정성을 높이고, 사용자에게 더 구체적인 오류 메시지를 제공하는 데 중요합니다.
 *
 * [여러 catch 블록 사용하기]
 * 마치 환자의 증상에 따라 '내과 의사', '외과 의사' 등 전문의가 다른 것처럼,
 * 자바에서도 발생한 예외의 종류에 따라 적절한 'catch' 블록이 해당 예외를 처리합니다.
 *
 * [주의사항]
 * 여러 catch 블록을 사용할 때는 '더 구체적인(자식) 예외'를 먼저 처리하고,
 * '더 일반적인(부모) 예외'를 나중에 처리해야 합니다.
 * (예: Exception은 모든 예외의 부모이므로, 항상 가장 마지막 catch 블록에 와야 합니다.)
 */
import java.util.InputMismatchException; // 사용자 입력 타입 불일치 예외
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스

public class _13_TryCatch3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 'try' 블록: 두 가지 종류의 예외가 발생할 수 있는 코드를 포함합니다.
        try {
            int[] cards = {4, 5, 1, 2, 7, 8}; // 6개의 요소를 가진 배열 (인덱스 0~5)
            System.out.print("몇 번째 카드를 뽑겠습니까? (1~6 사이의 숫자) : ");
            // 1. 사용자 입력: 숫자가 아닌 다른 것을 입력하면 InputMismatchException 발생 가능
            int cardIndex = scanner.nextInt();

            // 2. 배열 접근: 사용자가 1~6 범위를 벗어난 숫자를 입력하면 ArrayIndexOutOfBoundsException 발생 가능
            //    사용자에게는 1부터 시작하는 번호를 받으므로, 배열 인덱스(0부터 시작)에 맞게 -1을 해줍니다.
            System.out.println("뽑은 카드 번호는 : " + cards[cardIndex - 1]);
        }
        // 첫 번째 'catch' 블록: InputMismatchException을 처리합니다.
        // 사용자가 정수가 아닌 문자열 등을 입력했을 때 이 블록이 실행됩니다.
        catch (InputMismatchException e) {
            System.out.println("잘못 입력 하셨습니다. 정수만 입력해주세요.");
        }
        // 두 번째 'catch' 블록: ArrayIndexOutOfBoundsException을 처리합니다.
        // 사용자가 배열의 유효 범위를 벗어난 인덱스(예: 0 또는 7 이상)를 입력했을 때 이 블록이 실행됩니다.
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 번호의 카드는 존재하지 않습니다. 1부터 6 사이의 숫자를 입력해주세요.");
        }
        // 만약 다른 종류의 예외가 발생한다면, 이 두 catch 블록으로는 잡을 수 없습니다.
        // 그럴 경우 프로그램은 비정상 종료됩니다. (다음 예제에서 일반 예외 처리 방법을 배울 거예요!)

        System.out.println("프로그램 종료.");
        // Scanner 자원을 닫아줍니다. 이는 항상 finally 블록이나 try-with-resources를 사용하는 것이 좋습니다.
        scanner.close();
    }
}