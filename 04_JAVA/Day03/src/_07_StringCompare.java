// 안녕하세요, 두프룸프님!
// 이 파일은 자바에서 '문자열(String)'을 비교하는 방법에 대해 배우는 아주 중요한 예제입니다.
// 특히, 문자열의 '내용'을 비교할 때와 '메모리 주소'를 비교할 때 사용하는 방법이 다르다는 것을 이해하는 것이 핵심이에요!

public class _07_StringCompare { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // [1] `equals()` 메소드를 이용한 문자열 '내용' 비교 (★★★★★ 가장 중요!)
        // `equals()` 메서드는 두 문자열이 가지고 있는 '내용'이 서로 같은지 비교할 때 사용합니다.
        // 결과는 true(같다) 또는 false(다르다)로 반환됩니다.
        // 기본적으로 대소문자를 구분합니다.
        String s1 = "Java";   // s1이라는 문자열 변수에 "Java"라는 내용을 저장
        String s2 = "Python"; // s2이라는 문자열 변수에 "Python"이라는 내용을 저장

        System.out.println("s1.equals(s2): " + s1.equals(s2)); // "Java"와 "Python"의 내용이 같은가? -> false
        System.out.println("s1.equals(\"Java\"): " + s1.equals("Java")); // "Java"와 "Java"의 내용이 같은가? -> true
        System.out.println("s2.equals(\"python\"): " + s2.equals("python")); // "Python"과 "python"의 내용이 같은가? (대소문자 다름) -> false

        // `equalsIgnoreCase()`: 대소문자를 무시하고 문자열 내용 비교
        // 만약 대소문자 구분 없이 내용만 같으면 된다면 `equalsIgnoreCase()`를 사용합니다.
        System.out.println("s2.equalsIgnoreCase(\"python\"): " + s2.equalsIgnoreCase("python")); // "Python"과 "python"의 내용이 같은가? (대소문자 무시) -> true

        System.out.println("\n----------------------------------------\n"); // 구분선

        // [2] `==` 연산자를 이용한 문자열 비교 (★★★★★ 주의!)
        // `==` 연산자는 기본 자료형(int, double, boolean 등)에서는 '값'을 비교하는 것이 맞아요.
        // 하지만 String과 같은 '참조 자료형'(객체)에서는 '메모리 주소'를 비교합니다.
        // 즉, 두 변수가 '같은 객체'를 가리키고 있는지(동일한 메모리 공간을 참조하는지)를 확인하는 거예요.

        // 2-1. 문자열 리터럴(literal)의 경우: 자바의 특별한 최적화
        // 자바는 메모리 효율성을 위해, 코드에 직접 작성된 같은 문자열 리터럴("Java", "Hello" 등)은
        // 'String Pool'이라는 특별한 공간에 하나만 만들고, 여러 변수가 그 하나를 공유하게 합니다.
        s1 = "1234"; // s1은 String Pool에 있는 "1234"의 메모리 주소를 참조
        s2 = "1234"; // s2도 String Pool에 있는 같은 "1234"의 메모리 주소를 참조

        System.out.println("리터럴 s1.equals(s2): " + s1.equals(s2)); // 내용 비교 -> true (당연히 내용이 같죠)
        System.out.println("리터럴 s1 == s2: " + (s1 == s2));     // 주소 비교 -> true (같은 String Pool의 객체를 참조하므로)
        // 이 경우 `==`가 true로 나와서 헷갈릴 수 있지만, 이것은 자바의 최적화 때문이지 `==`가 내용을 비교하는 것은 아닙니다!

        // 2-2. `new String()`을 이용한 문자열 생성의 경우: 항상 새로운 객체 생성
        // `new String()`을 사용하면, 내용이 같더라도 항상 새로운 String 객체를 메모리에 만듭니다.
        s1 = new String("1234"); // s1은 새로운 "1234" 객체의 메모리 주소를 참조
        s2 = new String("1234"); // s2는 또 다른 새로운 "1234" 객체의 메모리 주소를 참조

        System.out.println("new String s1.equals(s2): " + s1.equals(s2)); // 내용 비교 -> true (내용은 같으니까요)
        System.out.println("new String s1 == s2: " + (s1 == s2));     // 주소 비교 -> false (서로 다른 메모리 공간에 있는 객체를 참조하므로)
        // 이 예시를 보면 `==`가 문자열 내용을 비교하지 않는다는 것을 명확히 알 수 있습니다!

        // ★★★ 결론 ★★★
        // 자바에서 문자열의 '내용'이 같은지 비교할 때는 항상 `equals()` 또는 `equalsIgnoreCase()` 메소드를 사용해야 합니다.
        // `==` 연산자는 두 문자열 변수가 '완전히 동일한 객체'를 가리키는지 확인할 때만 사용하며,
        // 일반적으로 문자열 내용 비교에는 사용하지 않습니다. 이 점을 꼭 기억해주세요!
    }
}
