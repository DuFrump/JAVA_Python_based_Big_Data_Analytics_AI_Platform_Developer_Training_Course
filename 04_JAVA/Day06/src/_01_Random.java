import java.util.Random;

public class _01_Random {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.printf("랜덤 정수 : %d%n", random.nextInt());
        System.out.printf("랜덤 정수 (범위 10) : %d%n", random.nextInt(10)); // 0 ~ 9까지의 정수가 나오게 된다.
        System.out.printf("랜덤 실수 : %.3f%n", random.nextDouble()); // 0.0 이상 1.0 미만 실수

        // 5.0 이상 10.0 미만의 실수를 뽑기
        System.out.printf("랜덤 실수 : %.3f%n", (random.nextDouble() * 5) + 5); // 5.0 이상 10.0 미만 실수

        // 1 ~ 45 까지 로또 번호 뽑기
        System.out.printf("랜덤 정수 (범위 45) : %d%n", random.nextInt(1, 46)); // 1 ~ 45까지의 정수가 나오게 된다.

    }
}
