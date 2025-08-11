package game01;

import java.util.Random;

/**
 * 두프룸프님, 이 파일은 미니 RPG 게임의 주인공, 바로 '플레이어'의 설계도(클래스)예요.
 * 플레이어가 가져야 할 능력치(HP, 공격력, 방어력 등)와
 * 플레이어가 할 수 있는 행동(회복하기 등)을 여기서 모두 정의한답니다.
 *
 * 이렇게 게임의 구성 요소를 하나씩 클래스로 만들어두면
 * 코드가 훨씬 깔끔해지고 관리하기 쉬워지는 장점이 있어요.
 * 이런 프로그래밍 방식을 '객체 지향 프로그래밍(OOP)'이라고 부른답니다.
 */
public class Player {

    // --- 플레이어의 속성 (능력치) ---
    int hp;         // 현재 체력
    final int MAX_HP; // 최대 체력 (final 키워드는 '상수'를 의미해요. 한 번 정해지면 바꿀 수 없죠!)
    int atk;        // 공격력
    int def;        // 방어력
    int gold;       // 보유 골드
    int evasion;    // 회피율 (도망칠 때 사용)

    // heal() 메서드에서 난수를 사용하기 위해 Random 객체를 미리 만들어 둬요.
    Random random = new Random();

    /**
     * 플레이어 생성자
     * 게임이 시작될 때 플레이어 객체를 만들면서 호출돼요.
     * 여기서 플레이어의 초기 능력치를 설정해 줍니다.
     */
    public Player() {
        this.MAX_HP = 100;    // 최대 체력은 100으로 고정
        this.hp = 100;        // 현재 체력도 100으로 시작
        this.atk = 15;        // 초기 공격력
        this.def = 5;         // 초기 방어력
        this.gold = 100;      // 초기 소지 골드
        this.evasion = 10;    // 초기 회피율
    }

    /**
     * 플레이어의 행동: 회복하기
     * 골드를 소모해서 체력을 회복하는 기능이에요.
     */
    public void heal() {
        // 1. 이미 체력이 가득 찼는지 확인
        if (hp == MAX_HP) {
            System.out.println("체력이 이미 가득 차 있습니다. 회복할 수 없습니다.");
            return; // return을 만나면 메서드가 즉시 종료돼요.
        }

        // 2. 회복에 필요한 골드가 충분한지 확인
        int healCost = 50; // 회복 비용
        if (gold < healCost) {
            System.out.println("골드가 부족합니다. (필요 골드: " + healCost + ")");
            return;
        }

        // 3. 회복량 결정 및 회복 처리
        // 5 ~ 15 사이의 난수를 회복량으로 결정해요. (random.nextInt(11)은 0~10)
        int recoverAmount = random.nextInt(11) + 5;
        int beforeHp = hp; // 회복 전 체력을 기록

        // 회복 후 체력이 최대 체력을 넘지 않도록 Math.min()을 사용해요.
        // 둘 중 더 작은 값을 선택해주므로, MAX_HP를 절대 넘을 수 없게 되죠.
        hp = Math.min(hp + recoverAmount, MAX_HP);

        int actualRecovered = hp - beforeHp; // 실제 회복된 양 계산
        gold -= healCost; // 골드 차감

        System.out.println("회복 비용으로 " + healCost + " GOLD를 지불했습니다!");
        System.out.printf("체력을 %d만큼 회복했습니다! (현재 체력: %d / %d)%n", actualRecovered, hp, MAX_HP);
    }
}