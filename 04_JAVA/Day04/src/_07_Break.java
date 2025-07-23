public class _07_Break {
    public static void main(String[] args) {
        int max = 15;
        int sold = 0;
        int noShow = 7;

        for (int i = 1; i <= 100; i++) {
            if (sold == max) {
                break;
            }

            System.out.printf("%d 번 손님! 치킨 나왔습니다!%n", i);

            if (i == noShow) {
                System.out.println("에라이.. 노쇼네.. 딴 손님한테 팔아야지.");
                continue;
            }

            sold++;
        }

        System.out.printf("%n오늘 몇 마리 팔았지? %d 마리 팔았네.", sold);


        System.out.println();
        System.out.println();

        int count = 1;
        max = 15;
        sold = 0;
        noShow = 7;

        while(sold < max) {
            System.out.printf("%d 번 손님! 치킨 나왔습니다!%n", count);
            count++;

            if (count == noShow) {
                System.out.println("에라이.. 노쇼네.. 딴 손님한테 팔아야지.");
                continue;
            }

            sold++;
        }
        System.out.printf("%n오늘 몇 마리 팔았지? %d 마리 팔았네.", sold);
    }

}
