public class _05_ForUpgrade {
    public static void main(String[] args) {

        int[] score = {90, 92, 93};

        int sum = 0;
        double avg = 0;

//        for (int i = 0; i < score.length; i++) {
//            sum += score[i];
//        }

        for(int val : score) {
            sum += val;
        }

        avg = (double) sum / 3;

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);

        System.out.println("-----------------------------");

        String[] ggurugi = {"똘기", "떵이", "호치", "새촘이"};
        for(String ggu : ggurugi) {
            System.out.println(ggu);
        }

        // 업그레이드 포문을 이용해서
        // 4명 을 출력

    }
}
