/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 자바에서 예외를 '던지는(throw)' 두 가지 주요 방법과
 * '던져진 예외를 선언하는(throws)' 방법을 보여줍니다.
 *
 * [throw 키워드]
 * 개발자가 특정 조건에서 '새로운 예외 객체'를 직접 만들어서 발생시킬 때 사용합니다.
 * 예를 들어, 메소드의 입력값이 유효하지 않을 때 'IllegalArgumentException'을 던질 수 있습니다.
 *
 * [throws 키워드]
 * 메소드 선언부에 사용되며, '이 메소드는 실행 중에 이런 종류의 예외를 발생시킬 수 있습니다'라고
 * 호출하는 쪽에 미리 알려주는 역할을 합니다. 이는 일종의 '경고' 또는 '책임 전가'입니다.
 * 이 예외를 처리할 책임은 이 메소드를 호출하는 쪽에 있습니다.
 *
 * [비유]
 * 'throw'는 '경찰관이 범인을 현장에서 체포하는(예외 발생)' 것과 같습니다.
 * 'throws'는 '경찰관이 무전으로 "지금 범인이 도주 중입니다!"라고 보고하는(예외 선언)' 것과 같습니다.
 * 무전을 받은 다른 경찰관(호출자)은 그 범인을 잡을 준비(try-catch)를 해야 합니다.
 */
import java.util.InputMismatchException; // 사용자 입력 타입 불일치 예외
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스

public class _16_ThrowException {

    /**
     * 사용자의 성격 유형을 확인하는 메소드입니다.
     * 이 메소드는 내부적으로 {@code scanner.nextInt()}를 사용하며,
     * 만약 사용자가 정수가 아닌 값을 입력하면 {@code InputMismatchException}이 발생할 수 있습니다.
     * 메소드 선언부에 {@code throws InputMismatchException}을 명시하여,
     * 이 메소드를 호출하는 쪽에서 해당 예외를 처리해야 함을 알립니다.
     *
     * @param scanner 사용자 입력을 위한 Scanner 객체
     * @throws InputMismatchException 사용자가 정수가 아닌 값을 입력했을 때 발생
     * @throws IllegalArgumentException 사용자가 1 또는 2가 아닌 다른 정수를 입력했을 때 발생 (직접 throw)
     */
    public static void checkYourself(Scanner scanner) throws InputMismatchException, IllegalArgumentException {
        System.out.println("1. 사람과 어울리는 것이 좋다. 2. 혼자 있는 것이 좋다.");
        System.out.print("선택 : ");
        // scanner.nextInt()에서 InputMismatchException이 발생할 수 있습니다.
        // 이 예외는 이 메소드에서 직접 처리하지 않고, 호출한 곳(main 메소드)으로 '던져집니다'.
        int check = scanner.nextInt();

        // 개발자가 특정 조건에서 직접 예외를 'throw'하는 예시입니다.
        // 사용자가 1 또는 2가 아닌 다른 정수를 입력했을 때,
        // 유효하지 않은 인자(argument)라는 의미의 IllegalArgumentException을 발생시킵니다.
        if (check < 1 || check > 2) {
            // 'throw new 예외클래스()' 형태로 새로운 예외 객체를 생성하여 던집니다.
            throw new IllegalArgumentException("선택은 1 또는 2만 가능합니다. 입력값: " + check);
        }

        if (check == 1) {
            System.out.println("당신은 ENFP");
        } else { // check == 2
            System.out.println("당신은 ISFP");
        }
    }

    /**
     * 프로그램의 시작점인 main 메소드입니다.
     * {@code checkYourself} 메소드에서 발생할 수 있는 예외를 처리합니다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체는 try 블록 밖에서 선언하여 finally에서 접근 가능하게 합니다.

        try {
            System.out.println("===== 성격 유형 검사를 시작합니다 ====");
            // checkYourself 메소드를 호출합니다.
            // 이 메소드에서 InputMismatchException 또는 IllegalArgumentException이 발생하면
            // 이 main 메소드의 catch 블록에서 잡히게 됩니다.
            _16_ThrowException.checkYourself(scanner);
        }
        // InputMismatchException을 처리하는 catch 블록
        catch (InputMismatchException e) {
            System.out.println("오류: 키보드 입력이 잘못 되었습니다. 정수를 입력해주세요.");
        }
        // IllegalArgumentException을 처리하는 catch 블록
        catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
        // 그 외 예상치 못한 모든 예외를 처리하는 catch 블록 (항상 마지막에 위치)
        catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다: " + e.getClass().getName());
        }
        // finally 블록: 예외 발생 여부와 관계없이 항상 실행됩니다.
        // 여기서는 Scanner 자원을 안전하게 닫아줍니다.
        finally {
            // scanner 객체가 null이 아닌 경우에만 close()를 호출하여 NullPointerException을 방지합니다.
            // (이 예제에서는 try 밖에서 선언했으므로 null일 가능성은 낮지만, 안전한 습관입니다.)
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("프로그램을 종료합니다. (finally 블록 실행 완료)");
        }
    }
}