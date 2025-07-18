public class _03_Variables {
    public static void main(String[] args) {
        String hello = "안녕하세요";
        int time = 10;

        System.out.println(hello + "! 홍길동님, " + time + "시에 만나요!");
        System.out.println(hello + ". 그렇게 하도록 하죠.");

        double height = 175.6;
        char gender = 'M';
        hello = "안녕?";

        System.out.println(hello + " 키는 " + height + ", 성별은 " + gender + " 입니다.");

        boolean love = true;
        System.out.println("그녀는 나를 좋아할까요? " + love);

        double d = 2.098887654;
        float f = 5.21321654564f;
        System.out.println(d);
        System.out.println(f);

        long i = 1000000000000000000L;
        System.out.println(i);
        i = 3_000_000_000_000_000_000L;
        System.out.println(i);
        System.out.println("끝!");
    }
}
