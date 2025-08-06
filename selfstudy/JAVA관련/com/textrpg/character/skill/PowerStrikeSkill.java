package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.RED;

public class PowerStrikeSkill implements Skill {
    private static final String NAME = "파워 스트라이크";
    private static final String DESCRIPTION = "공격력의 200%로 공격합니다.";
    private static final int REQUIRED_MP = 10;

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
            int damage = (int) (player.getAttack() * 2.0);
            slowPrint(player.getName() + "의 파워 스트라이크! (MP " + REQUIRED_MP + " 소모)", RED);
            monster.takeDamage(damage);
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}