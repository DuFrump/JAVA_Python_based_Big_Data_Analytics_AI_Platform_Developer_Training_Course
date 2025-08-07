// 변수(Variable)를 선언하고 사용하는 방법을 배우는 예제입니다.
// 변수는 데이터를 저장하기 위한 공간입니다.

public class _03_Variables {
    public static void main(String[] args) {
        // 문자열(String) 타입의 변수 hello를 선언하고 "안녕하세요" 라는 값을 할당합니다.
        String hello = "안녕하세요";
        // 정수(int) 타입의 변수 time을 선언하고 10 이라는 값을 할당합니다.
        int time = 10;

        // 변수를 사용하여 문자열을 조합하고 출력합니다.
        System.out.println(hello + "! 홍길동님, " + time + "시에 만나요!");
        System.out.println(hello + ". 그렇게 하도록 하죠.");

        // 실수(double) 타입의 변수 height를 선언하고 175.6 이라는 값을 할당합니다.
        double height = 175.6;
        // 문자(char) 타입의 변수 gender를 선언하고 'M' 이라는 값을 할당합니다.
        // char 타입은 작은따옴표('')를 사용합니다.
        char gender = 'M';
        // 이미 선언된 변수 hello의 값을 "안녕?" 으로 변경합니다.
        hello = "안녕?";

        System.out.println(hello + " 키는 " + height + ", 성별은 " + gender + " 입니다.");

        // 불리언(boolean) 타입의 변수 love를 선언하고 true 라는 값을 할당합니다.
        boolean love = true;
        System.out.println("그녀는 나를 좋아할까요? " + love);

        // 다양한 숫자 데이터 타입
        // double은 더 정밀한 실수를 표현할 수 있습니다.
        double d = 2.098887654;
        // float 타입의 실수를 나타낼 때는 값 뒤에 'f' 또는 'F'를 붙여줍니다.
        float f = 5.21321654564f;
        System.out.println(d);
        System.out.println(f);

        // long 타입은 매우 큰 정수를 표현할 수 있습니다.
        // long 타입의 정수를 나타낼 때는 값 뒤에 'l' 또는 'L'을 붙여줍니다.
        long i = 1000000000000000000L;
        System.out.println(i);
        // 숫자를 읽기 쉽게 하기 위해 중간에 언더바(_)를 사용할 수 있습니다. (자바 7부터 지원)
        i = 3_000_000_000_000_000_000L;
        System.out.println(i);
        System.out.println("끝!");
    }
}
