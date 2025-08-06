package com.textrpg.monster;

import com.textrpg.character.Player;
import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.RED;

import java.io.Serializable;

public class Skeleton extends Monster implements Serializable {

    public Skeleton() {
        super("해골", 90, 18, 7, 60, 40);
    }

    @Override
    public void attack(Player player) {
        super.attack(player);
        if (Math.random() < 0.2) { // 20% 확률로 추가 공격
            useSkill(player);
        }
    }

    @Override
    public void useSkill(Player player) {
        slowPrint(this.name + "이(가) 뼈를 휘둘러 추가 공격을 합니다!", RED);
        player.takeDamage(this.getAttack() / 2); // 추가 공격은 절반 데미지
    }
}