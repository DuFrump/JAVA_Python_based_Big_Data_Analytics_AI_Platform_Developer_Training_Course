public class _02_For2 {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.printf("안녕하세요. %d번 방 형님..!%n", i);

            for (int j = 1; j <= 5; j++) {
                System.out.printf("%d번 방 %d번 형님.. 좋은 아침입니다!%n", i, j);
                count++;
            }
        }
        System.out.printf("인사 한 횟수 : %d번", count);


        // 세로 구구단
        System.out.println("\n\n\n=========================> 세로 구구단 <=========================");

        for (int i = 2; i < 10; i++) {
            System.out.print("<" + i + "단>\t");
        }
        System.out.println();

        for (int i = 1; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                int result = i * j;
                System.out.print(j + "x" + i + "=" + result + "\t");
            }
            System.out.println();
        }


        // 가로 구구단
        System.out.printf("\n\n\n=================================> 가로 구구단 <=================================");

        for (int i = 2; i < 10; i++) {
            System.out.printf("%n<%d단>    ", i);
            for (int j = 1; j < 10; j++) {
                int result = i * j;
                System.out.print(i + "x" + j + "=" + result + "\t");
            }
        }
    }
}
