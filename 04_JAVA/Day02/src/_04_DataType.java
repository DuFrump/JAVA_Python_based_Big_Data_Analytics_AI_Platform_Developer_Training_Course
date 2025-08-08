/**
 * 자바의 다양한 숫자 관련 데이터 타입(Data Type)에 대해 배웁니다.
 * 데이터 타입은 변수라는 상자에 어떤 종류의 물건(데이터)을 담을지 결정하는 규칙입니다.
 * 예를 들어, "정수만 담는 상자", "실수만 담는 상자" 등으로 구분하는 것입니다.
 */
public class _04_DataType {
    public static void main(String[] args) {

        // ------------------- 정수형 데이터 타입 -------------------
        // 실생활 예시: 나이, 시험 점수, 가격 등 소수점이 없는 숫자를 저장할 때 사용합니다.

        // 각 타입은 저장할 수 있는 값의 크기(범위)가 다릅니다.
        // byte  (1 byte) : -128 ~ 127 (예: 사람의 나이, 작은 그룹의 인원수)
        // short (2 bytes): -32,768 ~ 32,767 (예: 4자리 연도)
        // int   (4 bytes): -21억 ~ 21억 (예: 대부분의 숫자 계산, 인구수) -> **일반적으로 가장 많이 사용**
        // long  (8 bytes): -900경 ~ 900경 (예: 은행 잔고, 전 세계 인구수, 과학 계산) -> 매우 큰 수를 다룰 때 사용

        // int 타입: 가장 보편적인 정수형 타입입니다.
        int population = 51_751_065; // 자바에서는 숫자를 편하게 읽기 위해 언더바(_)를 사용할 수 있습니다.
        System.out.println("대한민국 인구수(2023년 기준): " + population);

        // byte 타입: 작은 숫자를 저장하여 메모리를 절약할 수 있습니다.
        byte age = 100;
        // byte의 표현 범위(-128 ~ 127)를 넘는 값은 저장할 수 없어 에러가 발생합니다.
        // byte age2 = 128; // 이 코드의 주석을 풀면 "Type mismatch" 에러가 납니다.
        System.out.println("byte로 표현 가능한 나이: " + age);

        // long 타입: 매우 큰 수를 다룰 때 사용하며, 숫자 뒤에 'L' 또는 'l'을 붙여야 합니다.
        long lightYear = 9_460_730_472_580_800L;
        System.out.println("1광년은 약 " + lightYear + "미터입니다.");

        System.out.println("--------------------------------");

        // ------------------- 실수형 데이터 타입 -------------------
        // 실생활 예시: 키, 몸무게, 원주율(pi) 등 소수점이 있는 정밀한 숫자를 저장할 때 사용합니다.

        // float  (4 bytes): 소수점 이하 6~7자리 정도까지 표현. 숫자 뒤에 'f' 또는 'F'를 붙여야 합니다.
        // double (8 bytes): 소수점 이하 15자리 정도까지 표현. float보다 정밀도가 높아 **일반적으로 많이 사용**됩니다.

        // double 타입: float보다 더 정밀한 소수를 다룰 수 있습니다.
        double marathon = 42.195;
        System.out.println("마라톤은 " + marathon + "km를 달립니다.");

        // float 타입: 값 뒤에 반드시 'f' 또는 'F'를 붙여 float 타입임을 명시해야 합니다.
        float halfMarathon = 21.0975f;
        System.out.println("하프 마라톤은 " + halfMarathon + "km를 달립니다.");

        // [중요] double과 float의 정밀도(precision) 차이 확인
        // 똑같은 원주율 값을 넣어도, 각 타입이 표현할 수 있는 한계 때문에 저장되는 값이 달라집니다.
        double pieDouble = 3.141592653589793;
        float  pieFloat  = 3.141592653589793f; // float의 표현 범위를 넘어서므로 뒷부분이 잘리고 근사치로 저장됨

        System.out.println("double 타입의 원주율: " + pieDouble);
        System.out.println("float 타입의 원주율 : " + pieFloat); // double과 다른 값이 출력되는 것을 확인할 수 있습니다.
    }
}