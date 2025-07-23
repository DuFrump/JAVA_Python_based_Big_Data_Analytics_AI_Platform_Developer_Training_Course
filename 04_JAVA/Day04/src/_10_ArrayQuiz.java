import java.util.*;

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

                int[] correct = {6, 11, 17, 33, 39, 42};
                Set<Integer> correctSet = new HashSet<>();
                for (int n : correct) correctSet.add(n);

                int trial = 0;

                while (true) {
                    Set<Integer> mySet = new HashSet<>();
                    while (mySet.size() < 6) {
                        mySet.add((int)(Math.random() * 45) + 1);
                    }

                    int num_correct = 0;
                    for (int n : mySet) {
                        if (correctSet.contains(n)) {
                            num_correct++;
                        }
                    }

                    trial++;

                    if (num_correct == 6) {
                        System.out.println("당첨 번호: " + Arrays.toString(correct));
                        System.out.println("내 번호:    " + mySet);
                        break;
                    }

                    // 너무 오래 걸릴 수 있어서 적당히 종료
                    if (trial % 1_000_000 == 0) {
                        System.out.println("시도 중... 현재 시도 횟수: " + trial);
                    }
                }

                System.out.printf("🎉 로또 당첨! 총 시도 횟수: %,d회\n", trial);
    }
}
