// `continue` 키워드의 사용법을 배우는 예제입니다.
// `continue`는 반복문 내에서 사용되며, 현재 반복(iteration)의 나머지 부분을 건너뛰고
// 다음 반복으로 즉시 진행하도록 합니다.

public class _06_Continue {
    public static void main(String[] args) {
        // 1부터 100까지의 숫자 중 짝수의 합계를 계산하는 예제
        int sum = 0; // 합계를 저장할 변수

        System.out.println("--- 1부터 100까지 짝수의 합계 (continue 사용) ---");
        for (int i = 1; i <= 100; i++) {
            // 만약 i가 홀수(2로 나누어 나머지가 0이 아니면)이면
            if (i % 2 != 0) {
                // `continue`를 만나면 현재 반복(i가 홀수인 경우)의 남은 부분(sum += i;)을 실행하지 않고,
                // 즉시 다음 반복(i++)으로 넘어갑니다.
                continue; 
            }
            // i가 짝수인 경우에만 이 코드가 실행됩니다.
            sum += i; // 짝수만 sum에 더해집니다.
        }

        System.out.printf("짝수의 합: %d%n", sum); // 출력: 2550

        System.out.println("
----------------------------------------
");

        // [참고] continue 없이 짝수의 합을 구하는 방법 (if 조건만 사용)
        int sumWithoutContinue = 0;
        System.out.println("--- 1부터 100까지 짝수의 합계 (continue 없이) ---");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) { // i가 짝수이면
                sumWithoutContinue += i;
            }
        }
        System.out.printf("짝수의 합: %d%n", sumWithoutContinue); // 출력: 2550
    }
}
