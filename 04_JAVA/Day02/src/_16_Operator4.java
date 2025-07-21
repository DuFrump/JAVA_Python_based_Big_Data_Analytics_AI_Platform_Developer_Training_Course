public class _16_Operator4 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);

        a = 10;
        b = 11;

        System.out.println(a != --b);

        System.out.println(5 > 3);
        System.out.println(5 <= 3);
        System.out.println(5 != 3);

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        boolean b4 = false;

        System.out.printf("%n%n----------논리곱----------%n");
        System.out.println(b1 && b2); // false
        System.out.println(b1 && b3); // true
        System.out.println(b2 && b4); // false

        System.out.println(b1 && b2 && b3); // false


        System.out.printf("%n%n----------논리합----------%n");
        System.out.println(b1 || b2); // true
        System.out.println(b1 || b3); // true
        System.out.println(b2 || b4); // false

        System.out.println(b1 || b2 || b3); // true

        System.out.printf("%n%n----------배터적 논리합----------%n");
        System.out.println(b1 ^ b2); // true
        System.out.println(b1 ^ b3); // false
    }
}
