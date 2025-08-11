/**
 * 두프룸프님, 드디어 오늘의 마지막 관문, '다차원 배열'입니다! 그중에서도 가장 많이 쓰이는 2차원 배열을 배워볼게요.
 * 지금까지 사용한 배열은 데이터가 한 줄로 늘어선 '1차원' 배열이었어요.
 * 2차원 배열은 이 1차원 배열을 여러 개 묶어서, 마치 엑셀 시트의 '행과 열'처럼 데이터를 관리하는 방식입니다.
 *
 * [아파트 비유로 이해하기]
 * - 1차원 배열 `int[] a = new int[3];` -> 방 3개짜리 단층 주택
 * - 2차원 배열 `int[][] b = new int[2][3];` -> 각 층마다 방이 3개씩 있는 2층짜리 아파트
 *
 * 이 예제에서는 2차원 배열을 만들고, 특정 위치의 값을 읽고 쓰는 방법, 그리고 중첩 for문으로 전체를 탐색하는 법을 배웁니다.
 * 또한, 각 층의 방 개수가 다른 '가변 배열'이라는 재미있는 개념도 만나볼 거예요!
 */
public class _12_MultiArray {
    public static void main(String[] args) {
        // [1] 2차원 배열 만들기 (정방형 - 모든 행의 열 개수가 같음)
        // `new int[2][3]` -> "int형 데이터를 담는 2층짜리 아파트를 지어주세요. 각 층에는 방을 3개씩 만들어주세요."
        // 첫 번째 대괄호 `[2]`는 층(행, row)의 개수, 두 번째 대괄호 `[3]`은 각 층의 방(열, column)의 개수를 의미해요.
        int[][] apartment = new int[2][3];

        // 2차원 배열에 값 할당하기 (입주시키기)
        // `배열이름[층번호][방번호]` 형식으로 접근해요. 물론 층과 방 번호 모두 0부터 시작합니다!
        // 0층 (인덱스 0)
        apartment[0][0] = 101; // 0층 0호
        apartment[0][1] = 102; // 0층 1호
        apartment[0][2] = 103; // 0층 2호
        // 1층 (인덱스 1)
        apartment[1][0] = 201;
        apartment[1][1] = 202;
        apartment[1][2] = 203;

        System.out.println("--- 중첩 for문으로 아파트 전체 호수 확인하기 ---");
        // 2차원 배열을 전체 순회하려면 중첩 for문이 필수적이에요.
        // 바깥 for문: 층(행)을 순회 (0층부터 마지막 층까지)
        for (int i = 0; i < apartment.length; i++) { // apartment.length는 층의 개수(2)를 알려줘요.
            System.out.printf("\n%d층의 호수 목록:%n", i);
            // 안쪽 for문: 현재 층의 방(열)을 순회 (0호부터 마지막 호까지)
            for (int j = 0; j < apartment[i].length; j++) { // apartment[i].length는 i층의 방 개수(3)를 알려줘요.
                System.out.printf("%d호: %d호실\t", j, apartment[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n----------------------------------------\n");

        // [2] 가변 배열 (Jagged Array) 만들기
        // 각 층(행)마다 방(열)의 개수가 다른, 특이한 구조의 아파트를 지어볼게요.
        System.out.println("--- 층마다 방 개수가 다른 가변 배열 아파트 ---");
        int[][] jaggedApt = new int[3][]; // "일단 3층짜리 아파트를 지어줘. 각 층의 방 개수는 나중에 알려줄게."

        // 각 층마다 방 개수를 다르게 설정할 수 있어요.
        jaggedApt[0] = new int[2]; // 0층은 방 2개 (투룸)
        jaggedApt[1] = new int[4]; // 1층은 방 4개 (포룸)
        jaggedApt[2] = new int[1]; // 2층은 방 1개 (원룸, 펜트하우스!)

        // 값 할당 (간단한 예시)
        jaggedApt[0][0] = 1; jaggedApt[0][1] = 2;
        jaggedApt[1][0] = 3; jaggedApt[1][1] = 4; jaggedApt[1][2] = 5; jaggedApt[1][3] = 6;
        jaggedApt[2][0] = 7;

        // 가변 배열도 똑같이 중첩 for문으로 순회할 수 있어요.
        // 안쪽 for문의 조건(jaggedApt[i].length)이 각 층의 길이를 알아서 계산해주기 때문에 완벽하게 동작한답니다.
        for (int i = 0; i < jaggedApt.length; i++) {
            System.out.printf("%d층 (%d개 방): ", i, jaggedApt[i].length);
            for (int j = 0; j < jaggedApt[i].length; j++) {
                System.out.print(jaggedApt[i][j] + " ");
            }
            System.out.println();
        }
    }
}