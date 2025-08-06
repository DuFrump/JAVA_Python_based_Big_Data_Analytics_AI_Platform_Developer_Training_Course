package com.textrpg.character;

import com.textrpg.character.skill.FireballSkill;
import com.textrpg.character.skill.HealSkill;
import com.textrpg.character.skill.IceSpellSkill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;

public class Mage extends Player {
    private static final String JOB_NAME = "마법사";
    private static final int BASE_MAX_HP = 100;
    private static final int BASE_MAX_MP = 200;
    private static final int BASE_ATTACK = 8;
    private static final int BASE_DEFENSE = 4;
    private static final String ATTACK_MESSAGE_PREFIX = "이(가) 지팡이로 ";
    private static final String ATTACK_MESSAGE_SUFFIX = "을(를) 공격합니다!";

    public Mage(String name) {
        super(name);
        this.job = JOB_NAME;
        this.maxHp = BASE_MAX_HP;
        this.hp = this.maxHp;
        this.maxMp = BASE_MAX_MP;
        this.mp = this.maxMp;
        this.attack = BASE_ATTACK;
        this.defense = BASE_DEFENSE;
        this.skills.add(new FireballSkill());
        this.skills.add(new HealSkill());
        this.skills.add(new IceSpellSkill());
    }

    @Override
    public void attack(Monster monster) {
        slowPrint(this.name + ATTACK_MESSAGE_PREFIX + monster.getName() + ATTACK_MESSAGE_SUFFIX);
        monster.takeDamage(calculateDamage());
    }
}