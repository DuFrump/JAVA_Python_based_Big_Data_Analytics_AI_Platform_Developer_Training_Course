package com.textrpg.character;

import com.textrpg.character.skill.PowerStrikeSkill;
import com.textrpg.character.skill.ShieldBashSkill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;

public class Swordsman extends Player {
    private static final String JOB_NAME = "검사";
    private static final int BASE_MAX_HP = 180;
    private static final int BASE_MAX_MP = 40;
    private static final int BASE_ATTACK = 18;
    private static final int BASE_DEFENSE = 12;
    private static final String ATTACK_MESSAGE_PREFIX = "이(가) ";
    private static final String ATTACK_MESSAGE_SUFFIX = "을(를) 공격합니다!";

    public Swordsman(String name) {
        super(name);
        this.job = JOB_NAME;
        this.maxHp = BASE_MAX_HP;
        this.hp = this.maxHp;
        this.maxMp = BASE_MAX_MP;
        this.mp = this.maxMp;
        this.attack = BASE_ATTACK;
        this.defense = BASE_DEFENSE;
        this.skills.add(new PowerStrikeSkill());
        this.skills.add(new ShieldBashSkill());
    }

    @Override
    public void attack(Monster monster) {
        slowPrint(this.name + ATTACK_MESSAGE_PREFIX + monster.getName() + ATTACK_MESSAGE_SUFFIX);
        monster.takeDamage(calculateDamage());
    }
}
