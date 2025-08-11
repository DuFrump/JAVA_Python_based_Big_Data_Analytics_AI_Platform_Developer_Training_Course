package game01;

import java.util.Random;
import java.util.Scanner;

/**
 * 두프룸프님, 드디어 게임의 심장부, `GameMechanism` 클래스에 도착했네요!
 * 'Mechanism'은 '구조'나 '장치'를 의미하는데, 말 그대로 게임이 돌아가게 하는
 * 모든 핵심적인 흐름과 규칙이 바로 여기에 담겨 있어요.
 *
 * 여기서 우리는
 * 1. `Player`, `Monster`, `Store` 클래스의 객체를 만들어서 서로 상호작용하게 하고,
 * 2. `while` 반복문과 `switch` 조건문으로 게임의 전체 흐름(메인 루프)을 만들고,
 * 3. 전투, 회복, 상점 이용 등 각 기능을 메서드로 나누어 관리하는 방법을 배울 거예요.
 *
 * 이 파일의 구조를 이해하면, 다른 복잡한 프로그램을 만들 때도 큰 도움이 될 거예요!
 */
public class GameMechanism {
    // private은 이 클래스 안에서만 접근할 수 있다는 의미예요.
    // 다른 곳에서 함부로 플레이어나 상점 정보를 바꾸지 못하게 막아주는 역할을 하죠.
    private Player player;
    private Store store;
    private Scanner scanner;
    private Random random; // 난수 생성을 위해 추가

    /**
     * GameMechanism 생성자
     * 게임 시작에 필요한 객체들을 여기서 미리 만들어(초기화) 둡니다.
     */
    public GameMechanism() {
        player = new Player(); // 플레이어 객체 생성
        store = new Store();   // 상점 객체 생성
        scanner = new Scanner(System.in); // 사용자 입력을 받을 스캐너 생성
        random = new Random(); // 난수 생성을 위한 Random 객체 생성
    }

    /**
     * 게임을 시작하고 전체 흐름을 제어하는 메인 메서드
     */
    public void start() {
        // `while(true)`는 무한 반복문을 의미해요. 사용자가 '0. 종료'를 선택하기 전까지 계속 실행됩니다.
        while (true) {
            showMainMenu(); // 메인 메뉴를 보여주는 메서드 호출
            int choice = scanner.nextInt(); // 사용자의 선택을 입력받음

            // 사용자의 선택(choice)에 따라 다른 기능을 실행
            switch (choice) {
                case 1:
                    battle(); // 전투 시작
                    break;
                case 2:
                    player.heal(); // 플레이어 회복
                    break;
                case 3:
                    checkGold(); // 골드 확인
                    break;
                case 4:
                    enterStore(); // 상점 입장
                    break;
                case 5:
                    checkStats(); // 스탯 확인
                    break;
                case 0:
                    System.out.println("게임을 종료합니다. 다음에 또 만나요!");
                    scanner.close(); // 스캐너를 닫아주는 것이 좋아요.
                    return; // return을 통해 start() 메서드와 while문을 완전히 종료시킴
                default:
                    System.out.println("잘못된 번호를 입력했습니다. 다시 선택해주세요.");
            }

            // 플레이어의 HP가 0 이하가 되면 게임 오버
            if (player.hp <= 0) {
                System.out.println("당신은 쓰러졌습니다... GAME OVER");
                break; // while문을 탈출하여 게임을 종료합니다.
            }
        }
    }

    /**
     * 메인 메뉴를 보여주는 기능
     */
    private void showMainMenu() {
        System.out.println("========== 미니 RPG 게임 ===========");
        System.out.println("무엇을 하시겠습니까?");
        System.out.println("1. 전투 (몬스터를 사냥하여 골드를 법니다)");
        System.out.println("2. 회복 (50 골드를 소모하여 체력을 회복합니다)");
        System.out.println("3. 골드 확인");
        System.out.println("4. 상점 (골드로 장비를 구매하여 강해집니다)");
        System.out.println("5. 내 정보 확인");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }

    /**
     * 전투 기능을 담당하는 메서드
     */
    private void battle() {
        // 10% 확률로 보스 몬스터가 등장합니다. (Math.random()은 0.0 ~ 1.0 사이의 실수를 반환)
        boolean isBoss = Math.random() < 0.1;
        Monster monster = new Monster(isBoss); // 몬스터 생성

        System.out.printf("몬스터 정보 - HP: %d, 공격력: %d, 방어력: %d%n", monster.hp, monster.atk, monster.def);

        // 플레이어나 몬스터 둘 중 하나의 HP가 0 이하가 될 때까지 전투를 반복
        while (player.hp > 0 && monster.hp > 0) {
            System.out.println("--- 전투 메뉴 ---");
            System.out.println("1. 공격한다");
            System.out.println("2. 도망친다");
            System.out.print("선택: ");
            int fightChoice = scanner.nextInt();

            if (fightChoice == 1) {
                // 플레이어의 공격
                // Math.max(계산값, 0)은 계산값이 음수가 되더라도 최소 0을 보장해줘요.
                // 즉, 방어력이 공격력보다 높아도 데미지가 마이너스가 되지 않게(오히려 회복되는 현상 방지) 막아줍니다.
                int damageToMonster = Math.max(player.atk - monster.def, 0);
                monster.hp -= damageToMonster;
                System.out.printf("몬스터에게 %d의 데미지를 입혔습니다! (몬스터 남은 HP: %d)%n", damageToMonster, Math.max(0, monster.hp));

                // 몬스터가 쓰러졌는지 확인
                if (monster.hp <= 0) {
                    System.out.println("축하합니다! 몬스터를 물리쳤습니다!");
                    int reward = monster.isBoss ? 500 : random.nextInt(51) + 50; // 보스면 500, 일반몹은 50~100 골드
                    player.gold += reward;
                    System.out.printf("보상으로 %d GOLD를 얻었습니다! (현재 골드: %d)%n", reward, player.gold);
                    break; // 전투 종료 (while문 탈출)
                }

                // 몬스터의 공격
                int damageToPlayer = Math.max(monster.atk - player.def, 0);
                player.hp -= damageToPlayer;
                System.out.printf("몬스터가 당신에게 %d의 데미지를 입혔습니다! (남은 HP: %d / %d)%n", damageToPlayer, Math.max(0, player.hp), player.MAX_HP);

            } else if (fightChoice == 2) {
                // 도망치기
                // 회피율(evasion)보다 낮은 숫자가 나오면 성공!
                if (random.nextInt(100) < player.evasion) {
                    System.out.println("무사히 도망쳤습니다!");
                    break; // 전투 종료
                } else {
                    System.out.println("도망에 실패했습니다! 몬스터에게 공격받습니다.");
                    int damageToPlayer = Math.max(monster.atk - player.def, 0);
                    player.hp -= damageToPlayer;
                    System.out.printf("몬스터가 당신에게 %d의 데미지를 입혔습니다! (남은 HP: %d / %d)%n", damageToPlayer, Math.max(0, player.hp), player.MAX_HP);
                }
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

    /**
     * 상점 기능을 담당하는 메서드
     */
    private void enterStore() {
        System.out.println("상점에 입장합니다.");
        while (true) {
            store.showItems(); // 상점 아이템 목록 보여주기
            System.out.printf("(현재 보유 골드: %d GOLD)%n", player.gold);
            System.out.print("구매할 아이템 번호를 입력하세요 (0 입력 시 나가기): ");
            int storeChoice = scanner.nextInt();

            if (storeChoice == 0) {
                System.out.println("상점을 나갑니다.");
                break; // 상점 이용 종료 (while문 탈출)
            }

            store.purchaseItem(storeChoice, player); // 아이템 구매 처리
        }
    }

    /**
     * 현재 스탯을 확인하는 메서드
     */
    private void checkStats() {
        System.out.println("========== 내 정보 ==========");
        System.out.printf("HP : %d / %d%n", player.hp, player.MAX_HP);
        System.out.printf("공격력 : %d%n", player.atk);
        System.out.printf("방어력 : %d%n", player.def);
        System.out.printf("회피율 : %d%%%n", player.evasion);
        System.out.printf("보유 골드 : %d GOLD%n", player.gold);
        System.out.println("============================");
    }

    /**
     * 보유 골드를 확인하는 메서드
     */
    private void checkGold() {
        System.out.printf("%n현재 보유하고 있는 골드는 %d GOLD 입니다.%n", player.gold);
    }
}