// 배열(Array)에 난수(Random Number)를 저장하고, 짝수의 합을 계산하며,
// `while(true)` 반복문과 `break`를 사용하여 특정 조건이 될 때까지 반복하는 예제입니다.

public class _09_Array2 {
    public static void main(String[] args) {
        // 주석 처리된 이전 코드 (1회 실행 예제)
        /*
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            // Math.random()은 0.0 이상 1.0 미만의 double 값을 반환합니다.
            // (int)(Math.random() * 30) + 1: 1부터 30까지의 정수 난수를 생성합니다.
            numbers[i] = (int)(Math.random() * 30) + 1;
        }

        int sum = 0;

        for (int i = 0; i < numbers.length ; i++) {
            if (numbers[i] % 2 == 0) { // 배열 요소가 짝수인지 확인
                sum += numbers[i]; // 짝수이면 합계에 더함
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d번째 난수 (1 ~ 30 사이) : %d%n", i + 1, numbers[i]);
        }

        System.out.printf("짝수 합산 : %d%n", sum);
        System.out.println(Math.pow(0.5, 10)); // 0.5의 10승 계산 (예시용)
        */

        System.out.printf("%n%n===============================================%n");

        // [2] `while(true)`와 `break`를 이용한 반복 실행 예제
        // `while(true)`는 무한 루프를 의미하며, 특정 조건이 충족될 때 `break` 문으로 루프를 종료합니다.
        int count = 0; // 총 반복 횟수를 세는 변수

        while (true) { // 무한 반복 시작
            System.out.println("
--- 새로운 난수 배열 생성 및 짝수 합산 ---");
            int sum = 0; // 각 반복마다 합계를 초기화

            int[] numbers = new int[10]; // 10개의 정수를 저장할 배열 생성

            // 배열에 1부터 30까지의 난수 10개 저장
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int)(Math.random() * 30) + 1;
            }

            // 배열의 짝수 요소 합산
            for (int i = 0; i < numbers.length ; i++) {
                if (numbers[i] % 2 == 0) {
                    sum += numbers[i];
                }
            }

            // 생성된 난수 배열 출력
            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("%d번째 난수 (1 ~ 30 사이) : %d%n", i + 1, numbers[i]);
            }

            System.out.printf("짝수 합산 : %d%n", sum);
            count += 1; // 반복 횟수 증가

            // [종료 조건] 짝수의 합이 0이 되면 반복을 종료합니다.
            if(sum == 0){ // 1부터 30까지의 난수 중 짝수가 하나도 없을 경우 (매우 낮은 확률)
                System.out.println("짝수의 합이 0이 되어 반복을 종료합니다.");
                break; // `while(true)` 루프를 빠져나갑니다.
            }
        }

        System.out.println();
        System.out.println("총 반복 횟수 : " + count);

    }
}
