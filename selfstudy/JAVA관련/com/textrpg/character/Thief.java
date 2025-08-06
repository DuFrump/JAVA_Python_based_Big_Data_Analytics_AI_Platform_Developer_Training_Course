package com.textrpg.character;

import com.textrpg.character.skill.DoubleAttackSkill;
import com.textrpg.character.skill.EvasionBuffSkill;
import com.textrpg.monster.Monster;

import static com.textrpg.game.GameUtils.slowPrint;

public class Thief extends Player {
    private static final String JOB_NAME = "도적";
    private static final int BASE_MAX_HP = 130;
    private static final int BASE_MAX_MP = 60;
    private static final int BASE_ATTACK = 13;
    private static final int BASE_DEFENSE = 8;
    private static final String ATTACK_MESSAGE_PREFIX = "이(가) 단검으로 ";
    private static final String ATTACK_MESSAGE_SUFFIX = "을(를) 빠르게 찌릅니다!";
    private static final String EVASION_MESSAGE = "이(가) 공격을 회피했습니다!";
    private static final String EVASION_BUFF_END_MESSAGE = "의 회피율 증가 효과가 사라졌습니다.";

    public Thief(String name) {
        super(name);
        this.job = JOB_NAME;
        this.maxHp = BASE_MAX_HP;
        this.hp = this.maxHp;
        this.maxMp = BASE_MAX_MP;
        this.mp = this.maxMp;
        this.attack = BASE_ATTACK;
        this.defense = BASE_DEFENSE;
        this.skills.add(new DoubleAttackSkill());
        this.skills.add(new EvasionBuffSkill());
    }

    @Override
    public void attack(Monster monster) {
        slowPrint(this.name + ATTACK_MESSAGE_PREFIX + monster.getName() + ATTACK_MESSAGE_SUFFIX);
        monster.takeDamage(calculateDamage());
    }

    @Override
    public void takeDamage(int damage) {
        if (isEvasionBuffActive() && Math.random() < 0.6) {
            slowPrint(this.name + EVASION_MESSAGE);
        } else {
            super.takeDamage(damage);
        }
    }
    
    public void decreaseBuffTurns() {
        if (isEvasionBuffActive()) {
            setEvasionBuffTurns(getEvasionBuffTurns() - 1);
            if (getEvasionBuffTurns() <= 0) {
                setEvasionBuffActive(false);
                slowPrint(this.name + EVASION_BUFF_END_MESSAGE);
            }
        }
    }
}
