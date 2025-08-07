// `java.util.Random` 클래스를 사용하여 다양한 종류의 난수(Random Number)를 생성하는 방법을 배우는 예제입니다.
// 난수는 게임, 시뮬레이션, 암호화 등 다양한 분야에서 활용됩니다.

import java.util.Random; // Random 클래스를 사용하기 위해 import 합니다.

public class _01_Random {
    public static void main(String[] args) {
        // 1. Random 객체 생성
        // Random 클래스의 인스턴스를 생성하여 난수 생성 기능을 사용합니다.
        Random random = new Random();

        // [1] 정수 난수 생성
        // nextInt(): int 타입의 모든 범위 내에서 무작위 정수를 반환합니다.
        System.out.printf("랜덤 정수 (전체 범위): %d%n", random.nextInt());

        // nextInt(int bound): 0 (포함)부터 지정된 bound (미포함) 사이의 정수를 반환합니다.
        // 예: random.nextInt(10) -> 0, 1, 2, ..., 9 중 하나의 정수
        System.out.printf("랜덤 정수 (0 ~ 9): %d%n", random.nextInt(10));

        // [2] 실수 난수 생성
        // nextDouble(): 0.0 (포함)부터 1.0 (미포함) 사이의 double 값을 반환합니다.
        System.out.printf("랜덤 실수 (0.0 ~ 1.0 미만): %.3f%n", random.nextDouble());

        System.out.println("
----------------------------------------
");

        // [3] 특정 범위의 실수 난수 생성
        // 5.0 이상 10.0 미만의 실수를 뽑기
        // (random.nextDouble() * (최대값 - 최소값)) + 최소값
        // (random.nextDouble() * (10.0 - 5.0)) + 5.0
        System.out.printf("랜덤 실수 (5.0 ~ 10.0 미만): %.3f%n", (random.nextDouble() * 5) + 5);

        // [4] 특정 범위의 정수 난수 생성 (Java 7 이상)
        // nextInt(int origin, int bound): origin (포함)부터 bound (미포함) 사이의 정수를 반환합니다.
        // 1 ~ 45까지의 로또 번호 뽑기
        System.out.printf("랜덤 정수 (1 ~ 45): %d%n", random.nextInt(1, 46)); // 1 (포함), 46 (미포함)

        // [참고] Math.random()을 이용한 난수 생성
        // Math.random()은 0.0 이상 1.0 미만의 double 값을 반환합니다.
        // (int)(Math.random() * (최대값 - 최소값 + 1)) + 최소값
        // 예: 1부터 45까지의 정수 난수
        // (int)(Math.random() * 45) + 1;
    }
}
