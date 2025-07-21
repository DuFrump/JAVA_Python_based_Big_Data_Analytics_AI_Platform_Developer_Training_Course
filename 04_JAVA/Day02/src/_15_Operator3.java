public class _15_Operator3 {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        double z = 3.14;

        System.out.println(x + y); // 300
        System.out.println(x - y); // -100
        System.out.println(x * y); // 20000
        System.out.println(x / y); // 0
        System.out.println(x % y); // 100

        System.out.println(y + z); // 203.14

        int result = 100000 * 100000; // 10000000000
        System.out.println(result);

        x = 10;
        y = 1;

//        y = y + x;
//        System.out.println(y);

        y += x;
        System.out.println(y); // 11

        y -= x;
        System.out.println(y); // 1

        y += 20;
        System.out.println(y); // 21

        y *= x;
        System.out.println(y); // 210

        y %= x;
        System.out.println(y); // 0

        System.out.println(5 / 2);
        System.out.println((float)(5 / 2));
        System.out.println((float)5 / 2);
        System.out.println(5 % 2);
    }
}
