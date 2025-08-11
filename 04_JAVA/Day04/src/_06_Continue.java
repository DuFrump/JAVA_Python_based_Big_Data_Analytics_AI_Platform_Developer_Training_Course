/**
 * 두프룸프님, 안녕하세요! 이번에는 반복문의 흐름을 내 마음대로 제어하는
 * 아주 재미있는 키워드, 'continue'에 대해 배워볼 거예요.
 * continue는 '계속하다'라는 뜻이지만, 프로그래밍에서는 조금 다르게 쓰여요.
 * 반복문 안에서 continue를 만나면, '이번 판은 여기서 끝! 다음 판으로 바로 넘어가자!' 라는 의미랍니다.
 * 즉, continue 아래에 있는 코드들은 모두 무시하고 즉시 다음 반복으로 점프하는 거죠.
 *
 * 이 예제에서는 1부터 100까지의 숫자 중 '홀수는 건너뛰고 짝수만 더하는' 로직을 통해
 * continue의 역할을 확실하게 이해해 볼 거예요.
 * 특정 조건을 만족하는 녀석들만 쏙쏙 골라내고 싶을 때 아주 유용하답니다!
 */
public class _06_Continue {
    public static void main(String[] args) {
        // 1부터 100까지의 숫자 중 짝수의 합계를 계산해봅시다.
        int sum = 0;

        System.out.println("--- 1부터 100까지 짝수의 합계 (continue 활용) ---");
        for (int i = 1; i <= 100; i++) {
            System.out.println("현재 i 값: " + i);

            // 만약 i를 2로 나눈 나머지가 0이 아니라면? -> 홀수라는 뜻!
            if (i % 2 != 0) {
                // "아, i가 홀수네? 그럼 이번 차례는 여기서 끝!"
                // continue를 만나는 순간, 아래에 있는 sum += i; 코드는 실행되지 않고
                // 바로 for문의 증감식(i++)으로 점프해서 다음 반복을 시작합니다.
                System.out.println("-> 홀수이므로 패스! 다음으로 넘어갑니다.");
                continue;
            }

            // 이 코드는 i가 짝수일 때만 실행될 수 있어요. 왜냐하면 홀수일 땐 위에서 continue가 실행되니까요.
            System.out.println("-> 짝수 발견! 합계에 더합니다.");
            sum += i;
        }

        System.out.printf("\n최종 짝수 합계: %d%n", sum);

        System.out.println("\n----------------------------------------\n");

        // [참고] 사실 이 코드는 continue 없이 if문만으로도 간단하게 작성할 수 있어요.
        // continue는 코드를 더 읽기 쉽게 만들어 줄 때 사용하는 것이 좋습니다.
        // 예를 들어, 복잡한 조건들을 위쪽에서 미리 걸러내고 싶을 때 유용하죠.
        int sumWithoutContinue = 0;
        System.out.println("--- 1부터 100까지 짝수의 합계 (if문만 사용) ---");
        for (int i = 1; i <= 100; i++) {
            // i가 짝수일 '때만' 더하기를 실행하는, 더 직관적인 코드입니다.
            if (i % 2 == 0) {
                sumWithoutContinue += i;
            }
        }
        System.out.printf("if문만으로 계산한 짝수 합계: %d%n", sumWithoutContinue);
        System.out.println("\n결론: 두 방법 모두 결과는 같지만, 상황에 따라 더 읽기 좋은 코드를 선택하는 것이 중요해요!");
    }
}