public class _07_TypeTrans {
    public static void main(String[] args) {
        int num1 = 11;
        double num2 = 3.14;
        double num3 = (double)num1;

        System.out.println(num1 + num2);
        System.out.println(num2 + num3);
        System.out.println(num3);

        System.out.println((int)1.23);

        int a = 128;
        byte b = (byte)a;
        System.out.println(b);

        int c = 33;
        double d = c;

        System.out.println(d);
    }
}
