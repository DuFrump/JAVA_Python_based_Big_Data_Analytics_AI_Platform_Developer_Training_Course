// 자바의 다양한 숫자 데이터 타입(Data Type)에 대해 배우는 예제입니다.

public class _04_DataType {
    public static void main(String[] args) {
        // [정수형 데이터 타입]
        // 각 타입은 저장할 수 있는 값의 범위가 다릅니다.
        // byte:  -128 ~ 127 (1 byte)
        // short: -32,768 ~ 32,767 (2 bytes)
        // int:   -21억 ~ 21억 (4 bytes) -> 일반적으로 가장 많이 사용
        // long:  -900경 ~ 900경 (8 bytes) -> 매우 큰 수를 다룰 때 사용

        // int 타입 변수 선언
        int a = 30;

        // byte 타입 변수 선언
        byte age = 100;
        // byte의 표현 범위(-128 ~ 127)를 넘는 값은 저장할 수 없습니다.
        // 아래 코드의 주석을 해제하면 컴파일 에러가 발생합니다.
        // byte age2 = 128;

        // short 타입 변수 선언
        short b = 32767;
        // short의 표현 범위를 넘는 값은 저장할 수 없습니다.
        // 아래 코드의 주석을 해제하면 컴파일 에러가 발생합니다.
        // short c = 32768;

        System.out.println(b);

        System.out.println("--------------------------------");

        // [실수형 데이터 타입]
        // float:  소수점 이하 7자리 정도까지 표현 (4 bytes)
        // double: 소수점 이하 15자리 정도까지 표현 (8 bytes) -> float보다 정밀함, 일반적으로 많이 사용

        // double 타입 변수 선언
        double marathon = 42.195;
        // float 타입 변수를 선언할 때는 값 뒤에 'f' 또는 'F'를 붙여야 합니다.
        float half_marathon = 21.0975f;

        System.out.println("마라톤은 " + marathon + "km를 달립니다.");
        System.out.println("하프 마라톤은 " + half_marathon + "km를 달립니다.");

        System.out.println("--------------------------------");

        // double과 float의 정밀도(precision) 차이 확인
        double pieDouble = 3.141592653589793;
        float pieFloat = 3.141592653589793f; // float의 표현 범위를 넘어서므로 값이 잘려서 저장됨

        System.out.println("double : " + pieDouble);
        System.out.println("float  : " + pieFloat); // double과 다른 값이 출력됨
    }
}
