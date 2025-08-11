/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 'try-catch-finally' 문에서 'finally' 블록의 역할을 보여줍니다.
 * 'finally' 블록은 예외 발생 여부와 관계없이 항상 실행되어야 하는 코드를 포함할 때 사용합니다.
 *
 * [finally 블록이란?]
 * 'try' 블록에서 예외가 발생하든 안 하든, 'catch' 블록에서 예외를 처리하든 안 하든,
 * 'finally' 블록 안의 코드는 무조건 실행됩니다.
 * 주로 파일 닫기, 네트워크 연결 해제, 데이터베이스 연결 종료 등
 * '자원(Resource) 정리' 작업을 수행할 때 사용됩니다.
 *
 * [비유]
 * 'finally' 블록은 '작업장 정리반'과 같습니다.
 * 작업(try)이 성공적으로 끝나든, 사고(예외)가 발생하든,
 * 작업장 정리반은 항상 마지막에 와서 사용된 도구를 정리하고(자원 해제),
 * 문을 잠그는(프로그램 종료 메시지) 일을 합니다.
 * 어떤 상황에서도 반드시 해야 하는 뒷정리라고 생각하시면 됩니다.
 */
import java.util.InputMismatchException; // 사용자 입력 타입 불일치 예외
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스

public class _15_Finally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        // 'try' 블록: 예외가 발생할 수 있는 코드
        try {
            System.out.print("정수를 입력하세요 : ");
            int score = scanner.nextInt(); // InputMismatchException 발생 가능성

            if (score >= 60) {
                System.out.println("합격입니다.");
            } else {
                System.out.println("불합격입니다.");
            }
        }
        // 'catch' 블록 1: InputMismatchException 처리
        catch (InputMismatchException e) {
            System.out.println("키보드 입력이 올바르지 않습니다. 정수를 입력해주세요.");
        }
        // 'catch' 블록 2: 그 외 모든 Exception 처리
        catch (Exception e) {
            System.out.println("예상치 못한 Error 발생 : " + e.getClass().getName());
        }
        // 'finally' 블록: 예외 발생 여부와 관계없이 항상 실행되는 코드
        // 이 블록은 try 블록이 정상적으로 완료되든, catch 블록이 실행되든,
        // 심지어 try 블록에서 return 문이 있더라도 항상 실행됩니다.
        finally {
            // Scanner 객체와 연결된 시스템 자원을 해제합니다.
            // 이는 프로그램이 종료되기 전에 반드시 수행되어야 하는 중요한 작업입니다.
            scanner.close();
            System.out.println("프로그램을 종료합니다. (finally 블록 실행)");
        }
        // finally 블록이 실행된 후, main 메소드의 나머지 코드가 있다면 실행됩니다.
        // 여기서는 더 이상 코드가 없으므로 프로그램이 종료됩니다.
    }
}