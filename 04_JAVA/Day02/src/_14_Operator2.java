public class _14_Operator2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num); // 10
        num++;
        System.out.println(num); // 11

        int age = 30;
        System.out.println(age++); // 30
        System.out.println(age); // 31

        int abc = 5;
        System.out.println(++abc);

        int x = 1;
        System.out.println(x++); // 1 -> 2
        System.out.println(x); // 2
        System.out.println(++x); // -> 3

        int a = 'X';
        System.out.println(a);
        int b = 'Y';
        System.out.println(b);

        char alphabet_x = 'X';
        System.out.println(alphabet_x); // X
        System.out.println(++alphabet_x); // Y

        boolean isHuman = false;
        System.out.println(isHuman);
        System.out.println(!isHuman);

        x = 10;
        System.out.println(x); // 10
        System.out.println(--x); // 9
        System.out.println(x); // 9
        System.out.println(x--); // 9
    }
}
