/**
 * 자바의 연산자 중에서 "증가/감소 연산자(Increment/Decrement Operator)"와
 * "논리 부정 연산자(Logical NOT Operator)"에 대해 배웁니다.
 */

public class _14_Operator2 {
    public static void main(String[] args) {

        // ------------------- 1. 증가 연산자 (++) -------------------
        // 변수의 값을 1 증가시킵니다. `num = num + 1;` 또는 `num += 1;`과 동일한 역할을 합니다.

        int num = 10;
        System.out.println("초기 num: " + num); // 10

        num++; // num의 값을 1 증가시킵니다. (num은 이제 11이 됩니다)
        System.out.println("num++ 후: " + num); // 11

        System.out.println("\n--- 전위(Prefix) vs 후위(Postfix) 증가 연산자 ---");
        // 이 두 가지는 연산자가 변수 앞에 붙느냐(전위) 뒤에 붙느냐(후위)에 따라
        // "언제" 변수의 값이 증가되는지가 달라집니다. 매우 중요합니다!

        // [1-1] 후위 증가 (Postfix Increment): `변수++`
        // - "먼저" 현재 변수의 값을 "사용"하고, "그 다음에" 변수의 값을 1 증가시킵니다.
        int age = 30;
        System.out.println("age++ 출력: " + age++); // 1. `age`의 현재 값(30)을 먼저 출력합니다.
                                                // 2. 그 다음에 `age`의 값을 1 증가시킵니다. (age는 이제 31이 됩니다)
        System.out.println("age++ 후 age: " + age);   // 위 라인에서 증가된 값(31)이 출력됩니다.

        // [1-2] 전위 증가 (Prefix Increment): `++변수`
        // - "먼저" 변수의 값을 1 증가시키고, "그 다음에" 증가된 값을 "사용"합니다.
        int abc = 5;
        System.out.println("++abc 출력: " + ++abc); // 1. `abc`의 값을 먼저 1 증가시킵니다. (abc는 이제 6이 됩니다)
                                                // 2. 그 다음에 증가된 값(6)을 출력합니다.

        System.out.println("\n--- 증가 연산자 종합 예제 ---");
        int x = 1;
        System.out.println("x++: " + x++); // 후위: x의 현재 값(1)을 출력하고, x는 2가 됩니다.
        System.out.println("x: " + x);   // 현재 x는 2입니다.
        System.out.println("++x: " + ++x); // 전위: x를 먼저 3으로 증가시키고, 증가된 값(3)을 출력합니다.
        System.out.println("x: " + x);   // 현재 x는 3입니다.

        System.out.println("\n--- char 타입에 증가 연산자 적용 ---");
        // char 타입에 증가 연산자를 사용하면, 해당 문자의 유니코드 값이 1 증가하여 다음 문자로 바뀝니다.
        char alphabet_x = 'X';
        System.out.println("초기 alphabet_x: " + alphabet_x);       // X
        System.out.println("++alphabet_x: " + ++alphabet_x); // 'X'의 유니코드 값에 1을 더한 문자인 'Y'가 출력됩니다.

        System.out.println("\n--- 감소 연산자 (--) ---");
        // 변수의 값을 1 감소시킵니다. `num = num - 1;` 또는 `num -= 1;`과 동일합니다.
        // 증가 연산자와 동일한 원리로 전위/후위가 동작합니다.
        int y = 10;
        System.out.println("초기 y: " + y);       // 10
        System.out.println("--y: " + --y);       // 전위: 먼저 9로 감소, 9 출력
        System.out.println("y: " + y);         // 현재 y는 9
        System.out.println("y--: " + y--);       // 후위: 먼저 9 출력, 그 후 y는 8이 됨
        System.out.println("y: " + y);         // 현재 y는 8

        System.out.println("\n--- 2. 논리 부정 연산자 (!) ---");
        // boolean 타입의 값(true 또는 false)을 반대로 바꿉니다.
        // 마치 스위치를 켜고 끄는 것과 같습니다.

        boolean isHuman = false;
        System.out.println("isHuman: " + isHuman);       // false
        System.out.println("!isHuman: " + !isHuman);     // !false 이므로 true가 됩니다.

        boolean isSunny = true;
        System.out.println("isSunny: " + isSunny);       // true
        System.out.println("!isSunny: " + !isSunny);     // !true 이므로 false가 됩니다.
    }
}