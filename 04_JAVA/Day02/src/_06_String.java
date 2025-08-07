// 문자열(String) 데이터 타입에 대해 배우는 예제입니다.

public class _06_String {
    public static void main(String[] args) {
        // int: 정수(숫자)를 저장하는 데이터 타입
        int a = 20;

        // char: 단 하나의 문자만 저장하는 데이터 타입 (작은따옴표 '' 사용)
        char b = 'B';

        // String: 여러 개의 문자가 나열된 '문자열'을 저장하는 데이터 타입 (큰따옴표 "" 사용)
        // String은 자바의 기본(primitive) 타입이 아닌, 참조(reference) 타입입니다.
        // 즉, 여러 기능(메소드)을 가진 객체(Object)입니다.
        String c = "이것은 긴 글을 저장할 수 있는 스트링입니다.";

        // 변수에 저장된 값들을 출력해봅니다.
        System.out.println("int a = " + a);
        System.out.println("char b = " + b);
        System.out.println("String c = " + c);
    }
}
