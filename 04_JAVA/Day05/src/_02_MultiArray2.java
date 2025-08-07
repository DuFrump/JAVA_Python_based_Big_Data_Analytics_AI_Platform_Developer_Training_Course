// 2차원 배열의 선언, 초기화, 그리고 중첩 반복문을 이용한 순회 방법을 다양한 예시로 배우는 예제입니다.

public class _02_MultiArray2 {
    public static void main(String[] args) {
        // [1] 정방형 2차원 배열 (모든 행의 열 개수가 동일)
        // 영화관 좌석 배치도와 같이 행과 열이 고정된 형태에 적합합니다.
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4", "A5"}, // 0번 행
                {"B1", "B2", "B3", "B4", "B5"}, // 1번 행
                {"C1", "C2", "C3", "C4", "C5"}  // 2번 행
        };

        System.out.println("--- 정방형 2차원 배열 출력 ---");
        // 중첩 for 문을 사용하여 모든 좌석 정보를 출력합니다.
        // 외부 루프: 행(row)을 순회 (0부터 2까지 총 3행)
        for (int i = 0; i < 3; i++) {
            // 내부 루프: 열(column)을 순회 (0부터 4까지 총 5열)
            for (int j = 0; j < 5; j++) {
                System.out.print(seats[i][j] + " "); // 각 좌석 정보 출력
            }
            System.out.println(); // 한 행의 출력이 끝나면 줄바꿈
        }

        System.out.println("
----------------------------------------
");

        // [2] 가변 배열(Jagged Array) 선언 및 초기화
        // 각 행의 열 개수가 다를 수 있는 배열입니다.
        // 예를 들어, 영화관의 각 열마다 좌석 수가 다를 때 유용합니다.
        String[][] seats2 = {
                {"A1", "A2", "A3"},             // 0번 행: 3개
                {"B1", "B2", "B3", "B4"},         // 1번 행: 4개
                {"C1", "C2", "C3", "C4", "C5", "C6"}, // 2번 행: 6개
                {"D1", "D2"}                    // 3번 행: 2개
        };

        System.out.println("--- 가변 2차원 배열 출력 ---");
        // 가변 배열을 순회할 때는 `배열이름.length`로 행의 개수를, `배열이름[i].length`로 각 행의 열 개수를 얻습니다.
        for (int i = 0; i < seats2.length; i++) { // 외부 루프: 행(row)을 순회 (seats2.length는 4)
            for (int j = 0; j < seats2[i].length; j++) { // 내부 루프: 현재 행의 열(column)을 순회
                System.out.print(seats2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("
----------------------------------------
");

        // [3] 2차원 배열을 이용한 좌석 배치도 생성 및 출력
        // 10행 15열의 좌석 배열을 만들고, 각 좌석에 'A1', 'A2'... 와 같은 형태로 값을 할당합니다.
        int[][] seats3 = new int[10][15]; // 10행 15열의 int형 2차원 배열
        String[] eng = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; // 행 번호에 사용할 알파벳

        // 좌석 번호 할당
        for (int i = 0; i < 10; i++) { // 행 순회
            int count = 1; // 각 행의 좌석 번호를 1부터 시작하기 위한 변수
            for (int j = 0; j < 15; j++) { // 열 순회
                seats3[i][j] = count++; // seats3[i][j]에 값을 할당하고 count를 1 증가
            }
        }

        System.out.println("--- 좌석 배치도 생성 및 출력 ---");
        // 좌석 배치도 출력
        for (int i = 0; i < 10; i++) { // 행 순회
            for (int j = 0; j < 15; j++) { // 열 순회
                // eng[i] (알파벳 행)와 seats3[i][j] (숫자 열)를 조합하여 출력
                System.out.printf("%s%d ", eng[i], seats3[i][j]); // 예: A1, A2, ...
            }
            System.out.println(); // 한 행 출력 후 줄바꿈
        }
    }
}
