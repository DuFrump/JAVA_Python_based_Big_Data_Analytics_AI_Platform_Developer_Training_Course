public class _04_DataType {
    public static void main(String[] args) {
        // byte -128 ~ 127
        // short -32768 ~ 32767
        // int -21억 ~ 21억
        // long -900경 ~ 900경


        int a = 30;
        byte age = 100;
//        byte age2 = 128;

        short b = 32767;
//        short c = 32768;

        System.out.println(b);
//        System.out.println(c);

        // 소수 표현
        // float 7자리까지
        // double 15자리까지

        double marathon = 42.195;
        float half_marathon = 21.0975f;

        System.out.println("마라톤은 " + marathon + "km를 달립니다.");
        System.out.println("하프 마라톤은 " + half_marathon + "km를 달립니다.");

        double pieDouble = 3.141592653589793;
        float pieFloat = 3.141592653589793f;

        System.out.println("double : " + pieDouble);
        System.out.println("Float : " + pieFloat);
    }
}
