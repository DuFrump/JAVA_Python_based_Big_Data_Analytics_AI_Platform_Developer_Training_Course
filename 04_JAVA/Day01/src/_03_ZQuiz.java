// 변수 선언 및 사용법에 대한 퀴즈 예제입니다.

public class _03_ZQuiz {
    public static void main(String[] args) {
        /**
         * [문제 1]
         * 다음 정보를 변수에 저장하고 출력하는 코드를 작성하세요.
         *
         * 이름 : 김자바
         * 나이 : 20
         * 키 : 172.5cm
         * 성별 : M
         */

        // 각 데이터 타입에 맞는 변수를 선언하고 값을 할당합니다.
        String name = "김자바";      // 이름 (문자열)
        int age = 20;             // 나이 (정수)
        double height = 172.5;    // 키 (실수)
        char gender = 'M';          // 성별 (문자)

        // 변수에 저장된 값을 출력합니다.
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("키 : " + height + "cm");
        System.out.println("성별 : " + gender);


        /**
         * [문제 2]
         * 좋아하는 음식 3가지를 String 변수로 저장하고 한 줄로 출력해보세요.
         * 예시 : 제가 좋아하는 음식은 김밥, 떡볶이, 순대 입니다.
         */

        // 좋아하는 음식 3가지를 각각의 String 변수에 저장합니다.
        String fav01 = "김밥";
        String fav02 = "떡볶이";
        String fav03 = "순대";

        // 변수들을 조합하여 원하는 형식으로 문장을 출력합니다.
        System.out.println("내가 좋아하는 음식은 " + fav01 + ", " + fav02 + ", " + fav03 + "입니다.");


        // 추가 예제: boolean 타입 변수 활용
        String human1 = "호모사피엔스";
        boolean human2 = true; // "나는 호모사피엔스인가?" 라는 질문에 대한 대답(true)

        System.out.println("나는 " + human1 + "인가요? " + human2);
    }
}
