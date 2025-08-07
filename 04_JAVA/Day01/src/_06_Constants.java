// 상수(Constant)를 선언하고 사용하는 방법을 배우는 예제입니다.
// 상수는 프로그램 실행 중에 값이 변하지 않는 데이터를 저장할 때 사용합니다.

public class _06_Constants {
    public static void main(String[] args) {
        // final 키워드를 사용하여 상수를 선언합니다.
        // 상수의 이름은 관례적으로 모두 대문자로 작성하고, 단어 사이는 밑줄(_)로 구분합니다.

        // 대한민국의 국가 코드를 상수로 선언합니다.
        final String KR_COUNTRY_CODE = "+82";

        // 상수는 한 번 값을 할당하면 다시 변경할 수 없습니다.
        // 아래 코드의 주석을 해제하면 컴파일 에러가 발생합니다.
        // KR_COUNTRY_CODE = "+8282";

        // 원주율(PI) 값을 상수로 선언합니다.
        final double PI = 3.141592;

        // 생년월일을 상수로 선언합니다.
        final String DATE_OF_BIRTH = "2001-07-18"; // 변수명을 의미에 맞게 DATE_OF_BIRTH로 수정

        // 선언된 상수들을 사용하여 문자열을 출력합니다.
        System.out.println("제 국가 코드는 " + KR_COUNTRY_CODE + "이고, 파이 값은 " + PI + "이고, 제 생일은 " + DATE_OF_BIRTH +" 입니다.");
    }
}
