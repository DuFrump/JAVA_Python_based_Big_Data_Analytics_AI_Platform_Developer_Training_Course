// 비교 연산자(Comparison Operator)와 논리 연산자(Logical Operator)에 대해 배우는 예제입니다.

public class _16_Operator4 {
    public static void main(String[] args) {
        // [1] 비교 연산자: 두 값을 비교하여 결과로 boolean(true/false) 값을 반환합니다.
        int a = 10;
        int b = 20;

        System.out.println("--- 비교 연산자 ---");
        System.out.println("a > b : " + (a > b));   // a가 b보다 큰가? -> false
        System.out.println("a <= b : " + (a <= b));  // a가 b보다 작거나 같은가? -> true
        System.out.println("a == b : " + (a == b));  // a와 b가 같은가? -> false
        System.out.println("a != b : " + (a != b));  // a와 b가 다른가? -> true

        // 연산자 우선순위에 따라 연산이 함께 일어날 수 있습니다.
        a = 10;
        b = 11;
        // --b가 먼저 실행되어 b는 10이 됩니다. 그 후 a(10) != b(10) 비교 -> false
        System.out.println("a != --b : " + (a != --b));

        System.out.println("5 > 3 : " + (5 > 3));     // true
        System.out.println("5 <= 3 : " + (5 <= 3));    // false
        System.out.println("5 != 3 : " + (5 != 3));    // true


        // [2] 논리 연산자: 여러 개의 boolean 값을 조합하여 하나의 boolean 결과로 만듭니다.
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = false;

        System.out.printf("%n%n----------논리곱 (AND) &&----------%n");
        // AND(&&) 연산: 두 값이 "모두" true일 때만 결과가 true가 됩니다.
        // (하나라도 false이면 결과는 false)
        System.out.println("true && false : " + (b1 && b2)); // false
        System.out.println("true && true : " + (b1 && b3));  // true
        System.out.println("false && false : " + (b2 && b4)); // false
        System.out.println("true && false && true : " + (b1 && b2 && b3)); // false


        System.out.printf("%n%n----------논리합 (OR) ||----------%n");
        // OR(||) 연산: 두 값 중 "하나라도" true이면 결과가 true가 됩니다.
        // (모두 false일 때만 결과가 false)
        System.out.println("true || false : " + (b1 || b2)); // true
        System.out.println("true || true : " + (b1 || b3));  // true
        System.out.println("false || false : " + (b2 || b4)); // false
        System.out.println("true || false || true : " + (b1 || b2 || b3)); // true

        System.out.printf("%n%n----------배타적 논리합 (XOR) ^----------%n");
        // XOR(^) 연산: 두 값이 "서로 다를" 때 결과가 true가 됩니다.
        // (서로 같으면 결과는 false)
        System.out.println("true ^ false : " + (b1 ^ b2)); // true
        System.out.println("true ^ true : " + (b1 ^ b3));  // false
    }
}
