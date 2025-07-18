public class _03_ZQuiz {
    public static void main(String[] args) {
        /**
         * 이름 : 김자바
         * 나이 : 20
         * 키 : 172.5cm
         * 성별 : M
         * */

        String name = "김자바";
        int age = 20;
        double height = 172.5;
        char gender = 'M';

        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("키 : " + height + "cm");
        System.out.println("성별 : " + gender);


        /**
         * 좋아하는 음식 3가지를 String 변수로 저장하고 한 줄로 출력해보세요.
         * 예시 : 제가 좋아하는 음식은 김밥, 떡볶이, 순대 입니다.
         * */
        String fav01 = "김밥";
        String fav02 = "떡볶이";
        String fav03 = "순대";

        System.out.println("내가 좋아하는 음식은 " + fav01 + ", " + fav02 + ", " + fav03 + "입니다.");

        String human1 = "호모사피엔스";
        boolean human2 = true;

        System.out.println("나는 " + human1 + "인가요? " + human2);
    }
}
