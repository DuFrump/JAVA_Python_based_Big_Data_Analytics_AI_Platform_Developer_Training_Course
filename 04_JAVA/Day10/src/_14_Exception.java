/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 자바의 모든 예외 클래스들의 '최상위 부모'인 'Exception' 클래스를
 * 'catch' 블록에서 사용하는 방법을 보여줍니다.
 *
 * [Exception 클래스란?]
 * 자바에서 발생하는 대부분의 예외(RuntimeException 포함)는 'Exception' 클래스를 상속받습니다.
 * 따라서 'catch (Exception e)' 블록은 어떤 종류의 예외든 모두 잡아낼 수 있는 '만능 캐처' 역할을 합니다.
 *
 * [언제 사용하고, 언제 주의해야 할까요?]
 * - **사용하는 경우**: 예상치 못한 모든 종류의 예외를 한 번에 처리하여 프로그램이 갑자기 종료되는 것을
 *   확실히 막고 싶을 때, 또는 개발 초기 단계에서 어떤 예외가 발생할지 정확히 모를 때 유용합니다.
 * - **주의할 점**: 너무 광범위하게 'Exception'을 잡으면, 어떤 종류의 예외가 발생했는지 정확히 알기 어렵고,
 *   각 예외에 맞는 섬세한 처리를 하기 어렵습니다. 마치 모든 병을 '감기'로 진단하는 것과 같습니다.
 *   따라서 가능한 한 구체적인 예외를 먼저 잡고, 'Exception'은 마지막 '최후의 보루'로 사용하는 것이 좋습니다.
 *
 * [비유]
 * 'catch (Exception e)'는 '종합병원'의 '일반의'와 같습니다.
 * 어떤 증상이든 일단 진료를 볼 수 있습니다. 반면, 'catch (InputMismatchException e)'나
 * 'catch (ArrayIndexOutOfBoundsException e)'는 '내과 의사'나 '정형외과 의사'처럼
 * 특정 증상(예외)에 특화된 전문가입니다.
 * 가장 좋은 방법은 먼저 전문의에게 진료를 받고, 그래도 해결되지 않으면 일반의에게 가는 것이겠죠?
 */
import java.util.InputMismatchException; // 사용자 입력 타입 불일치 예외
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스

public class _14_Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] cards = {4, 5, 1, 2, 7, 8}; // 6개의 요소를 가진 배열 (인덱스 0~5)
            System.out.print("몇 번째 카드를 뽑겠습니까? (1~6 사이의 숫자) : ");
            // 1. 사용자 입력: 숫자가 아닌 다른 것을 입력하면 InputMismatchException 발생 가능
            int cardIndex = scanner.nextInt();

            // 2. 배열 접근: 사용자가 1~6 범위를 벗어난 인덱스(예: 0 또는 7 이상)를 입력하면 ArrayIndexOutOfBoundsException 발생 가능
            //    사용자에게는 1부터 시작하는 번호를 받으므로, 배열 인덱스(0부터 시작)에 맞게 -1을 해줍니다.
            System.out.println("뽑은 카드 번호는 : " + cards[cardIndex - 1]);
        }
        // 첫 번째 catch 블록: InputMismatchException을 처리합니다. (가장 구체적인 예외)
        catch (InputMismatchException e) {
            System.out.println("잘못 입력 하셨습니다. 정수만 입력해주세요.");
        }
        // 두 번째 catch 블록: ArrayIndexOutOfBoundsException을 처리합니다. (두 번째로 구체적인 예외)
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("해당 번호의 카드는 존재하지 않습니다. 1부터 6 사이의 숫자를 입력해주세요.");
        }
        // 세 번째 catch 블록: Exception 클래스를 잡습니다. (가장 일반적인 예외)
        // 위 두 개의 catch 블록에서 처리되지 않은 '모든' 종류의 예외를 여기서 잡습니다.
        // 이 블록은 항상 가장 마지막에 위치해야 합니다.
        catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다.");
            // 어떤 종류의 예외가 잡혔는지 확인하고 싶을 때 유용합니다.
            System.out.println("발생한 예외 클래스: " + e.getClass().getName());
            // e.printStackTrace(); // 디버깅을 위해 예외의 전체 스택 트레이스를 출력할 수도 있습니다.
        }

        System.out.println("프로그램 종료.");
        // Scanner 자원을 닫아줍니다.
        scanner.close();
    }
}