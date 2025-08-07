// 로또 당첨을 시뮬레이션하는 퀴즈입니다.
// 무작위로 번호를 생성하여 당첨 번호와 비교하고, 당첨될 때까지 시도 횟수를 계산합니다.

import java.util.*; // Arrays, HashSet 등을 사용하기 위해 import 합니다. (현재 코드에서는 직접 사용되지 않지만, 주석 처리된 코드에 포함되어 있음)

public class _10_ArrayQuiz {
    public static void main(String[] args) {
        // [1] 당첨 번호 설정
        // 로또 당첨 번호 (1부터 45 사이의 숫자)
        int[] correct = {6, 11, 17, 33, 39, 42};
        int trial = 0; // 로또 시도 횟수를 기록할 변수

        System.out.println("--- 로또 당첨 시뮬레이션 시작 ---");

        // [2] 무한 반복: 당첨될 때까지 계속 시도합니다.
        while(true) {
            int num_correct = 0; // 이번 시도에서 맞춘 번호의 개수
            int[] my_num = new int[6]; // 내가 선택한 로또 번호를 저장할 배열

            // [2-1] 내 로또 번호 생성 (1부터 45 사이의 난수 6개)
            // 주의: 현재 로직은 중복된 숫자가 생성될 수 있으며, 당첨 번호와 순서까지 일치해야만 '일치'로 간주합니다.
            // 실제 로또는 중복 없는 6개의 숫자가 순서에 상관없이 일치해야 합니다.
            for (int i = 0; i < my_num.length; i++) {
                my_num[i] = (int)(Math.random() * 45) + 1;
            }

            // [2-2] 당첨 번호와 내 번호 비교
            System.out.println("
--- 이번 시도 번호 비교 ---");
            for (int i = 0; i < my_num.length; i++) {
                // correct[i]와 my_num[i]의 값이 같은지 비교
                if (correct[i] == my_num[i]) {
                    System.out.printf("%d번 째 번호 일치! 정답 번호: %d / 선택 번호: %d%n", (i + 1), correct[i], my_num[i]);
                    num_correct++; // 맞춘 번호 개수 증가
                } else {
                    System.out.printf("%d번 째 번호 불일치! 정답 번호: %d / 선택 번호: %d%n", (i + 1), correct[i], my_num[i]);
                }
            }

            // [2-3] 당첨 여부 확인 및 메시지 출력
            if (num_correct == 6) {
                System.out.printf("축하드립니다! 로또에 당첨 되셨습니다!%n%n");
            } else {
                System.out.printf("아쉽게도 당첨 되지 못 하셨습니다.%n%n");
            }

            trial++; // 시도 횟수 1 증가

            // [2-4] 당첨 시 반복 종료
            if (num_correct == 6) {
                break; // `while(true)` 루프를 종료합니다.
            }
        }
        // [3] 최종 시도 횟수 출력
        System.out.printf("로또 총 시도 횟수 : %d회%n", trial);

        // --- 주석 처리된 코드 (HashSet을 이용한 더 정확한 로또 시뮬레이션) ---
        // 아래 코드는 실제 로또처럼 중복 없는 번호 생성과 순서에 상관없는 비교를 위해
        // `HashSet`을 사용한 예시입니다. 학습을 위해 참고하세요.
        /*
        int[] correctAdvanced = {6, 11, 17, 33, 39, 42};
        Set<Integer> correctSet = new HashSet<>();
        for (int n : correctAdvanced) correctSet.add(n);

        int trialAdvanced = 0;

        while (true) {
            Set<Integer> mySet = new HashSet<>();
            while (mySet.size() < 6) {
                mySet.add((int)(Math.random() * 45) + 1);
            }

            int num_correctAdvanced = 0;
            for (int n : mySet) {
                if (correctSet.contains(n)) {
                    num_correctAdvanced++;
                }
            }

            trialAdvanced++;

            if (num_correctAdvanced == 6) {
                System.out.println("당첨 번호: " + Arrays.toString(correctAdvanced));
                System.out.println("내 번호:   " + mySet);
                break;
            }

            // 너무 오래 걸릴 수 있어서 적당히 종료
            if (trialAdvanced % 1_000_000 == 0) {
                System.out.println("시도 중... 현재 시도 횟수: " + trialAdvanced);
            }
        }

        System.out.printf("🎉 로또 당첨! 총 시도 횟수: %,d회
", trialAdvanced);
        */
    }
}
