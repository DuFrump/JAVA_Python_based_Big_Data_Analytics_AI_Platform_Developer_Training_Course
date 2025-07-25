package game01;

import java.util.Random;

public class Monster {
    int hp;
    int atk;
    int def;
    int accuracy;
    boolean isBoss;

    Random random = new Random();

    public Monster(boolean isBoss) {
        this.isBoss = isBoss;

        if (isBoss) {
        this.hp = 200;
        this.atk = 40;
        this.def = 15;
        this.accuracy = 90;
        } else {
            this.hp = random.nextInt(21) + 30;
            this.atk = random.nextInt(6) + 10;
            this.def = random.nextInt(5) + 3;
            this.accuracy = random.nextInt(11) + 12;
        }
    }
}
