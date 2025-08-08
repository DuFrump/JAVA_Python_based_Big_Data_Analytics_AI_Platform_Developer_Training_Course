/**
 * 자바의 연산자 중에서 "비교 연산자(Comparison Operator)"와
 * "논리 연산자(Logical Operator)"에 대해 배웁니다.
 * 이 연산자들은 주로 조건문(if문 등)에서 어떤 조건을 판단할 때 사용되며,
 * 결과로 항상 `true` 또는 `false`라는 `boolean` 값을 반환합니다.
 */

public class _16_Operator4 {
    public static void main(String[] args) {

        // ------------------- 1. 비교 연산자 (Comparison Operator) -------------------
        // 두 값을 비교하여 참(true) 또는 거짓(false)을 반환합니다.
        // 수학의 부등호와 등호와 유사합니다.

        int a = 10;
        int b = 20;

        System.out.println("--- 비교 연산자 ---");
        System.out.println("a > b (a가 b보다 큰가?): " + (a > b));   // 10 > 20 -> false
        System.out.println("a < b (a가 b보다 작은가?): " + (a < b));   // 10 < 20 -> true
        System.out.println("a >= b (a가 b보다 크거나 같은가?): " + (a >= b)); // 10 >= 20 -> false
        System.out.println("a <= b (a가 b보다 작거나 같은가?): " + (a <= b)); // 10 <= 20 -> true
        System.out.println("a == b (a와 b가 같은가?): " + (a == b));  // 10 == 20 -> false
        System.out.println("a != b (a와 b가 다른가?): " + (a != b));  // 10 != 20 -> true

        // [참고] 연산자 우선순위와 함께 사용될 때
        // `++`, `--` 같은 증감 연산자가 비교 연산자보다 우선순위가 높습니다.
        a = 10;
        b = 11;
        // `a != --b`의 실행 순서:
        // 1. `--b`가 먼저 실행되어 `b`의 값이 1 감소합니다. (b는 11 -> 10이 됩니다)
        // 2. 그 다음 `a != b` (10 != 10) 비교 연산이 수행됩니다.
        System.out.println("a != --b (10 != 10): " + (a != --b)); // 결과: false
        System.out.println("연산 후 b의 값: " + b); // b는 10이 되어 있습니다.

        System.out.println("\n--------------------------------");

        // ------------------- 2. 논리 연산자 (Logical Operator) -------------------
        // 여러 개의 `boolean` 값(true/false)을 조합하여 하나의 `boolean` 결과를 만듭니다.
        // 복잡한 조건을 만들 때 사용합니다.

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;

        System.out.printf("%n----------논리곱 (AND) &&----------%n");
        // `&&` (AND) 연산: 두 조건이 "모두" 참(true)일 때만 결과가 참(true)이 됩니다.
        // 하나라도 거짓(false)이면 결과는 거짓(false)입니다.
        // 예시: "비가 오고(true) 바람이 분다(true)" -> "비가 오고 바람이 분다(true)"
        System.out.println("true && false : " + (b1 && b2)); // true && false -> false
        System.out.println("true && true : " + (b1 && b3));  // true && true -> true
        System.out.println("false && false : " + (b2 && false)); // false && false -> false
        System.out.println("true && false && true : " + (b1 && b2 && b3)); // 하나라도 false가 있으면 전체 false


        System.out.printf("%n----------논리합 (OR) ||----------%n");
        // `||` (OR) 연산: 두 조건 중 "하나라도" 참(true)이면 결과가 참(true)이 됩니다.
        // 두 조건이 모두 거짓(false)일 때만 결과가 거짓(false)입니다.
        // 예시: "비가 오거나(true) 바람이 분다(false)" -> "비가 오거나 바람이 분다(true)"
        System.out.println("true || false : " + (b1 || b2)); // true || false -> true
        System.out.println("true || true : " + (b1 || b3));  // true || true -> true
        System.out.println("false || false : " + (b2 || false)); // false || false -> false
        System.out.println("true || false || true : " + (b1 || b2 || b3)); // 하나라도 true가 있으면 전체 true

        System.out.printf("%n----------배타적 논리합 (XOR) ^----------%n");
        // `^` (XOR) 연산: 두 값이 "서로 다를" 때만 결과가 참(true)이 됩니다.
        // 두 값이 서로 같으면 결과는 거짓(false)입니다.
        // 예시: "남성(true)이거나 여성(false)이다" (둘 중 하나만 참일 때)
        System.out.println("true ^ false : " + (b1 ^ b2)); // true ^ false -> true
        System.out.println("true ^ true : " + (b1 ^ b3));  // true ^ true -> false
        System.out.println("false ^ false : " + (b2 ^ false)); // false ^ false -> false
    }
}