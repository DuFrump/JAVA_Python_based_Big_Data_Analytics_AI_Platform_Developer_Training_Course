package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.RED;

public class DoubleAttackSkill implements Skill {
    private static final String NAME = "이중 공격";
    private static final String DESCRIPTION = "빠르게 두 번 공격합니다.";
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
            slowPrint(player.getName() + "의 이중 공격! (MP " + REQUIRED_MP + " 소모)", RED);
            monster.takeDamage(player.getAttack());
            slowPrint("(두 번째 공격)", RED);
            monster.takeDamage(player.getAttack());
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}