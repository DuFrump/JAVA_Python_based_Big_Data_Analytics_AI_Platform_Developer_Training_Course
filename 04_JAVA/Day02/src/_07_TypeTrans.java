/**
 * 데이터 타입 변환(Type Casting, 형변환)에 대해 배웁니다.
 * 형변환은 한 데이터 타입을 다른 데이터 타입으로 바꾸는 것을 의미합니다.
 * 예를 들어, 정수(int)를 실수(double)로 바꾸거나, 실수를 정수로 바꾸는 것과 같습니다.
 */
public class _07_TypeTrans {
    public static void main(String[] args) {
        int num1 = 11;
        double num2 = 3.14;

        // ------------------- 1. 자동(묵시적) 형변환 (Promotion) -------------------
        // - 작은 크기의 데이터 타입이 큰 크기의 데이터 타입으로 자동으로 변환되는 경우입니다.
        // - 데이터 손실이 전혀 발생하지 않습니다. (안전한 변환)
        // - 예를 들어, int(4 bytes)와 double(8 bytes)을 연산하면, int가 double로 자동 변환됩니다.
        //   (int + double) -> (double + double) -> double

        System.out.println("--- 자동 형변환 예시 ---");
        double result1 = num1 + num2; // num1(int)이 num2(double)에 맞춰 double 11.0으로 자동 변환됩니다.
                                     // 계산: 11.0 + 3.14 = 14.14
        System.out.println("int + double 결과: " + result1); // 출력: 14.14

        // 또 다른 자동 형변환 예시: int를 double 변수에 저장
        int intValue = 100;
        double doubleValue = intValue; // intValue(100)가 doubleValue에 저장될 때 100.0으로 자동 변환됩니다.
        System.out.println("int -> double 자동 변환: " + doubleValue); // 출력: 100.0

        System.out.println("--------------------------------");

        // ------------------- 2. 강제(명시적) 형변환 (Casting) -------------------
        // - 큰 크기의 데이터 타입을 작은 크기의 데이터 타입으로 강제로 변환하는 경우입니다.
        // - (변환할 타입)변수명; 의 형태로 변수 앞에 괄호 안에 변환할 타입을 명시적으로 적어줍니다.
        // - 데이터 손실이 발생할 수 있으므로 주의해야 합니다.

        System.out.println("--- 강제 형변환 예시 ---");

        // 예시 1: double -> int (소수점 이하 버림)
        // 실수를 정수로 강제 변환하면 소수점 이하 부분이 버려집니다.
        System.out.println("1.23을 int로 강제 변환: " + (int)1.23); // 출력: 1
        System.out.println("num2(3.14)를 int로 강제 변환: " + (int)num2); // 출력: 3

        // 예시 2: int -> double (데이터 손실 없음, 하지만 명시적으로 변환)
        // 이 경우는 자동 형변환도 가능하지만, 명시적으로 변환할 수도 있습니다.
        double num3 = (double)num1; // 정수 11을 실수 11.0으로 강제 변환
        System.out.println("num1(11)을 double로 강제 변환: " + num3); // 출력: 11.0

        System.out.println("--------------------------------");

        // ------------------- [중요] 강제 형변환 시 데이터 손실 (Overflow/Underflow) -------------------
        // 큰 데이터 타입의 값이 작은 데이터 타입의 표현 범위를 벗어나는 경우,
        // 예상치 못한 값(쓰레기값)이 저장될 수 있습니다. 이를 오버플로우(Overflow) 또는 언더플로우(Underflow)라고 합니다.

        int largeInt = 128; // byte의 최대값(127)보다 1 큰 값
        // byte의 표현 범위는 -128 ~ 127 입니다.
        // 128은 byte의 범위를 벗어나므로, 강제 형변환 시 값이 순환(wrap around)되어 최솟값부터 다시 시작합니다.
        byte convertedByte = (byte)largeInt;
        System.out.println("128을 byte로 강제 변환: " + convertedByte); // 출력: -128

        int negativeInt = -129; // byte의 최소값(-128)보다 1 작은 값
        byte convertedByte2 = (byte)negativeInt;
        System.out.println("-129를 byte로 강제 변환: " + convertedByte2); // 출력: 127

        System.out.println("이처럼 강제 형변환 시에는 데이터 손실에 유의해야 합니다.");
    }
}