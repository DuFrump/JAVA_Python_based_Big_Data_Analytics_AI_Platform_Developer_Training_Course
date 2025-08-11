/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 'try-catch' 문을 사용하여 사용자로부터 입력을 받을 때 발생할 수 있는
 * 'InputMismatchException (입력 불일치 예외)'을 처리하는 방법을 보여줍니다.
 * 사용자 입력은 예상치 못한 형태일 수 있으므로, 예외 처리는 사용자 친화적인 프로그램을 만드는 데 필수적입니다.
 *
 * [InputMismatchException이란?]
 * 예를 들어, 프로그램이 숫자 입력을 기대하는데 사용자가 문자열을 입력했을 때 발생하는 예외입니다.
 *
 * [비유]
 * '자동 판매기'가 '동전'을 넣으라고 하는데, 사용자가 '지폐'를 넣으려고 하는 상황과 같습니다.
 * 판매기는 "이건 동전이 아니잖아!"라고 거부하며 예외를 발생시키지만,
 * try-catch를 통해 "죄송합니다. 동전만 넣어주세요."와 같이 친절하게 안내하고
 * 프로그램이 멈추지 않도록 할 수 있습니다.
 */
import java.util.InputMismatchException; // InputMismatchException을 사용하기 위해 import 합니다.
import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 import 합니다.

public class _12_TryCatch2 {
    public static void main(String[] args) {
        // Scanner 객체를 생성하여 사용자로부터 콘솔 입력을 받을 준비를 합니다.
        Scanner scanner = new Scanner(System.in);

        // 'try' 블록: 예외가 발생할 수 있는 사용자 입력 관련 코드를 이 안에 작성합니다.
        try {
            System.out.print("점수를 입력하세요 : ");
            // scanner.nextInt()는 사용자로부터 정수(int) 입력을 기대합니다.
            // 만약 사용자가 정수가 아닌 다른 형태(예: 문자열, 소수)를 입력하면
            // 'InputMismatchException'이 발생합니다.
            int score = scanner.nextInt();

            // 점수에 따른 합격/불합격 판정 로직
            if (score >= 65) {
                System.out.println("합격입니다.");
            } else {
                System.out.println("불합격입니다.");
            }
        }
        // 'catch' 블록: 'try' 블록에서 'InputMismatchException'이 발생했을 때 처리합니다.
        catch (InputMismatchException inputMismatchException) {
            // 예외가 발생했을 때 사용자에게 친절한 메시지를 출력하여 잘못된 입력을 알립니다.
            System.out.println("오류: 숫자를 입력해주세요.");
            // 예외 객체 'inputMismatchException'을 통해 더 자세한 정보를 얻을 수도 있습니다.
            // inputMismatchException.printStackTrace(); // 디버깅 시 유용
        }
        // finally 블록은 없지만, try-catch 블록이 끝나면 항상 실행되는 코드를 작성할 수 있습니다.
        // 여기서는 Scanner 자원을 닫는 코드가 해당됩니다.

        // Scanner 객체가 사용했던 시스템 자원(입력 스트림)을 해제합니다.
        // 이는 매우 중요한 습관입니다. 자원을 사용한 후에는 반드시 닫아주어야 합니다.
        scanner.close();
        System.out.println("프로그램 종료.");
    }
}