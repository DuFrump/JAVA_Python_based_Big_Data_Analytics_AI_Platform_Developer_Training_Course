package game01;

/**
 * 두프룸프님, 여기는 게임의 '상점' 기능을 담당하는 클래스예요.
 * 상점에서는 아이템 목록을 보여주고, 플레이어가 아이템을 구매하는 기능을 처리하죠.
 *
 * 이 코드에서 특히 주목할 부분은 `buy` 메서드와 `Runnable` 인터페이스예요.
 * `Runnable`은 '실행할 수 있는 코드 조각'을 담을 수 있는 주머니 같은 거예요.
 * 이걸 사용하면 아이템 구매 로직을 훨씬 간결하고 멋지게 만들 수 있답니다.
 * 조금 어려울 수 있지만, 이런 방식도 있다는 것을 알아두면 나중에 큰 도움이 될 거예요!
 */
public class Store {

    /**
     * 상점에서 판매하는 아이템 목록을 화면에 보여주는 메서드
     */
    public void showItems() {
        System.out.println("=========== 아이템 상점 ===========");
        System.out.println("어서오세요! 무엇을 도와드릴까요?");
        System.out.println("---------------------------------");
        System.out.println("1. 낡은 검 (+5 공격력) - 100 GOLD");
        System.out.println("2. 강철 검 (+10 공격력) - 300 GOLD");
        System.out.println("3. 가죽 갑옷 (+5 방어력) - 100 GOLD");
        System.out.println("4. 강철 갑옷 (+10 방어력) - 300 GOLD");
        System.out.println("---------------------------------");
        System.out.println("0. 나가기");
    }

    /**
     * 사용자의 선택에 따라 아이템 구매를 처리하는 메서드
     * @param choice 사용자가 입력한 아이템 번호
     * @param player 아이템을 구매하는 플레이어 객체
     */
    public void purchaseItem(int choice, Player player) {
        // switch-case 문을 사용하면 사용자의 선택(choice)에 따라
        // 각기 다른 코드를 실행할 수 있어서 if-else문보다 코드가 깔끔해져요.
        switch (choice) {
            case 1:
                // "낡은 검"을 구매하는 경우
                // buy 메서드에 플레이어, 가격, 아이템 이름, 그리고 아이템 효과를 전달해요.
                // () -> player.atk += 5 부분은 '람다식'이라고 부르는 문법인데,
                // '플레이어의 공격력을 5 증가시키는 코드'를 의미하는 'Runnable' 객체를 즉석에서 만든 거예요.
                buy(player, 100, "낡은 검", () -> player.atk += 5);
                break;
            case 2:
                // "강철 검"을 구매하는 경우
                buy(player, 300, "강철 검", () -> player.atk += 10);
                break;
            case 3:
                // "가죽 갑옷"을 구매하는 경우
                buy(player, 100, "가죽 갑옷", () -> player.def += 5);
                break;
            case 4:
                // "강철 갑옷"을 구매하는 경우
                buy(player, 300, "강철 갑옷", () -> player.def += 10);
                break;
            case 0:
                // 0번을 선택하면 아무것도 하지 않고 switch 문을 빠져나갑니다.
                // (GameMechanism 클래스에서 "상점을 나갑니다" 메시지를 출력할 거예요)
                break;
            default:
                // 1, 2, 3, 4, 0 이외의 번호를 입력한 경우
                System.out.println("잘못된 번호를 입력하셨습니다.");
        }
    }

    /**
     * 실제 아이템 구매 로직을 처리하는 private 메서드
     * private으로 선언하면 이 클래스 내부에서만 사용할 수 있어요.
     *
     * @param player 구매자
     * @param price 아이템 가격
     * @param itemName 아이템 이름
     * @param effect 아이템 효과 (Runnable 객체)
     */
    private void buy(Player player, int price, String itemName, Runnable effect) {
        // 1. 돈이 충분한지 확인
        if (player.gold >= price) {
            // 2. 돈이 충분하면 아이템 효과를 적용
            System.out.printf("'%s'을(를) 구매하셨습니다!%n", itemName);
            effect.run(); // Runnable 객체에 담겨있던 코드(예: player.atk += 5)를 여기서 실행!
            player.gold -= price; // 골드 차감
            System.out.printf("남은 골드: %d GOLD%n", player.gold);
            System.out.printf("(현재 스탯: 공격력 %d, 방어력 %d)%n", player.atk, player.def);
        } else {
            // 3. 돈이 부족하면 메시지 출력
            System.out.println("골드가 부족합니다!");
        }
    }
}