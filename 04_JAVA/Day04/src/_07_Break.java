// `break`와 `continue` 키워드를 함께 사용하여 반복문의 흐름을 제어하는 예제입니다.
// `break`: 반복문을 완전히 종료시킵니다.
// `continue`: 현재 반복을 건너뛰고 다음 반복으로 진행합니다.

public class _07_Break {
    public static void main(String[] args) {
        // 치킨 판매 시나리오: 최대 15마리 판매, 7번 손님은 노쇼(No-Show)
        int max = 15; // 하루 최대 판매 가능 치킨 수
        int sold = 0; // 현재까지 판매된 치킨 수
        int noShow = 7; // 노쇼 손님 번호

        System.out.println("--- for 문을 이용한 치킨 판매 ---");
        for (int i = 1; i <= 100; i++) { // 1번 손님부터 100번 손님까지 가정
            // [1] `break` 사용 예시: 판매 목표 달성 시 반복문 종료
            if (sold == max) {
                System.out.println("오늘 장사 끝! 재료 소진입니다.");
                break; // `for` 반복문을 완전히 종료합니다.
            }

            System.out.printf("%d 번 손님! 치킨 나왔습니다!%n", i);

            // [2] `continue` 사용 예시: 노쇼 손님 건너뛰기
            if (i == noShow) {
                System.out.println("에라이.. 노쇼네.. 딴 손님한테 팔아야지.");
                continue; // 현재 반복(7번 손님)의 남은 부분(sold++)을 건너뛰고 다음 반복(8번 손님)으로 넘어갑니다.
            }

            sold++; // 치킨 판매 수 증가
        }

        System.out.printf("%n오늘 몇 마리 팔았지? %d 마리 팔았네.%n", sold);

        System.out.println("
----------------------------------------
");

        // [3] `while` 문에서도 `break`와 `continue`는 동일하게 동작합니다.
        int count = 1; // 손님 번호
        max = 15;      // 초기화
        sold = 0;      // 초기화
        noShow = 7;    // 초기화

        System.out.println("--- while 문을 이용한 치킨 판매 ---");
        while(sold < max) {
            System.out.printf("%d 번 손님! 치킨 나왔습니다!%n", count);

            if (count == noShow) {
                System.out.println("에라이.. 노쇼네.. 딴 손님한테 팔아야지.");
                count++; // 노쇼인 경우에도 손님 번호는 증가시켜야 다음 손님을 처리할 수 있습니다.
                continue;
            }

            sold++;
            count++; // 판매된 경우에도 손님 번호 증가
        }
        System.out.printf("%n오늘 몇 마리 팔았지? %d 마리 팔았네.%n", sold);
    }
}
