/**
 * 두프룸프님! continue에 이어 이번엔 그의 형님 격인 'break'를 배워볼 시간입니다.
 * continue가 '이번만 패스~' 하고 다음 순서로 넘어가는 가벼운 느낌이었다면,
 * break는 '여기서 모든 걸 중단한다!' 하고 판을 아예 엎어버리는 강력한 키워드에요.
 * 즉, break를 만나는 순간 그 즉시 반복문 전체가 완전히 종료됩니다.
 *
 * 이 예제는 아주 재미있는 '치킨 가게' 시나리오를 사용해요.
 * - break: 하루 판매량(15마리)을 다 채우면 가게 문을 닫는 상황 (반복 종료)
 * - continue: 특정 손님(7번)이 오지 않았을 때(노쇼) 그냥 건너뛰는 상황 (이번 반복만 건너뛰기)
 *
 * break와 continue가 어떻게 다른지, 언제 사용해야 하는지 확실히 감을 잡을 수 있을 거예요!
 */
public class _07_Break {
    public static void main(String[] args) {
        // 치킨 가게 시나리오 설정
        int maxChicken = 15; // 하루에 팔 수 있는 치킨의 최대 수량
        int soldCount = 0;   // 현재까지 판매한 치킨 수
        int noShowCustomer = 7; // 오지 않은 손님 번호

        System.out.println("--- 치킨 가게 오픈! (for문 버전) ---");
        // 손님은 100명까지 올 수 있다고 가정해봅시다.
        for (int i = 1; i <= 100; i++) {
            System.out.printf("\n%d번 손님, 주문하시겠어요?%n", i);

            // [상황1] 7번 손님이 오지 않았다! (No-Show)
            if (i == noShowCustomer) {
                System.out.println("-> 7번 손님 안오시네요! 다음 손님 받겠습니다. (continue!)");
                // continue를 만나서, 아래의 판매 로직(soldCount++)을 건너뛰고 바로 i++로 점프!
                continue;
            }

            // 치킨 판매 성공!
            soldCount++;
            System.out.printf("-> 치킨 1마리 판매 완료! (현재 판매량: %d마리)%n", soldCount);

            // [상황2] 준비된 치킨이 모두 팔렸다!
            if (soldCount == maxChicken) {
                System.out.println("\n*** 재료 소진! 오늘 장사 마감합니다! (break!) ***");
                // break를 만나서, for문 자체가 완전히 끝나버립니다. 100명 손님을 다 채울 필요가 없죠.
                break;
            }
        }

        System.out.printf("\n최종 정산: 오늘 총 %d마리 팔았습니다.%n", soldCount);

        System.out.println("\n----------------------------------------\n");

        // [참고] while문으로도 똑같은 시나리오를 만들 수 있어요.
        System.out.println("--- 치킨 가게 오픈! (while문 버전) ---");
        int customerNum = 1; // 손님 번호
        soldCount = 0;       // 판매량 초기화

        // while문은 보통 이렇게 특정 조건이 만족될 때까지 계속하는 로직에 더 잘 어울려요.
        // "판매량이 최대치보다 적은 동안은 계속 장사한다!"
        while(soldCount < maxChicken) {
            System.out.printf("\n%d번 손님, 주문하시겠어요?%n", customerNum);

            if (customerNum == noShowCustomer) {
                System.out.println("-> 7번 손님 안오시네요! 다음 손님 받겠습니다. (continue!)");

                // ★★★ while문에서 continue를 쓸 때 가장 중요한 점! ★★★
                // continue를 하기 전에, 반복 조건을 변화시키는 customerNum++를 반드시 해줘야 해요.
                // 이걸 안하면 customerNum이 영원히 7에 머물러서 무한 루프에 빠지게 됩니다!
                customerNum++;
                continue;
            }

            soldCount++;
            System.out.printf("-> 치킨 1마리 판매 완료! (현재 판매량: %d마리)%n", soldCount);

            // while문에서는 이 break 조건이 없으면, soldCount가 15가 된 후 while 조건문에 의해 자연스럽게 종료됩니다.
            // 하지만 손님 번호를 계속 증가시켜야 하므로, 아래 코드는 필수입니다.
            customerNum++;
        }
        System.out.printf("\n최종 정산: 오늘 총 %d마리 팔았습니다.%n", soldCount);
    }
}