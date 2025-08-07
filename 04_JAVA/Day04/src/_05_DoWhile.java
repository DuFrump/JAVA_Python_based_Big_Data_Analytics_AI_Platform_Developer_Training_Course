// `do-while` 반복문의 기본적인 사용법을 배우는 예제입니다.
// `do-while` 문은 `while` 문과 달리 조건식을 나중에 검사하므로, 최소 한 번은 코드 블록이 실행됩니다.

public class _05_DoWhile {
    public static void main(String[] args) {
        // [1] 1부터 10까지의 합계 계산 예제
        int sum = 0; // 합계를 저장할 변수
        int i = 1;   // 반복을 위한 카운터 변수 (초기화)

        // do {
        //     반복할 코드
        //     증감식
        // } while (조건식);
        // - `do` 블록 안의 코드를 먼저 한 번 실행합니다.
        // - 그 후 `while`의 조건식을 평가합니다. 조건식이 참(true)이면 `do` 블록을 다시 실행합니다.
        // - 조건식이 거짓(false)이 되면 반복을 종료합니다.
        do {
            System.out.println("식사는 하셨습니까?"); // 최소 한 번은 출력됩니다.
            sum += i; // sum = sum + i; 와 동일
            i++;      // i = i + 1; 와 동일
        } while (i <= 10); // i가 10보다 작거나 같은 동안 반복

        System.out.println("1부터 10까지의 합계: " + sum); // 출력: 55

        System.out.println("
----------------------------------------
");

        // [2] `do-while` 문이 최소 한 번 실행됨을 보여주는 예제
        int j = 11;
        System.out.println("--- do-while 최소 1회 실행 예제 ---");
        do {
            System.out.println("이 메시지는 최소 한 번 출력됩니다. (j = " + j + ")");
            j++;
        } while (j <= 10); // 조건식은 거짓(11 <= 10 -> false)이지만, 이미 한 번 실행됨

        System.out.println("반복 종료 후 j: " + j);
    }
}
