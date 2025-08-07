// 산술 연산자(Arithmetic Operator)와 대입 연산자(Assignment Operator)에 대해 배우는 예제입니다.

public class _15_Operator3 {
    public static void main(String[] args) {
        // [1] 산술 연산자: +, -, *, /, %
        int x = 100;
        int y = 200;
        double z = 3.14;

        System.out.println("--- 기본 산술 연산 ---");
        System.out.println(x + y); // 덧셈: 300
        System.out.println(x - y); // 뺄셈: -100
        System.out.println(x * y); // 곱셈: 20000

        // [중요] 정수 나눗셈: 정수와 정수의 나눗셈 결과는 항상 정수(몫)입니다. 소수점 이하는 버려집니다.
        System.out.println(x / y); // 100 / 200 = 0.5 이지만, 몫인 0이 결과값

        // 나머지 연산자(%): 나눗셈의 나머지를 구합니다.
        System.out.println(x % y); // 100을 200으로 나눈 나머지: 100

        // 다른 타입과의 연산: int + double -> double + double (자동 형변환)
        System.out.println(y + z); // 200 + 3.14 = 203.14

        // [주의] 연산 결과의 오버플로우(Overflow)
        // int 타입의 최대 표현 범위(약 21억)를 넘어서는 계산 결과는 잘못된 값(쓰레기값)을 만듭니다.
        int result = 100000 * 100000; // 실제 결과는 100억이지만, int 범위를 넘어섬
        System.out.println("int 오버플로우 결과: " + result); // 잘못된 음수 값이 출력될 수 있음
        // 해결: long 타입을 사용해야 합니다.
        long longResult = 100000L * 100000L;
        System.out.println("long 정상 결과: " + longResult);

        System.out.println("\n--- 대입(복합 대입) 연산자 ---");
        // a = a + b  ->  a += b
        // a = a - b  ->  a -= b
        // a = a * b  ->  a *= b
        // a = a / b  ->  a /= b
        // a = a % b  ->  a %= b

        x = 10;
        y = 1;

        // y = y + x; 와 동일
        y += x; // y = 1 + 10
        System.out.println("y += x : " + y); // 11

        y -= x; // y = 11 - 10
        System.out.println("y -= x : " + y); // 1

        y += 20; // y = 1 + 20
        System.out.println("y += 20 : " + y); // 21

        y *= x; // y = 21 * 10
        System.out.println("y *= x : " + y); // 210

        y %= x; // y = 210 % 10 (210을 10으로 나눈 나머지)
        System.out.println("y %= x : " + y); // 0

        System.out.println("\n--- 정확한 나눗셈 결과 얻기 ---");
        System.out.println("정수 나눗셈 (5 / 2): " + (5 / 2)); // 몫인 2가 나옴
        // 잘못된 형변환: (5/2) 연산이 먼저 수행되어 결과가 2가 된 후, float으로 변환해도 2.0이 됨
        System.out.println("잘못된 형변환 ((float)(5 / 2)): " + (float)(5 / 2));
        // 올바른 형변환: 두 피연산자 중 하나를 먼저 실수 타입으로 만들어야 전체 연산이 실수 연산이 됨
        System.out.println("올바른 형변환 ((float)5 / 2): " + ((float)5 / 2)); // 2.5
        System.out.println("나머지 (5 % 2): " + (5 % 2)); // 1
    }
}
