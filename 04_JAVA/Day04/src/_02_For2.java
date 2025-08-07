// 중첩된 `for` 반복문(Nested For Loop)의 사용법을 배우는 예제입니다.
// 중첩 반복문은 반복문 안에 또 다른 반복문이 있는 형태를 말합니다.

public class _02_For2 {
    public static void main(String[] args) {

        // [1] 중첩 for 문 기본 예제: 인사하기
        int count = 0; // 총 인사 횟수를 세는 변수

        // 외부(Outer) for 문: '방'을 나타냅니다. (1번 방부터 5번 방까지)
        for (int i = 1; i <= 5; i++) {
            System.out.printf("안녕하세요. %d번 방 형님..!%n", i);

            // 내부(Inner) for 문: 각 '방' 안의 '형님'들을 나타냅니다. (1번 형님부터 5번 형님까지)
            // 외부 루프가 한 번 반복될 때마다 내부 루프는 완전히 실행됩니다.
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%d번 방 %d번 형님.. 좋은 아침입니다!%n", i, j);
                count++; // 인사 횟수 증가
            }
        }
        System.out.printf("총 인사 한 횟수 : %d번%n", count); // 총 5 * 5 = 25번 인사


        // [2] 세로 구구단 출력
        System.out.println("

=========================> 세로 구구단 <=========================");

        // 구구단 단수 헤더 출력 (2단부터 9단까지)
        for (int i = 2; i < 10; i++) {
            System.out.print("<" + i + "단>\t"); // 각 단의 제목을 출력하고 탭으로 간격 조절
        }
        System.out.println(); // 헤더 출력 후 줄바꿈

        // 외부 for 문: 곱해지는 수 (1부터 9까지)
        for (int i = 1; i < 10; i++) {
            // 내부 for 문: 단수 (2단부터 9단까지)
            for (int j = 2; j < 10; j++) {
                int result = j * i; // (단수) x (곱해지는 수)
                System.out.print(j + "x" + i + "=" + result + "\t"); // 계산 결과 출력하고 탭으로 간격 조절
            }
            System.out.println(); // 한 줄의 계산이 끝나면 줄바꿈
        }


        // [3] 가로 구구단 출력
        System.out.printf("

=================================> 가로 구구단 <=================================");

        // 외부 for 문: 단수 (2단부터 9단까지)
        for (int i = 2; i < 10; i++) {
            System.out.printf("%n<%d단>    ", i); // 각 단의 제목을 출력하고 줄바꿈 및 간격 조절
            // 내부 for 문: 곱해지는 수 (1부터 9까지)
            for (int j = 1; j < 10; j++) {
                int result = i * j; // (단수) x (곱해지는 수)
                System.out.print(i + "x" + j + "=" + result + "\t"); // 계산 결과 출력하고 탭으로 간격 조절
            }
        }
        System.out.println(); // 마지막 출력 후 줄바꿈 (선택 사항)
    }
}

