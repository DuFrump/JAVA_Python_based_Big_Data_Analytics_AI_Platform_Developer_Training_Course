package game01;

public class Store {
    public void showItems() {
        System.out.println("\n=== 아이템 상점 ===");
        System.out.println("1. 일반 검 (+10 공격력 - 300 GOLD)");
        System.out.println("2. 강철 검 (+25 공격력 - 1000 GOLD)");
        System.out.println("3. 아다만티움 검 (+50 공격력 - 2000 GOLD)");
        System.out.println("4. 일반 방어구 (+5 방어력 - 300 GOLD)");
        System.out.println("5. 강철 방어구 (+15 방어력 - 1000 GOLD)");
        System.out.println("6. 아다만티움 방어구 (+30 방어력 - 2000 GOLD)");
        System.out.println("0. 나가기");
    }

    public void purchaseItem(int choice, Player player) {
        switch (choice) {
            case 1:
                buy(player, 300, "일반 검", () -> player.atk += 10);
                break;
            case 2:
                buy(player, 1000, "강철 검", () -> player.atk += 25);
                break;
            case 3:
                buy(player, 2000, "아다만티움 검", () -> player.atk += 50);
                break;
            case 4:
                buy(player, 300, "일반 방어구", () -> player.def += 5);
                break;
            case 5:
                buy(player, 1000, "강철 방어구", () -> player.def += 15);
                break;
            case 6:
                buy(player, 2000, "아다만티움 방어구", () -> player.def += 30);
                break;
            case 0:
                System.out.println("상점에서 나갑니다.");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }

    private void buy(Player player, int price, String itemName, Runnable effect) {
        if (player.gold >= price) {
            System.out.printf("%s을(를) 구매하셨습니다!\n", itemName);
            effect.run();
            player.gold -= price;
            System.out.printf("잔여 골드: %d GOLD\n", player.gold);
        } else {
            System.out.println("GOLD가 부족합니다!");
        }
    }
}
