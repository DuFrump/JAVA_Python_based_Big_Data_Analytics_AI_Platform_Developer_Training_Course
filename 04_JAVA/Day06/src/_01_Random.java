import java.util.Random; // Random 클래스를 사용하기 위해 먼저 'import'를 해줘야 해요.

/**
 * 두프룸프님, 안녕하세요!
 * 오늘은 자바에서 아주 유용하게 쓰이는 '난수(Random Number)'에 대해 배워볼 거예요.
 * 난수란 무작위로 만들어지는 숫자를 의미하는데, 게임에서 아이템을 뽑거나,
 * 로또 번호를 생성하는 것처럼 예측할 수 없는 숫자가 필요할 때 사용된답니다.
 *
 * 이 예제에서는 `java.util.Random` 클래스를 이용해서
 * 1. 정수 난수 만들기
 * 2. 실수 난수 만들기
 * 3. 특정 범위의 난수 만들기
 * 등을 함께 실습해 볼 거예요. 코드를 하나씩 따라가면서 원리를 이해해 봅시다!
 */
public class _01_Random {
    public static void main(String[] args) {
        // 1. Random 객체 생성하기
        // 난수를 만들려면 먼저 Random 클래스의 설계도를 바탕으로 실제 기능을 하는 '객체(object)'를 만들어야 해요.
        // 'new Random()' 코드가 바로 'Random 객체를 하나 만들어줘!' 라는 의미랍니다.
        Random random = new Random();

        // 2. 여러가지 난수 만들어보기
        System.out.println("--- 다양한 종류의 난수를 만들어 볼까요? ---");

        // [정수 난수]
        // nextInt() 메서드는 int가 표현할 수 있는 모든 범위(-21억 ~ +21억)에서 무작위 정수 하나를 뽑아줘요.
        System.out.printf("int 전체 범위의 랜덤 정수: %d%n", random.nextInt());

        // nextInt(숫자) 메서드는 0부터 '숫자-1'까지의 범위에서 정수 하나를 뽑아요.
        // 예를 들어 random.nextInt(10)은 0, 1, 2, ... , 9 중에서 하나를 뽑아준답니다.
        System.out.printf("0부터 9까지의 랜덤 정수: %d%n", random.nextInt(10));

        // [실수 난수]
        // nextDouble() 메서드는 0.0 이상 1.0 미만의 소수(double) 하나를 뽑아줘요.
        System.out.printf("0.0 이상 1.0 미만의 랜덤 실수: %f%n", random.nextDouble());

        System.out.println("----------------------------------------");

        // 3. 특정 범위의 난수 응용하기
        System.out.println("--- 특정 범위를 지정해서 난수를 만들어봐요! ---");

        // [5.0 이상 10.0 미만의 실수 뽑기]
        // nextDouble()이 0.0 ~ 1.0 사이의 값을 주니까, 여기에 5를 곱하면 0.0 ~ 5.0 사이의 값이 되겠죠?
        // 거기에 5를 더해주면? 최종적으로 5.0 ~ 10.0 사이의 실수를 얻을 수 있어요.
        // 공식: (random.nextDouble() * (최대값 - 최소값)) + 최소값
        double randomDouble = (random.nextDouble() * 5.0) + 5.0;
        System.out.printf("5.0 이상 10.0 미만의 랜덤 실수: %f%n", randomDouble);

        // [1 이상 46 미만(즉, 1~45)의 정수 뽑기]
        // 로또 번호처럼 1부터 45 사이의 숫자를 뽑고 싶을 때 사용할 수 있어요.
        // random.nextInt(시작값, 끝값+1) 형태로 사용하면 된답니다.
        int lottoNumber = random.nextInt(1, 46); // 1 (포함) 부터 46 (미포함) 까지의 정수
        System.out.printf("1부터 45까지의 랜덤 정수 (로또 번호처럼!): %d%n", lottoNumber);

        // [참고] Math.random() 이라는 것도 있어요!
        // 이건 Random 클래스 객체를 만들지 않고도 바로 사용할 수 있는 방법이에요.
        // 0.0 이상 1.0 미만의 실수를 반환하는 점은 random.nextDouble()과 같아요.
        // 이걸 이용해서 1~45 사이의 정수를 만들려면 조금 더 복잡한 계산이 필요하답니다.
        // (int)(Math.random() * 45) + 1; -> 0~44까지의 정수를 만든 뒤 +1 하는 방식이죠.
    }
}