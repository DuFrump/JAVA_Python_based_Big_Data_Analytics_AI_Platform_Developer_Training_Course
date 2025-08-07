// 버블 정렬(Bubble Sort) 알고리즘을 구현한 예제입니다.
// 버블 정렬은 인접한 두 요소를 비교하여 정렬 순서에 맞지 않으면 서로 교환하는 방식입니다.
// 가장 간단한 정렬 알고리즘 중 하나이지만, 효율성은 낮은 편입니다.

public class _04_Bubble {
    public static void main(String[] args) {

        int[] arr = {1, 6, 3, 7, 5, 9}; // 정렬할 배열
        int temp; // 값 교환(swap)을 위한 임시 변수

        System.out.println("--- 버블 정렬 시작 ---");
        System.out.print("정렬 전 배열: ");
        printArray(arr); // 배열 출력 메소드 호출

        // 외부 루프: 배열의 크기만큼 반복 (정확히는 arr.length - 1 번 반복)
        // 각 반복마다 가장 큰(또는 작은) 요소가 배열의 끝으로 '버블링'됩니다.
        for (int i = 0; i < arr.length - 1; i++) { // i는 이미 정렬된 요소의 개수를 나타냅니다.
            // 내부 루프: 인접한 두 요소를 비교하고 교환합니다.
            // (arr.length - 1 - i)는 아직 정렬되지 않은 부분의 마지막 인덱스입니다.
            for (int j = 0; j < arr.length - 1 - i; j++) {

                // 현재 요소(arr[j])가 다음 요소(arr[j+1])보다 크면 (오름차순 정렬 기준)
                if(arr[j] > arr[j+1]) {
                    // 두 요소의 위치를 교환(swap)합니다.
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.print((i + 1) + "회차 정렬 후: ");
            printArray(arr); // 각 회차별 정렬 결과 출력
        }

        System.out.println(" --- 정렬 끝 ---");
        System.out.print("정렬 후 배열: ");
        printArray(arr); // 최종 정렬 결과 출력
    }

    // 배열의 요소를 출력하는 헬퍼 메소드
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}