/**
 * 문자열(String) 데이터 타입에 대해 배웁니다.
 * String은 여러 개의 문자(char)가 나열된 '문자열'을 저장하는 데이터 타입입니다.
 * 예를 들어, "안녕하세요", "Java 프로그래밍"과 같이 한 글자 이상으로 이루어진 텍스트를 저장할 때 사용합니다.
 * String 값을 표현할 때는 반드시 큰따옴표("")로 감싸야 합니다.
 */
public class _06_String {
    public static void main(String[] args) {

        // ------------------- String 타입의 특징 -------------------

        // 1. char와 String의 차이점
        // char: 단 하나의 문자만 저장 (예: 'A', '가') -> 작은따옴표 사용
        char singleChar = 'Z';
        System.out.println("단일 문자 (char): " + singleChar);

        // String: 여러 개의 문자가 모인 문자열 저장 (예: "Hello", "World") -> 큰따옴표 사용
        String greeting = "안녕하세요, 두프룸프님!";
        System.out.println("문자열 (String): " + greeting);

        // 2. String은 기본(primitive) 타입이 아닌, 참조(reference) 타입입니다.
        //    - 기본 타입(int, char, double 등)은 실제 값을 변수 공간에 직접 저장합니다.
        //    - 참조 타입(String, 배열, 클래스 등)은 실제 값이 저장된 메모리 주소를 변수에 저장합니다.
        //    - 이 때문에 String은 다양한 기능을 가진 메소드(예: 문자열 길이, 특정 문자 찾기 등)를 제공합니다.

        String sentence = "이것은 긴 글을 저장할 수 있는 스트링입니다.";
        System.out.println("저장된 문장: " + sentence);

        // ------------------- String 변수 활용 예시 -------------------

        String name = "김자바";
        int age = 25;
        String job = "개발자";

        // 문자열과 다른 타입의 변수를 + 연산자로 연결하여 새로운 문자열을 만들 수 있습니다.
        String profile = "이름: " + name + ", 나이: " + age + ", 직업: " + job;
        System.out.println("프로필: " + profile);

        // 문자열의 길이를 알아보는 메소드 (String이 참조 타입이라 가능한 기능)
        System.out.println("문자열의 길이: " + greeting.length()); // .length()는 문자열의 글자 수를 반환합니다.
    }
}