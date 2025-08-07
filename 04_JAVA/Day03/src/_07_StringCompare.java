// 문자열(String) 비교 방법에 대해 배우는 예제입니다.
// 자바에서 문자열을 비교할 때는 `equals()` 메소드를 사용하는 것이 중요합니다.

public class _07_StringCompare {
    public static void main(String[] args) {
        // [1] `equals()` 메소드를 이용한 문자열 내용 비교
        // `equals()`: 두 문자열의 내용이 같은지 비교하여 boolean(true/false) 값을 반환합니다.
        //             대소문자를 구분합니다.
        String s1 = "Java";
        String s2 = "Python";

        System.out.println("s1.equals(s2): " + s1.equals(s2)); // "Java"와 "Python" 비교 -> false
        System.out.println("s1.equals("Java"): " + s1.equals("Java")); // "Java"와 "Java" 비교 -> true
        System.out.println("s2.equals("python"): " + s2.equals("python")); // "Python"과 "python" 비교 (대소문자 다름) -> false

        // `equalsIgnoreCase()`: 두 문자열의 내용이 같은지 비교하며, 대소문자를 무시합니다.
        System.out.println("s2.equalsIgnoreCase("python"): " + s2.equalsIgnoreCase("python")); // "Python"과 "python" 비교 (대소문자 무시) -> true

        System.out.println("
----------------------------------------
");

        // [2] `==` 연산자를 이용한 문자열 비교 (주의!)
        // `==` 연산자는 기본 자료형(int, double, boolean 등)에서는 값을 비교하지만,
        // 참조 자료형(String, 배열, 객체 등)에서는 "메모리 주소"를 비교합니다.
        // 즉, 두 변수가 "같은 객체를 참조하고 있는지"를 확인합니다.

        // 문자열 리터럴(literal)의 경우: 자바는 효율성을 위해 같은 문자열 리터럴은 같은 메모리 공간을 참조하게 합니다.
        s1 = "1234"; // s1은 "1234"가 저장된 메모리 주소를 참조
        s2 = "1234"; // s2도 "1234"가 저장된 같은 메모리 주소를 참조

        System.out.println("리터럴 s1.equals(s2): " + s1.equals(s2)); // 내용 비교 -> true
        System.out.println("리터럴 s1 == s2: " + (s1 == s2));     // 주소 비교 -> true (같은 객체를 참조)

        // `new String()`을 이용한 문자열 생성의 경우: 항상 새로운 객체를 메모리에 생성합니다.
        s1 = new String("1234"); // s1은 새로운 "1234" 객체의 메모리 주소를 참조
        s2 = new String("1234"); // s2는 또 다른 새로운 "1234" 객체의 메모리 주소를 참조

        System.out.println("new String s1.equals(s2): " + s1.equals(s2)); // 내용 비교 -> true
        System.out.println("new String s1 == s2: " + (s1 == s2));     // 주소 비교 -> false (서로 다른 객체를 참조)

        // 결론:
        // - 문자열의 "내용"이 같은지 비교할 때는 항상 `equals()` 메소드를 사용해야 합니다.
        // - `==` 연산자는 문자열 변수가 "같은 객체"를 가리키는지 확인할 때만 사용합니다.
    }
}
