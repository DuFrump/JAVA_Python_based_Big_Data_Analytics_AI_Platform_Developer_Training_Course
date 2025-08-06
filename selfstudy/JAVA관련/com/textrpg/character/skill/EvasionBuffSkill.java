package com.textrpg.character.skill;

import com.textrpg.character.Player;
import com.textrpg.character.Skill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.CYAN;
import static com.textrpg.game.GameUtils.RED;

public class EvasionBuffSkill implements Skill {
    private static final String NAME = "회피율 증가";
    private static final String DESCRIPTION = "3턴간 회피율을 크게 높입니다.";
    private static final int REQUIRED_MP = 20;

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
            player.setEvasionBuffActive(true);
            player.setEvasionBuffTurns(3);
            slowPrint(player.getName() + "이(가) 몸을 숨겨 회피율을 높입니다! (MP " + REQUIRED_MP + " 소모)", CYAN);
        } else {
            slowPrint("MP가 부족하여 스킬을 사용할 수 없습니다.", RED);
        }
    }
}