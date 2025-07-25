package game01;

import java.util.Random;

public class Player {
    int hp;
    final int MAXHP;
    int atk;
    int def;
    int gold;
    int evasion;

    Random random = new Random();

    public Player() {
        this.MAXHP = 100;
        this.hp = 100;
        this.atk = 30;
        this.def = 10;
        this.gold = 0;
        this.evasion = 10;
    }

    public void heal() {
        if (hp == MAXHP) {
            System.out.println("체력이 이미 가득 차 있습니다. 회복할 수 없습니다.");
            return;
        }

        if (gold < 50) {
            System.out.println("골드가 부족합니다.");
            return;
        }

        int recoverAmount = random.nextInt(11) + 5;
        int beforeHp = hp;
        hp = Math.min(hp + recoverAmount, MAXHP);
        int actualRecovered = hp - beforeHp;
        gold -= 50;

        System.out.println("회복 비용으로 50 GOLD를 지불했습니다!");
        System.out.printf("체력을 %d만큼 회복했습니다! 현재 체력: %d / %d\n", actualRecovered, hp, MAXHP);
    }
}
