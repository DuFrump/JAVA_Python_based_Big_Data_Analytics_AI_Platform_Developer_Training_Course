package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.GREEN;
import static com.textrpg.game.GameUtils.RED;

public class HealSkill implements Skill {
    private static final String NAME = "치유";
    private static final String DESCRIPTION = "자신의 HP를 회복합니다.";
    private static final int REQUIRED_MP = 25;
    private static final int HEAL_AMOUNT = 60;

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
            int newHp = player.getHp() + HEAL_AMOUNT;
            if (newHp > player.getMaxHp()) {
                newHp = player.getMaxHp();
            }
            player.setHp(newHp);
            slowPrint(player.getName() + "이(가) 치유 마법을 사용해 HP를 " + HEAL_AMOUNT + "만큼 회복했습니다. (현재 HP: " + player.getHp() + ")", GREEN);
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}