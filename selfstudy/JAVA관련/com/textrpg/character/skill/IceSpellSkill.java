package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.CYAN;
import static com.textrpg.game.GameUtils.RED;

public class IceSpellSkill implements Skill {
    private static final String NAME = "빙결 마법";
    private static final String DESCRIPTION = "적에게 냉기 피해를 입히고 20% 확률로 빙결 상태로 만듭니다.";
    private static final int REQUIRED_MP = 30;
    private static final int DAMAGE = 30;

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
        if (player.getMp() >= REQUIRED_MP) {
            player.setMp(player.getMp() - REQUIRED_MP);
            slowPrint(player.getName() + "의 빙결 마법! (MP " + REQUIRED_MP + " 소모)", CYAN);
            monster.takeDamage(DAMAGE);
            if (Math.random() < 0.2) { // 20% 확률로 빙결
                monster.setFrozen(true, 2);
            }
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}