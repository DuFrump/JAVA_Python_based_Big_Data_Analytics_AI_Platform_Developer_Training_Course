// 다양한 종류의 데이터 타입을 알아보고 출력하는 예제입니다.

public class _02_DataTypes {
    public static void main(String[] args) {
        // [데이터 타입(Data Type)]
        // 변수에 저장될 데이터의 종류를 의미합니다. 크게 기본 타입과 참조 타입으로 나뉩니다.

        // --- 1. 문자열 (String) ---
        // String은 자바에서 문자열을 다루기 위해 제공하는 클래스(참조 타입)입니다.
        // 큰따옴표("")로 묶인 텍스트 데이터를 저장합니다.
        // 예시: 사람의 이름, 문장, 주소 등
        System.out.println("--- 문자열 예시 ---");
        System.out.println("When I was young, I used to listen a radio.");
        System.out.println("난 어릴 적에 라디오를 듣곤 했어.");
        System.out.println(); // 줄바꿈

        // --- 2. 숫자 (Number) ---
        // 숫자는 크게 정수형과 실수형으로 나뉩니다. (기본 타입)

        // 2-1. 정수 (Integer): 소수점이 없는 숫자
        // byte, short, int, long 타입이 있습니다. 주로 int를 사용합니다.
        // 예시: 나이, 개수, 가격 등
        System.out.println("--- 정수 예시 ---");
        System.out.println(12);      // 일반적인 양의 정수
        System.out.println(-55);     // 음의 정수
        System.out.println(1000000000); // 10억
        System.out.println(); // 줄바꿈

        // 2-2. 실수 (Floating-point): 소수점이 있는 숫자
        // float, double 타입이 있습니다. 주로 double을 사용합니다.
        // 예시: 키, 몸무게, 평균 점수, 원주율(PI) 등
        System.out.println("--- 실수 예시 ---");
        System.out.println(3.141592); // 원주율
        System.out.println(-172.5);   // 음의 실수
        System.out.println(); // 줄바꿈

        // --- 3. 불리언 (Boolean) ---
        // 참(true) 또는 거짓(false) 두 가지 값만 가지는 타입입니다. (기본 타입)
        // 예시: 스위치 ON/OFF, 로그인 성공/실패, 조건문의 결과 등
        System.out.println("--- 불리언 예시 ---");
        System.out.println(true);  // 참
        System.out.println(false); // 거짓
        System.out.println(); // 줄바꿈

        // --- 4. 연산 결과 출력 ---
        // 데이터 타입끼리 간단한 연산도 가능합니다.
        System.out.println("--- 연산 결과 예시 ---");
        System.out.println(5 + 6);       // 정수 덧셈 -> 11
        System.out.println(10 - 3);      // 정수 뺄셈 -> 7
        System.out.println(3 * 7);       // 정수 곱셈 -> 21
        System.out.println(10 / 2);      // 정수 나눗셈 -> 5
        System.out.println(3.5 + 2.1);   // 실수 덧셈 -> 5.6

        // 문자열 연결 연산
        System.out.println("I am " + 20 + " years old."); // "I am 20 years old."
    }
}