/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 'NumberFormatException (숫자 형식 예외)'을 보여줍니다.
 * 이 예외는 문자열을 숫자로 변환하려고 할 때, 해당 문자열이 숫자의 형태로 올바르지 않을 경우 발생합니다.
 *
 * [NumberFormatException이란?]
 * 예를 들어, "안녕하세요"라는 문자열을 숫자로 바꿀 수 없듯이,
 * "11.2"와 같은 소수점 있는 문자열을 정수(int)로 바꾸려고 할 때도 이 예외가 발생합니다.
 * 자바는 문자열을 숫자로 변환할 때, 그 숫자의 '형식'이 정확히 일치해야 한다고 엄격하게 요구합니다.
 *
 * [비유]
 * '자동 판매기'에 동전을 넣는 상황과 비슷합니다.
 * 100원짜리 동전을 넣으면 음료수가 나오지만, 100원짜리 '지폐'나 '장난감 동전'을 넣으면
 * 기계가 "이건 동전이 아니잖아!" 하고 거부하며 오류를 낼 것입니다.
 * NumberFormatException은 바로 이런 '형식 불일치'로 인한 오류라고 생각하시면 됩니다.
 */
public class _09_NumberFormatException {
    public static void main(String[] args) {
        // 유효한 정수 형태의 문자열
        String str01 = "11";
        // 소수점이 포함된 문자열 (정수 형태가 아님)
        String str02 = "11.2";

        // 1. str01을 int로 변환: 성공!
        // "11"은 완벽한 정수 형태이므로, Integer.parseInt() 메소드가 성공적으로 변환합니다.
        int num01 = Integer.parseInt(str01);
        System.out.printf("String \"%s\" to int : %d%n", str01, num01);

        // 2. str02를 int로 변환: 실패! NumberFormatException 발생!
        // "11.2"는 소수점(.)을 포함하고 있어 정수(int) 형태가 아닙니다.
        // Integer.parseInt()는 오직 '정수' 형태의 문자열만 변환할 수 있습니다.
        // 따라서 이 줄에서 'NumberFormatException'이 발생하며 프로그램이 비정상 종료됩니다.
        int num02 = Integer.parseInt(str02); // 여기서 NumberFormatException 발생!
        System.out.printf("String \"%s\" to int : %d%n", str02, num02);

        // [NumberFormatException을 피하는 방법]
        // 1. 문자열의 형식을 정확히 확인하고, 그에 맞는 변환 메소드를 사용해야 합니다.
        //    예시: 소수점이 있는 문자열은 Double.parseDouble()을 사용해야 합니다.
        //    double dNum = Double.parseDouble(str02);
        //    System.out.printf("String \"%s\" to double : %f%n", str02, dNum);

        // 2. 예외가 발생할 수 있는 코드 블록을 try-catch 문으로 감싸서
        //    예외 발생 시 프로그램이 종료되지 않고 다른 처리를 하도록 만들 수 있습니다.
        //    (다음 예제들에서 try-catch를 자세히 배울 거예요!)
        /*
        try {
            int safeNum = Integer.parseInt("abc"); // 변환 불가능한 문자열
            System.out.println(safeNum);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없는 문자열입니다: " + e.getMessage());
        }
        */
    }
}