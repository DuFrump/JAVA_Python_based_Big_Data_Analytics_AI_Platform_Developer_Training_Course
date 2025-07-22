public class _08_EscapeSequence {
    public static void main(String[] args) {
        // 특수문자, 이스케이프 문자
        // \n, \t, \\, \", \'

        System.out.println("날씨가");
        System.out.println("정말");
        System.out.println("좋아요.");

        System.out.println("날씨가\n정말\n좋아요.");

        // 빽다방 2000원
        // 스타벅스 5000월
        System.out.println("빽다방 2000원");
        System.out.println("스타벅스 5000원");

        System.out.println("빽다방\t2000원");
        System.out.println("스타벅스\t5000원");

        System.out.println("C:\\Program Files\\Java");

        System.out.println("그녀가 나한테 말했다. \"배고프니?\"");
        System.out.println("너의 속마음이 들리는 거 같아. \'아.. 배고파..\'");
    }
}
