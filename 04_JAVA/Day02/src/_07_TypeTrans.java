// 데이터 타입 변환(Type Casting, 형변환)에 대해 배우는 예제입니다.

public class _07_TypeTrans {
    public static void main(String[] args) {
        int num1 = 11;
        double num2 = 3.14;

        // [자동(묵시적) 형변환 - Promotion]
        // 표현 범위가 작은 타입과 큰 타입을 연산하면, 작은 타입이 큰 타입으로 자동 변환됩니다.
        // int(4 bytes) + double(8 bytes) -> double + double
        // 데이터 손실이 없습니다.
        double result1 = num1 + num2; // 11.0 + 3.14
        System.out.println(result1); // 출력: 14.14

        // [강제(명시적) 형변환 - Casting]
        // (타입)변수명; 의 형태로 변수 앞에 변환할 타입을 명시적으로 적어줍니다.

        // 1. int -> double (데이터 손실 없음)
        double num3 = (double)num1; // 정수 11을 실수 11.0으로 강제 변환
        System.out.println(num3); // 출력: 11.0

        // 2. double -> int (데이터 손실 발생!)
        // 실수 타입이 정수 타입으로 변환되면서 소수점 이하 부분이 잘려나갑니다.
        System.out.println((int)1.23); // 출력: 1
        System.out.println((int)num2); // 3.14 -> 3, 출력: 3

        System.out.println("--------------------------------");

        // [주의] 강제 형변환 시 데이터 손실(Overflow)
        // 큰 데이터 타입의 값을 작은 데이터 타입의 표현 범위를 벗어나는 경우,
        // 예상치 못한 값(쓰레기값)이 저장될 수 있습니다.
        int a = 128;
        // byte의 표현 범위는 -128 ~ 127 입니다.
        // 128은 byte의 범위를 벗어나므로, 값이 순환(wrap around)되어 최솟값부터 다시 시작합니다.
        byte b = (byte)a;
        System.out.println(b); // 출력: -128

        // 자동 형변환 예시 (int -> double)
        int c = 33;
        double d = c; // int 타입인 c가 double 타입 변수 d에 저장되면서 자동으로 33.0으로 형변환됨
        System.out.println(d); // 출력: 33.0
    }
}
