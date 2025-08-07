// 중첩된 `for` 반복문을 사용하여 다양한 형태의 별(또는 문자) 피라미드를 그리는 예제입니다.

public class _03_Pyramid {
    public static void main(String[] args) {
        // [1] 왼쪽 정렬된 직각 삼각형 (점점 증가하는 별)
        // 예시: 
        // *
        // **
        // ***
        System.out.println("--- 왼쪽 정렬 직각 삼각형 (증가) ---");
        for (int i = 0; i < 10; i++) { // 외부 루프: 줄(행)을 제어합니다. (0부터 9까지 10줄)
            for (int j = 0; j <= i; j++) { // 내부 루프: 각 줄에 출력할 별의 개수를 제어합니다.
                System.out.print("*"); // j가 i까지 반복하므로, i가 증가할수록 별의 개수도 증가
            }
            System.out.println(); // 한 줄의 별 출력이 끝나면 줄바꿈
        }

        System.out.println("
----------------------------------------
");

        // [2] 정삼각형 (피라미드)
        // 예시:
        //     *
        //    ***
        //   *****
        System.out.println("--- 정삼각형 (피라미드) ---");
        for (int i = 1; i <= 10; i++) { // 외부 루프: 줄(행)을 제어합니다. (1부터 10까지 10줄)
            // 공백 출력: (총 줄 수 - 현재 줄 번호) 만큼 공백 출력
            for (int k = 0; k < 10 - i; k++) {
                System.out.print(" ");
            }

            // 별 출력: (현재 줄 번호 * 2 - 1) 만큼 별 출력
            for (int j = 0; j < (i * 2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println(); // 한 줄의 출력 끝나면 줄바꿈
        }

        System.out.println("
----------------------------------------
");

        // [3] 왼쪽 정렬된 역직각 삼각형 (점점 감소하는 별)
        // 예시:
        // *****
        // ****
        // ***
        System.out.println("--- 왼쪽 정렬 역직각 삼각형 (감소) ---");
        for (int i = 0; i < 10; i++) { // 외부 루프: 줄(행)을 제어합니다. (0부터 9까지 10줄)
            for (int j = 0; j < 10 - i; j++) { // 내부 루프: 각 줄에 출력할 별의 개수를 제어합니다.
                System.out.print("*"); // i가 증가할수록 별의 개수는 감소
            }
            System.out.println(); // 한 줄의 별 출력이 끝나면 줄바꿈
        }

        System.out.println("
----------------------------------------
");

        // [4] 오른쪽 정렬된 직각 삼각형 (점점 증가하는 별)
        // 예시:
        //         *
        //        **
        //       ***
        System.out.println("--- 오른쪽 정렬 직각 삼각형 (증가) ---");
        for (int i = 0; i <= 10; i++) { // 외부 루프: 줄(행)을 제어합니다. (0부터 10까지 11줄)
            // 공백 출력: (총 줄 수 - 현재 줄 번호) 만큼 공백 출력
            for (int j = 0; j < 10 - i; j++) {
                System.out.print(" ");
            }

            // 별 출력: (현재 줄 번호) 만큼 별 출력
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(); // 한 줄의 출력 끝나면 줄바꿈
        }

        System.out.println("
----------------------------------------
");

        // [5] 다이아몬드 (마름모)
        // 정삼각형과 역정삼각형을 조합하여 만듭니다.
        System.out.println("--- 다이아몬드 (마름모) ---");
        int N = 10; // 피라미드의 최대 높이 (중앙 기준)

        for (int i = -N; i <= N; i++) { // 외부 루프: -N부터 N까지 (총 2N+1 줄)
            int space = Math.abs(i); // Math.abs()는 절대값을 반환합니다.
            int star = 2 * (N - space) + 1;

            // 공백 출력
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }

            // 별 출력
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            System.out.println(); // 한 줄의 출력 끝나면 줄바꿈
        }
    }
}
