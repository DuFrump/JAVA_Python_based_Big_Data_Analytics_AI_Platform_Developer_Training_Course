// 앞에서 배운 변수 선언 및 사용법을 복습하는 퀴즈 예제입니다.

public class _03_ZQuiz {
    public static void main(String[] args) {
        /*
         * [퀴즈 1: 자기소개 출력하기]
         * 이름, 나이, 키, 성별, 취업 희망 여부를 각각 다른 타입의 변수에 저장하고,
         * 이 변수들을 사용하여 자기소개 문장을 완성하여 출력해 보세요.
         *
         * --- 출력 예시 ---
         * 이름: 김자바
         * 나이: 20
         * 키: 172.5cm
         * 성별: M
         * 취업 희망: true
         */

        // [풀이]
        // 1. 각 정보에 맞는 데이터 타입을 선택하여 변수를 선언하고 값을 할당합니다.
        String name = "김자바";      // 이름은 문자열(String) 타입
        int age = 20;             // 나이는 정수(int) 타입
        double height = 172.5;    // 키는 소수점이 있으므로 실수(double) 타입
        char gender = 'M';          // 성별은 한 글자이므로 문자(char) 타입
        boolean isHopingForJob = true; // 희망 여부는 참/거짓이므로 불리언(boolean) 타입

        System.out.println("--- 퀴즈 1 결과 ---");
        // 2. System.out.println()과 + 연산자를 사용하여 변수와 문자열을 조합하여 출력합니다.
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height + "cm");
        System.out.println("성별: " + gender);
        System.out.println("취업 희망: " + isHopingForJob);
        System.out.println(); // 줄바꿈


        /*
         * [퀴즈 2: 좋아하는 것 나열하기]
         * 자신이 좋아하는 것 3가지를 각각 String 변수에 저장하고,
         * 한 문장으로 이어서 출력해 보세요.
         *
         * --- 출력 예시 ---
         * 내가 좋아하는 것은 [치킨], [피자], [콜라]입니다.
         */

        // [풀이]
        // 1. 좋아하는 것 3가지를 저장할 String 타입의 변수 3개를 선언하고 각각 초기화합니다.
        String favorite1 = "치킨";
        String favorite2 = "피자";
        String favorite3 = "콜라";

        System.out.println("--- 퀴즈 2 결과 ---");
        // 2. 변수들과 문자열을 + 연산자로 연결하여 원하는 형식의 문장을 만들어 출력합니다.
        System.out.println("내가 좋아하는 것은 [" + favorite1 + "], [" + favorite2 + "], [" + favorite3 + "]입니다.");
        System.out.println(); // 줄바꿈


        // [추가 학습] 변수 값 재할당(변경)하기
        // 변수는 값을 변경할 수 있어 유용합니다.
        int score = 80; // 초기 점수는 80점
        System.out.println("처음 시험 점수: " + score + "점");

        score = 95; // 공부를 열심히 해서 점수가 올랐다!
        System.out.println("재시험 점수: " + score + "점");
    }
}