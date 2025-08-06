package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.RED;

public class FireballSkill implements Skill {
    private static final String NAME = "파이어볼";
    private static final String DESCRIPTION = "강력한 화염 마법으로 큰 피해를 주고 30% 확률로 화상 상태로 만듭니다.";
    private static final int REQUIRED_MP = 20;
    private static final int DAMAGE = 50;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public int getRequiredMp() {
        return REQUIRED_MP;
    }

    @Override
    public void use(Player player, Monster monster) {
        player.setMp(player.getMp() - REQUIRED_MP);
        slowPrint(player.getName() + "의 파이어볼! (MP " + REQUIRED_MP + " 소모)", RED);
        monster.takeDamage(DAMAGE);
        if (Math.random() < 0.3) { // 30% 확률로 화상
            monster.setBurned(true, 3);
        }
    }
}