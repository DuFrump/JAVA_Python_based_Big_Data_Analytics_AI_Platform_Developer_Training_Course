package com.textrpg.monster;

import com.textrpg.character.Player;
import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.GREEN;

import java.io.Serializable;

public class Spider extends Monster implements Serializable {

    public Spider() {
        super("거미", 70, 12, 3, 40, 25);
    }

    @Override
    public void attack(Player player) {
        super.attack(player);
        if (Math.random() < 0.3) { // 30% 확률로 독 공격
            useSkill(player);
        }
    }

    @Override
    public void useSkill(Player player) {
        slowPrint(this.name + "가 독을 뿜어 " + player.getName() + "을(를) 중독시켰습니다!", GREEN);
        player.setPoisoned(true, 3); // 3턴간 독 효과
    }
}