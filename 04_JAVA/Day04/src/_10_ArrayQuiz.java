import java.util.Arrays;

public class _10_ArrayQuiz {
    public static void main(String[] args) {
        // 당첨 번호 = 06 11 17 33 39 42
        // 1 ~ 45번까지

//        int[] correct = {06, 11, 17, 33, 39, 42};
//        int trial = 0;
//
//        while(true) {
//            int num_correct = 0;
//            int[] my_num = new int[6];
//
//            for (int i = 0; i < my_num.length; i++) {
//                my_num[i] = (int)(Math.random() * 45) + 1;
//            }
//
//            for (int i = 0; i < my_num.length; i++) {
//                if (correct[i] == my_num[i]) {
//                    System.out.printf("%d번 째 번호 일치! 정답 번호: %d / 선택 번호: %d%n", (i + 1), correct[i], my_num[i]);
//                    num_correct++;
//                } else {
//                    System.out.printf("%d번 째 번호 불일치! 정답 번호: %d / 선택 번호: %d%n", (i + 1), correct[i], my_num[i]);
//                }
//            }
//
//            if (num_correct == 6) {
//                System.out.printf("축하드립니다! 로또에 당첨 되셨습니다!%n%n");
//            } else {
//                System.out.printf("아쉽게도 당첨 되지 못 하셨습니다.%n%n");
//            }
//
//            trial++;
//
//            if (num_correct == 6) {
//                break;
//            }
//        }
//        System.out.printf("로또 총 시도 횟수 : %d", trial);


        int[] correct = {06, 11, 17, 33, 39, 42};
        int trial = 0;

        while(true) {
            int num_correct = 0;
            int[] my_num = new int[6];

            for (int i = 0; i < my_num.length; i++) {
                my_num[i] = (int)(Math.random() * 45) + 1;
            }

            System.out.println(Arrays.toString(my_num));

            for (int i = 0; i < my_num.length; i++) {
                if (correct[i] == my_num[i]) {
                    num_correct++;
                }
            }

            trial++;

            if (num_correct == 6) {
                break;
            }
        }
        System.out.printf("로또 총 시도 횟수 : %d", trial);
    }
}
