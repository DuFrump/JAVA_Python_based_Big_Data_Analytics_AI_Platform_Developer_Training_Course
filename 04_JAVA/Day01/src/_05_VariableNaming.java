public class _05_VariableNaming {
    public static void main(String[] args) {
        /**
         * 변수 이름 짓기
         * 1. 저장할 값에 어울리는 이름
         * 2. 밑줄, 문자, 숫자 사용 가능 (공백은 X)
         * 3. 시작은 밑줄 또는 문자 (숫자는 X)
         * 4. 한 단어 또는 2개 이상 단어의 연속
         * 5-1. 소문자로 시작 -> N 번째 단어의 첫 글자는 대문자
         * 5-2. 혹은 여러 단어를 언더바로 연결
         * 6. 예약어는 사용 불가 (e.g) public, static, void, int ...)
         * 7. 상수는 전부 대문자로
         * */

        String nationality = "대한민국";
        String first_name = "길동";
        String last_name = "홍";
        String date_of_birth = "2001-07-18";
        String residental_address = "라마호텔";
        String purpose_of_visit = "business";
        String flight_no_01 = "KE234";
        String flight_no_02 = "ER345";

        String item1 = "passport";
        String item2 = "mobile_phone";
        String item3 = "iPad";

        final String CODE ="KR";
        System.out.println("국가 코드는 " + CODE + "입니다.");
    }
}
