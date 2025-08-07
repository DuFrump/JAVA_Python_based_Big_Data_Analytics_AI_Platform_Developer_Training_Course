// 다차원 배열(Multi-dimensional Array), 특히 2차원 배열의 선언, 초기화, 요소 접근,
// 그리고 가변 배열(Jagged Array)에 대해 배우는 예제입니다.

public class _12_MultiArray {
    public static void main(String[] args) {
        // [1] 2차원 배열 선언 및 초기화 (정방형 배열)
        // `int[][] seats = new int[2][3];`
        // - `int[][]`: int 타입의 2차원 배열을 선언합니다.
        // - `new int[2][3]`: 2행 3열의 2차원 배열을 생성합니다. (총 2 * 3 = 6개의 int 값을 저장할 수 있음)
        //   - 첫 번째 대괄호는 행(row)의 개수, 두 번째 대괄호는 열(column)의 개수를 의미합니다.
        int[][] seats = new int[2][3];

        // 2차원 배열 요소에 값 할당
        // `seats[행 인덱스][열 인덱스]` 형태로 접근합니다. 인덱스는 0부터 시작합니다.
        seats[0][0] = 1; // 0행 0열
        seats[0][1] = 2; // 0행 1열
        seats[0][2] = 3; // 0행 2열
        seats[1][0] = 4; // 1행 0열
        seats[1][1] = 5; // 1행 1열
        seats[1][2] = 6; // 1행 2열

        // 2차원 배열의 `length` 속성
        // `seats.length`: 2차원 배열의 행(row)의 개수를 반환합니다.
        System.out.println("배열의 행 개수 (seats.length): " + seats.length); // 출력: 2
        // `seats[행 인덱스].length`: 해당 행의 열(column)의 개수를 반환합니다.
        System.out.println("0번 행의 열 개수 (seats[0].length): " + seats[0].length); // 출력: 3
        System.out.println("1번 행의 열 개수 (seats[1].length): " + seats[1].length); // 출력: 3

        // 특정 요소 값 출력
        System.out.println("seats[1][1]의 값: " + seats[1][1]); // 출력: 5

        System.out.println("
----------------------------------------
");

        // [2] 가변 배열(Jagged Array) 선언 및 초기화
        // 행의 크기만 먼저 지정하고, 각 행의 열 크기는 나중에 다르게 지정할 수 있습니다.
        int[][] arr05 = new int[3][]; // 3개의 행을 가진 2차원 배열 선언 (각 행의 열 크기는 아직 미정)

        // 각 행의 열 크기를 다르게 지정합니다.
        arr05[0] = new int[1]; // 0번 행은 1개의 열을 가짐
        arr05[1] = new int[3]; // 1번 행은 3개의 열을 가짐
        arr05[2] = new int[2]; // 2번 행은 2개의 열을 가짐

        // 가변 배열의 각 요소에 값 할당 (예시)
        arr05[0][0] = 10;
        arr05[1][0] = 20; arr05[1][1] = 21; arr05[1][2] = 22;
        arr05[2][0] = 30; arr05[2][1] = 31;

        // 가변 배열의 요소 출력 (중첩 반복문 사용)
        System.out.println("--- 가변 배열 요소 출력 ---");
        for (int i = 0; i < arr05.length; i++) { // 각 행을 순회
            for (int j = 0; j < arr05[i].length; j++) { // 각 행의 열을 순회
                System.out.print(arr05[i][j] + " ");
            }
            System.out.println(); // 한 행 출력 후 줄바꿈
        }
    }
}
