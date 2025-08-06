package com.textrpg.monster;

import com.textrpg.character.Player;
import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.RED;

import java.io.Serializable;

public class Boss extends Monster implements Serializable {

    public Boss(String name, int maxHp, int attack, int defense, int gold, int experience) {
        super(name, maxHp, attack, defense, gold, experience);
    }

    @Override
    public void attack(Player player) {
        // 일반 공격 외에 일정 확률로 특수 공격을 사용하도록 구현 가능
        if (Math.random() < 0.3) { // 30% 확률로 강력한 공격
            useSkill(player);
        } else {
            super.attack(player);
        }
    }

    @Override
    public void useSkill(Player player) {
        slowPrint(this.name + "의 분노의 일격! 엄청난 힘이 느껴집니다!", RED);
        player.takeDamage(this.attack * 2);
    }
}