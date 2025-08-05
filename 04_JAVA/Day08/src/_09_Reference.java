class Camera {
    String name;

    Camera(String name) {
        this.name = name;
    }
}

public class _09_Reference {
    public static void main(String[] args) {
        /**
         * 참조
         * int, float, double, long, boolean, char .... (소문자로 시작)
         * 기본 자료형
         * */

        int[] i = new int[3];
        System.out.println(i[0]);
        System.out.println(i[1]);

        double[] d = new double[1];
        System.out.println(d[0]);

        // 참조 자료형 - String, Animal, Pig ... (대문자로 시작)
        String[] s = new String[3];
        System.out.println(s[0]);

        Camera[] a = new Camera[3];
        System.out.println(a[0] == null);

        /**
         * 기본 자료형 - null, 메서드 가질 수 없다.
         * 참조 자료형 - null, 메서드 가질 수 있다.
         * */


        System.out.println("=================================");


        int c = 10;
        int b = 20;

        b = c;
        System.out.println(c); // 10
        System.out.println(b); // 10

        b = 30;
        System.out.println(c); // 10
        System.out.println(b); // 30

        c = 40;
        System.out.println(c); // 40
        System.out.println(b); // 30


        System.out.println("=================================");


        Camera c1 = new Camera("카메라1");
        Camera c2 = new Camera("카메라2");
        System.out.println(c1.name);
        System.out.println(c2.name);

        c1 = c2;
        System.out.println(c1.name);
        System.out.println(c2.name);

        c2.name = "고장난 카메라";
        System.out.println(c1.name);
        System.out.println(c2.name);
        // 참조 자료형은 c2 = c1 에서 연결됨


        System.out.println("=================================");


        changeName(c2);
        System.out.println(c2.name);
        System.out.println(c1.name);
    }

    public static void changeName(Camera camera) { camera.name = "잘못된 카메라";}
}
