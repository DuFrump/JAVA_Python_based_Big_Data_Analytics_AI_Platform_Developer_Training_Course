// 문자(char) 데이터 타입에 대해 배우는 예제입니다.
// char는 단 하나의 문자를 저장하기 위한 타입이며, 작은따옴표('')로 값을 감쌉니다.

public class _05_Char {
    public static void main(String[] args) {
        // char 타입 변수에 각각 한글 '가'와 영문 'A'를 저장합니다.
        char ga = '가';
        char a = 'A';

        // char 변수를 출력하면 저장된 문자가 그대로 출력됩니다.
        System.out.println(ga); // 출력: 가
        System.out.println(a);  // 출력: A

        System.out.println("--------------------------------");

        // [중요] 문자의 유니코드(Unicode) 값 확인
        // 컴퓨터는 문자를 직접 저장하지 못하고, 각 문자에 부여된 고유한 숫자(코드)로 변환하여 저장합니다.
        // 이 표준 코드 체계를 '유니코드(Unicode)'라고 합니다.
        // char 타입의 값을 int 타입 변수에 저장하면 해당 문자의 유니코드 숫자 값이 저장됩니다.

        // '나'의 유니코드 값을 정수형 변수 na에 저장
        int na = '나';
        // 'B'의 유니코드(아스키코드) 값을 정수형 변수 b에 저장
        int b = 'B';

        // int 변수를 출력하면 문자가 아닌, 유니코드 숫자 값이 출력됩니다.
        System.out.println(na); // 출력: 45208 ('나'의 유니코드 값)
        System.out.println(b);  // 출력: 66 ('B'의 유니코드 값)
    }
}
