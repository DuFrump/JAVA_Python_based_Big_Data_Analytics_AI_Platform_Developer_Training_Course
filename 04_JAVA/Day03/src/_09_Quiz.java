// 주민등록번호에서 생일과 성별 정보를 추출하여 출력하는 퀴즈입니다.
// String의 `substring()` 메소드와 조건 연산자(삼항 연산자)를 활용합니다.

public class _09_Quiz {
    public static void main(String[] args) {
        String id_number = "901232-1234567"; // 예시 주민등록번호

        // [1] 생일 추출하기
        // 주민등록번호에서 생일은 2번째 인덱스부터 6번째 인덱스 직전까지의 문자열입니다.
        // (인덱스는 0부터 시작)
        // substring(startIndex, endIndex): startIndex부터 endIndex-1까지의 부분 문자열을 반환합니다.
        String birth = id_number.substring(2, 6); // "901232"에서 "1232" 추출 (월일)

        // [2] 성별 추출 및 판별하기
        // 주민등록번호에서 성별은 7번째 인덱스(하이픈 다음)의 한 자리 숫자입니다.
        // 1 또는 3: 남자, 2 또는 4: 여자 (여기서는 1이면 남자, 아니면 여자로 단순화)
        String gender_code = id_number.substring(7, 8); // "1234567"에서 "1" 추출

        // 조건 연산자(삼항 연산자)를 사용하여 성별 코드에 따라 "남자" 또는 "여자"를 결정합니다.
        // 문자열 비교는 반드시 `equals()` 메소드를 사용해야 합니다. (`==`는 주소 비교)
        String gender = (gender_code.equals("1")) ? "남자" : "여자";

        // [3] 결과 출력
        System.out.printf("생일은 %s이고, 성별은 %s입니다.
", birth, gender);
    }
}
