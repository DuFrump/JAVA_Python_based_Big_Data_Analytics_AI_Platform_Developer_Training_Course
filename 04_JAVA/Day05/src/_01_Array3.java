// `char` 배열에서 알파벳 문자만 추출하여 새로운 문자열을 만드는 예제입니다.
// 문자의 아스키(ASCII) 또는 유니코드(Unicode) 값을 활용하여 알파벳을 판별합니다.

public class _01_Array3 {
    public static void main(String[] args) {

        // char 배열 선언 및 초기화
        char[] cards = {'1', 'L', 'O', '2', 'V', '3', 'E'};
        String myWord = ""; // 추출된 알파벳을 저장할 빈 문자열

        // 배열의 각 요소를 순회합니다.
        for(int i = 0; i < cards.length; i++) {

            // char 타입의 문자를 int 타입으로 변환하면 해당 문자의 아스키/유니코드 값을 얻을 수 있습니다.
            int word = cards[i];

            // 조건문: 현재 문자가 알파벳(대문자 또는 소문자)인지 확인합니다.
            // 대문자 알파벳의 아스키/유니코드 범위: 65 (A) ~ 90 (Z)
            // 소문자 알파벳의 아스키/유니코드 범위: 97 (a) ~ 122 (z)
            if((word >= 65 && word <= 90) || (word >= 97 && word <= 122)) {
                // 알파벳인 경우, int 값을 다시 char로 형변환하여 문자열에 추가합니다.
                myWord += (char)word; // myWord = myWord + (char)word; 와 동일
            }
        }

        // 최종적으로 완성된 문자열을 출력합니다.
        System.out.println("여러분 " + myWord + " 합니다."); // 출력: 여러분 LOVE 합니다.

    }
}
