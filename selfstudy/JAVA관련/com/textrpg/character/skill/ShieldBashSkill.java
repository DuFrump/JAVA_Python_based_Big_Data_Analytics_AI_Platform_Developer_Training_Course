package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.CYAN;
import static com.textrpg.game.GameUtils.RED;

public class ShieldBashSkill implements Skill {
    private static final String NAME = "방패 치기";
    private static final String DESCRIPTION = "적을 50% 확률로 1턴간 기절시킵니다.";
    private static final int REQUIRED_MP = 15;

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
            slowPrint(player.getName() + "의 방패 치기! (MP " + REQUIRED_MP + " 소모)", CYAN);
            monster.takeDamage((int)(player.getAttack() * 0.8)); // 약간의 데미지
            if (Math.random() < 0.5) { // 50% 확률
                monster.setStunned(true, 1);
                slowPrint(monster.getName() + "이(가) 기절했습니다!", CYAN);
            }
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}