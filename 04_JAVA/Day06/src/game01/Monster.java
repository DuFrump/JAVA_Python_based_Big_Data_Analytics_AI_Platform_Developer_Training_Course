package game01;

import java.util.Random;

/**
 * 두프룸프님, 이번엔 플레이어의 상대가 될 '몬스터'의 설계도(클래스)예요.
 * 몬스터도 플레이어처럼 HP, 공격력, 방어력 같은 속성을 가지고 있죠.
 *
 * 이 클래스의 재미있는 점은 '보스 몬스터'와 '일반 몬스터'를 구분해서
 * 능력치를 다르게 설정한다는 거예요. 생성자에서 이 로직을 어떻게 구현했는지
 * 유심히 살펴보는 것이 이번 학습의 포인트랍니다!
 */
public class Monster {

    // --- 몬스터의 속성 ---
    int hp;       // 체력
    int atk;      // 공격력
    int def;      // 방어력
    int accuracy; // 명중률 (플레이어가 도망칠 때 사용)
    boolean isBoss; // 보스 몬스터인지 여부를 저장 (true면 보스!)

    // 능력치를 무작위로 설정하기 위해 Random 객체를 생성합니다.
    Random random = new Random();

    /**
     * 몬스터 생성자
     * 몬스터 객체를 만들 때 호출되며, 보스인지 아닌지에 따라 능력치를 다르게 설정해요.
     * @param isBoss GameMechanism 클래스에서 전달해주는 값. true이면 보스 몬스터를 생성합니다.
     */
    public Monster(boolean isBoss) {
        this.isBoss = isBoss;

        if (isBoss) {
            // 보스 몬스터일 경우, 강력한 고정 능력치를 부여합니다.
            System.out.println("★★★★★ 엄청난 기운이 느껴집니다. 보스 몬스터 등장! ★★★★★");
            this.hp = 200;
            this.atk = 25;
            this.def = 10;
            this.accuracy = 90; // 보스로부터는 도망치기 어렵게 명중률을 높게 설정!
        } else {
            // 일반 몬스터일 경우, 능력치를 일정 범위 내에서 무작위로 설정합니다.
            System.out.println("야생의 몬스터가 나타났다!");
            // 예: hp는 30 ~ 50 사이 (random.nextInt(21)은 0~20)
            this.hp = random.nextInt(21) + 30;
            // 예: atk는 10 ~ 15 사이
            this.atk = random.nextInt(6) + 10;
            // 예: def는 3 ~ 7 사이
            this.def = random.nextInt(5) + 3;
            // 예: accuracy는 70 ~ 80 사이
            this.accuracy = random.nextInt(11) + 70;
        }
    }
}