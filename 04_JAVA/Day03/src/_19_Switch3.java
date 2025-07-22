public class _19_Switch3 {
    public static void main(String[] args) {
        // 1, 2, 3 등급이 있음
        // 그 외 등급 40만원
        // 기본이 3등급 + 10만원 => 50만원
        // 2등급 + 10만원 => 60만원
        // 1등급 + 10만원 => 70만원

        int grade = 4;
        int scholarship = 400000;

        switch(grade) {
            case 1:
                scholarship += 100000;
            case 2:
                scholarship += 100000;
            case 3:
                scholarship += 100000;
            default:
                break;
        }

        System.out.printf("당신의 장학금은 %d입니다.", scholarship);
    }
}
