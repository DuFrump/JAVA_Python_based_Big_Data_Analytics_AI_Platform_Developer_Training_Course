public class _12_Out {
    public static void main(String[] args) {
        System.out.println("--------------정수---------------");
        System.out.printf("%d%n", 1);
        System.out.printf("%d %d %d%n", 1, 2, 3);
        System.out.printf("%6d%n", 1234);
        System.out.printf("%06d%n", 1234);
        System.out.printf("%6d%n", -1234);
        System.out.printf("%+6d%n", 1234);
        System.out.printf("%+6d%n", -1234);
        System.out.printf("%,12d%n", 300000000);
        System.out.printf("%-6d%n%n", 1234);


        System.out.println("--------------실수---------------");
        System.out.printf("%f%n", Math.PI);
        System.out.printf("%.2f%n", Math.PI);
        System.out.printf("%6.2f%n", Math.PI);
        System.out.printf("%-6.2f%n", Math.PI);
        System.out.printf("%06.2f%n", Math.PI);
        System.out.printf("%+6.2f%n%n", Math.PI);


        System.out.println("--------------문자열---------------");
        System.out.printf("%s%n", "JAVA");
        System.out.printf("%6s%n", "JAVA");
        System.out.printf("%-6s%n", "JAVA");
        System.out.printf("%6.2s%n", "JAVA");
        System.out.printf("%-6.2s%n%n", "JAVA");


        System.out.println("--------------응용---------------");
        System.out.println("이름 영어 수학 평균");
        System.out.println("나루토 " + 90 + " " + 80 + " " + 85.0);
        System.out.println("사스케 " + 100 + " " + 100 + " " + 100.0);
        System.out.println("사쿠라 " + 95 + " " + 100 + " " + 97.5);


        System.out.printf("%n%n--------------응용2---------------%n");
        System.out.printf("%-6s %5s %4s %5s%n", "이름", "영어", "수학", "평균"); // 공백 6, 3, 3칸
        System.out.printf("%-6s %5d %5d %7.1f%n", "나루토", 90, 80, 85.0);
        System.out.printf("%-6s %5d %5d %7.1f%n", "사스케", 100, 100, 100.0);
        System.out.printf("%-6s %5d %5d %7.1f%n", "사쿠라", 95, 100, 97.5);


        System.out.printf("%n--------------응용2---------------%n");
        System.out.println("ABCDEFG");
        System.out.println("abcdefg");

        System.out.println("가나다라마바사");
        System.out.println("가 나 다 라");

    }
}
