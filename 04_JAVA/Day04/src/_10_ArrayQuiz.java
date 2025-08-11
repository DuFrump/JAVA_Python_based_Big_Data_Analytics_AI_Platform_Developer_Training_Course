/**
 * 두프룸프님, 드디어 퀴즈 시간입니다! 이번 퀴즈는 '로또 당첨 시뮬레이션'이에요.
 * 1등에 당첨될 때까지 컴퓨터가 자동으로 로또 번호를 계속 생성하고, 당첨 여부를 확인하는 프로그램이죠.
 * 이 퀴즈를 통해 배열, 난수, 반복문, 조건문을 모두 활용하는 종합적인 문제 해결 능력을 기를 수 있습니다.
 *
 * [퀴즈의 규칙 (아주 어려운 버전!)]
 * 1. 1~45 사이의 숫자 6개를 무작위로 뽑습니다. (이때, 중복된 숫자가 나올 수 있습니다!)
 * 2. 미리 정해진 1등 당첨번호와 내가 뽑은 번호를 '순서대로' 하나씩 비교합니다.
 * 3. 6개 숫자의 순서와 값이 모두 완벽하게 일치해야만 1등으로 인정됩니다.
 *
 * 과연 1등에 당첨되려면 몇 번이나 시도해야 할까요? 지금부터 코드를 분석하며 그 여정을 따라가 봅시다!
 */
import java.util.*; // 나중에 더 복잡한 기능을 쓸 때를 대비해 미리 import 해놓는 좋은 습관입니다.

public class _10_ArrayQuiz {
    public static void main(String[] args) {
        // [1단계] 1등 당첨 번호를 미리 정해둡니다.
        int[] winLotto = {6, 11, 17, 33, 39, 42};
        int tryCount = 0; // 로또를 몇 번 구매했는지 세는 변수

        System.out.println("--- 로또 1등, 될 때까지 사보자! 시뮬레이션 시작! ---");

        // [2단계] 당첨될 때까지 무한 반복!
        while(true) {
            tryCount++; // 일단 로또를 한 장 샀으니 시도 횟수 1 증가
            int matchCount = 0; // 이번 회차에서 맞춘 번호의 개수 (매 회차 새로 세어야 하니 0으로 초기화)
            int[] myLotto = new int[6]; // 내가 새로 뽑은 번호 6개를 저장할 배열

            // [2-1] 나의 로또 번호 6개를 1~45 사이 난수로 생성합니다.
            for (int i = 0; i < myLotto.length; i++) {
                myLotto[i] = (int)(Math.random() * 45) + 1;
            }

            // [2-2] 당첨 번호와 내 번호를 첫 번째 자리부터 순서대로 비교합니다.
            // System.out.printf("[%d회차] 내 번호: %s%n", tryCount, Arrays.toString(myLotto)); // (참고) 내 번호 확인용
            for (int i = 0; i < myLotto.length; i++) {
                // winLotto의 i번째 숫자와 myLotto의 i번째 숫자가 일치하는지 확인
                if (winLotto[i] == myLotto[i]) {
                    matchCount++; // 일치하면 맞춘 개수 1 증가
                }
            }

            // [2-3] 6개 숫자가 모두 일치하는지(1등인지) 확인합니다.
            if (matchCount == 6) {
                System.out.printf("\n*** 드디어 1등 당첨!!! ***%n");
                System.out.println("당첨 번호: " + Arrays.toString(winLotto));
                System.out.println("내 번호:   " + Arrays.toString(myLotto));
                System.out.printf("총 %d회 시도만에 당첨되었습니다!%n", tryCount);
                break; // 1등에 당첨되었으니 while(true) 루프를 탈출!
            }

            // (참고) 너무 오래 걸리면 진행 상황을 보고 싶을 수 있으니, 백만 번에 한 번씩 메시지를 출력해봅시다.
            if (tryCount % 1000000 == 0) {
                System.out.printf("... %d회 시도 중 ... 아직 당첨되지 않았습니다 ...%n", tryCount);
            }
        }

        // [더 나아가기] 지금 만든 로또는 중복 번호가 나올 수 있고, 순서까지 맞아야 하는 아주 어려운 버전입니다.
        // 실제 로또처럼 '중복 없는 6개의 숫자'를 뽑고, '순서에 상관없이' 번호만 맞으면 되는
        // 시뮬레이션을 만들려면 어떻게 해야 할까요?
        // 힌트: 중복을 허용하지 않는 자료구조인 'HashSet'에 대해 공부해보세요!
        //       파일 아래에 주석 처리된 코드를 참고하면 큰 도움이 될 거예요.
    }
}