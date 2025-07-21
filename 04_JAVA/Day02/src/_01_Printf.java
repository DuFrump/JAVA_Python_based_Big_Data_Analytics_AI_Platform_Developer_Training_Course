public class _01_Printf {
    public static void main(String[] args) {
        System.out.printf("저는 대학교 %d학년에 재학 중입니다.", 3);
        System.out.println();
        System.out.printf("%d은 첫 번째, %f은 두 번째, %s은 3 번째.", 1, 2.0, "색");

        System.out.printf("%5d", 1);
        System.out.println();
        System.out.printf("%5d", 12);
        System.out.println();
        System.out.printf("%5d", 123);
        System.out.println();
        System.out.printf("%5d", 1234);
        System.out.println();
        System.out.printf("%5d", 12345);
        System.out.println();
        System.out.printf("%-5d", 1);
        System.out.println();
        System.out.printf("%-5d", 12);
        System.out.println();
        System.out.printf("%-5d", 123);
        System.out.println();
        System.out.printf("%-5d", 1234);
        System.out.println();
        System.out.printf("%-5d", 12345);
        System.out.println();

        System.out.printf("%.1f", 1.234567);
        System.out.println();
        System.out.printf("%.2f", 1.234567);
        System.out.println();
        System.out.printf("%.3f", 1.234567);
        System.out.println();


        int grade = 3;
        System.out.printf("저는 대학교 %d학년에 재학 중입니다.", grade);
    }
}
