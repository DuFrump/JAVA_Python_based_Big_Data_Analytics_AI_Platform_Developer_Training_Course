package game01;

import java.util.Random;
import java.util.Scanner;

public class GameMechanism {
    private Player player;
    private Store store;
    private Scanner scanner;

    public GameMechanism() {
        player = new Player();
        store = new Store();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n\n=== 미니 RPG 게임 ===");
            System.out.println("1. 전투");
            System.out.println("2. 회복");
            System.out.println("3. 골드 확인");
            System.out.println("4. 상점");
            System.out.println("5. 스탯 확인");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            boolean isBoss = Math.random() < 0.007;
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Monster monster = new Monster(isBoss);

                    System.out.println("\n===========================================");

                    System.out.printf("몬스터 등장! HP: %d, ATK: %d, DEF: %d\n",
                            monster.hp, monster.atk, monster.def);

                    while (player.hp > 0 && monster.hp > 0) {
                        System.out.println("1. 공격한다");
                        System.out.println("2. 도망친다");
                        int fightChoice = scanner.nextInt();

                        if (fightChoice == 1) {
                            int damageToMonster = Math.max(player.atk - monster.def, 0);
                            monster.hp -= damageToMonster;
                            System.out.printf("몬스터에게 %d 데미지를 입혔습니다!\n", damageToMonster);

                            if (monster.hp <= 0) {
                                System.out.println("몬스터를 물리쳤습니다!");
                                int reward = new Random().nextInt(101) + 100;
                                player.gold += reward;
                                System.out.printf("보상으로 %d GOLD를 얻었습니다!\n", reward);
                                break;
                            }

                            int damageToPlayer = Math.max(monster.atk - player.def, 0);
                            player.hp -= damageToPlayer;
                            System.out.printf("몬스터가 %d 데미지를 입혔습니다! 현재 HP: %d\n", damageToPlayer, player.hp);

                        } else if (fightChoice == 2) {
                            int chance = new Random().nextInt(100);
                            if (player.evasion > monster.accuracy || chance < (player.evasion - monster.accuracy)) {
                                System.out.println("도망에 성공했습니다!");
                                break;
                            } else {
                                System.out.println("도망에 실패했습니다! 몬스터가 공격합니다.");
                                int damage = Math.max(monster.atk - player.def, 0);
                                player.hp -= damage;
                                System.out.printf("몬스터가 %d 데미지를 입혔습니다! 현재 HP: %d\n", damage, player.hp);
                            }
                        } else {
                            System.out.println("잘못된 선택입니다.");
                        }

                        if (player.hp <= 0) {
                            System.out.println("당신은 쓰러졌습니다. GAME OVER");
                            return;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n===========================================");

                    System.out.println("회복을 시도합니다.");
                    player.heal();
                    break;
                case 3:
                    System.out.println("\n===========================================");

                    System.out.println("가지고 있는 골드를 확인합니다.");
                    System.out.printf("잔여 골드 : %d GOLD", player.gold);
                    break;
                case 4:
                    System.out.println("\n===========================================");

                    System.out.println("상점에 입장합니다.");
                    while (true) {
                        store.showItems();
                        System.out.print("구매할 아이템 번호를 입력하세요 (0 입력 시 나가기): ");
                        int storeChoice = scanner.nextInt();

                        if (storeChoice == 0) {
                            System.out.println("상점을 나갑니다.");
                            break;
                        }

                        store.purchaseItem(storeChoice, player);
                    }
                    break;
                case 5:
                    System.out.println("\n===========================================");

                    System.out.println("현재 스탯을 확인합니다.");
                    System.out.printf("HP : %d%n", player.hp);
                    System.out.printf("공격력 : %d%n", player.atk);
                    System.out.printf("방어력 : %d%n", player.def);
                    break;
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
