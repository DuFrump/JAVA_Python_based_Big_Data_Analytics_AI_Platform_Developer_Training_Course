// 증가/감소 연산자(++, --)와 논리 부정 연산자(!)에 대해 배우는 예제입니다.

public class _14_Operator2 {
    public static void main(String[] args) {
        // [1] 증가 연산자 (++) : 변수의 값을 1 증가시킵니다.
        int num = 10;
        System.out.println("초기 num: " + num); // 10
        num++; // num = num + 1; 과 동일
        System.out.println("num++ 후: " + num); // 11

        System.out.println("\n--- 전위(Prefix) vs 후위(Postfix) ---");

        // [2] 후위 증가 (postfix) : 변수++
        // -> "먼저" 현재 변수의 값을 사용(출력, 대입 등)하고, "그 다음에" 변수의 값을 1 증가시킵니다.
        int age = 30;
        System.out.println("age++ 출력: " + age++); // "먼저" age(30)를 출력하고, 그 다음 age를 31로 증가시킴
        System.out.println("age++ 후 age: " + age);   // 위 라인에서 증가된 값(31)이 출력됨

        // [3] 전위 증가 (prefix) : ++변수
        // -> "먼저" 변수의 값을 1 증가시키고, "그 다음에" 증가된 값을 사용합니다.
        int abc = 5;
        System.out.println("++abc 출력: " + ++abc); // "먼저" abc를 6으로 증가시키고, 증가된 값(6)을 출력함

        System.out.println("\n--- 종합 예제 ---");
        int x = 1;
        System.out.println("x++: " + x++); // 후위: x(1)를 먼저 출력, 그 후 x는 2가 됨
        System.out.println("x: " + x);   // 현재 x는 2
        System.out.println("++x: " + ++x); // 전위: x를 먼저 3으로 증가, 그 후 증가된 값(3)을 출력

        System.out.println("\n--- char 타입에 적용 ---");
        // char 타입에 증가 연산자를 사용하면 다음 문자의 유니코드 값으로 바뀝니다.
        char alphabet_x = 'X';
        System.out.println("초기 alphabet_x: " + alphabet_x);       // X
        System.out.println("++alphabet_x: " + ++alphabet_x); // X의 다음 문자인 Y가 출력됨

        System.out.println("\n--- 논리 부정 연산자 (!) ---");
        // boolean 값의 참/거짓을 반대로 바꿉니다.
        boolean isHuman = false;
        System.out.println("isHuman: " + isHuman);       // false
        System.out.println("!isHuman: " + !isHuman);     // true

        System.out.println("\n--- 감소 연산자 (--) ---");
        // ++와 동일한 원리로 동작합니다.
        x = 10;
        System.out.println("초기 x: " + x);       // 10
        System.out.println("--x: " + --x);       // 전위: 먼저 9로 감소, 9 출력
        System.out.println("x: " + x);         // 현재 x는 9
        System.out.println("x--: " + x--);       // 후위: 먼저 9 출력, 그 후 x는 8이 됨
        System.out.println("x: " + x);         // 현재 x는 8
    }
}
