package com.textrpg.monster;

import com.textrpg.character.Player;

import java.io.Serializable;

import static com.textrpg.game.GameUtils.*;

public class Monster implements Serializable {
    // Constants for messages
    private static final String ATTACK_MESSAGE_PREFIX = "이(가) ";
    private static final String ATTACK_MESSAGE_SUFFIX = "을(를) 공격합니다!";
    private static final String DAMAGE_TAKEN_MESSAGE_PREFIX = "이(가) ";
    private static final String DAMAGE_TAKEN_MESSAGE_SUFFIX = "의 피해를 입었습니다. (남은 HP: ";
    private static final String POISONED_MESSAGE = "이(가) 독에 중독되었습니다!";
    private static final String POISON_DAMAGE_MESSAGE_PREFIX = "은(는) 독으로 인해 ";
    private static final String POISON_EFFECT_END_MESSAGE = "의 독 효과가 사라졌습니다.";
    private static final String BURNED_MESSAGE = "이(가) 화상에 걸렸습니다!";
    private static final String BURN_DAMAGE_MESSAGE_PREFIX = "은(는) 화상으로 인해 ";
    private static final String BURN_EFFECT_END_MESSAGE = "의 화상 효과가 사라졌습니다.";
    private static final String FROZEN_MESSAGE = "이(가) 빙결되었습니다!";
    private static final String FROZEN_EFFECT_MESSAGE = "은(는) 빙결되어 움직일 수 없습니다.";
    private static final String FROZEN_EFFECT_END_MESSAGE = "의 빙결 효과가 사라졌습니다.";
    private static final String STATUS_HEADER_PREFIX = "------ ";
    private static final String STATUS_HEADER_SUFFIX = " ------";
    private static final String HP_PREFIX = "HP: ";
    private static final String STUNNED_STATUS = "상태: 기절";
    private static final String POISON_STATUS_PREFIX = "상태: 독 (";
    private static final String TURNS_LEFT_SUFFIX = "턴 남음)";
    private static final String BURN_STATUS_PREFIX = "상태: 화상 (";
    private static final String FROZEN_STATUS_PREFIX = "상태: 빙결 (";
    private static final String STATUS_FOOTER = "---------------------";

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected int gold;
    protected int experience;
    private boolean isStunned = false;
    private int stunTurns = 0;
    private boolean isPoisoned = false;
    private int poisonTurns = 0;
    private boolean isBurned = false;
    private int burnTurns = 0;
    private boolean isFrozen = false;
    private int frozenTurns = 0;
    protected double criticalChance = 0.10; // 10% 치명타 확률 (플레이어보다 낮게)
    protected double criticalMultiplier = 1.5; // 1.5배 치명타 피해

    public Monster(String name, int maxHp, int attack, int defense, int gold, int experience) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = this.maxHp;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
        this.experience = experience;
    }

    public void attack(Player player) {
        slowPrint(this.name + ATTACK_MESSAGE_PREFIX + player.getName() + ATTACK_MESSAGE_SUFFIX, RED);
        int calculatedDamage = calculateDamage();
        player.takeDamage(calculatedDamage);
    }

    protected int calculateDamage() {
        int baseDamage = getAttack();
        // 피해량 무작위성 (90% ~ 110%)
        double damageVariance = 0.9 + (Math.random() * 0.2); // 0.9 ~ 1.1
        int finalDamage = (int) (baseDamage * damageVariance);

        // 치명타 적용
        if (Math.random() < this.criticalChance) {
            finalDamage = (int) (finalDamage * this.criticalMultiplier);
            slowPrint(this.name + "의 치명타!", RED);
        }
        return finalDamage;
    }

    public void useSkill(Player player) {
        // Default monster has no skill. Override in subclasses
    }

    public void takeDamage(int damage) {
        int finalDamage = damage - this.defense;
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
        if (this.hp < 0) {
            this.hp = 0;
        }
        slowPrint(this.name + DAMAGE_TAKEN_MESSAGE_PREFIX + finalDamage + DAMAGE_TAKEN_MESSAGE_SUFFIX + this.hp + ")", RED);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned, int turns) {
        isStunned = stunned;
        stunTurns = turns;
        if (stunned) {
            slowPrint(this.name + "(이)가 기절했습니다!", CYAN);
        }
    }

    public void applyStunEffect() {
        if (isStunned) {
            slowPrint(this.name + FROZEN_EFFECT_MESSAGE, CYAN); // 기절 메시지 재활용
            stunTurns--;
            if (stunTurns <= 0) {
                isStunned = false;
                slowPrint(this.name + "의 기절 효과가 사라졌습니다.", GREEN);
            }
        }
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned, int turns) {
        isPoisoned = poisoned;
        poisonTurns = turns;
        if (poisoned) {
            slowPrint(this.name + POISONED_MESSAGE, GREEN);
        }
    }

    public void applyPoisonEffect() {
        if (isPoisoned) {
            int poisonDamage = (int) (this.maxHp * 0.05);
            this.hp -= poisonDamage;
            if (this.hp < 0) this.hp = 0;
            slowPrint(this.name + POISON_DAMAGE_MESSAGE_PREFIX + poisonDamage + DAMAGE_TAKEN_MESSAGE_SUFFIX + this.hp + ")", RED);
            poisonTurns--;
            if (poisonTurns <= 0) {
                isPoisoned = false;
                slowPrint(this.name + POISON_EFFECT_END_MESSAGE, GREEN);
            }
        }
    }

    public boolean isBurned() {
        return isBurned;
    }

    public void setBurned(boolean burned, int turns) {
        isBurned = burned;
        burnTurns = turns;
        if (burned) {
            slowPrint(this.name + BURNED_MESSAGE, RED);
        }
    }

    public void applyBurnEffect() {
        if (isBurned) {
            int burnDamage = (int) (this.maxHp * 0.02);
            this.hp -= burnDamage;
            if (this.hp < 0) this.hp = 0;
            slowPrint(this.name + BURN_DAMAGE_MESSAGE_PREFIX + burnDamage + DAMAGE_TAKEN_MESSAGE_SUFFIX + this.hp + ")", RED);
            burnTurns--;
            if (burnTurns <= 0) {
                isBurned = false;
                slowPrint(this.name + BURN_EFFECT_END_MESSAGE, GREEN);
            }
        }
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen, int turns) {
        isFrozen = frozen;
        frozenTurns = turns;
        if (frozen) {
            slowPrint(this.name + FROZEN_MESSAGE, CYAN);
        }
    }

    public void applyFrozenEffect() {
        if (isFrozen) {
            slowPrint(this.name + FROZEN_EFFECT_MESSAGE, CYAN);
            frozenTurns--;
            if (frozenTurns <= 0) {
                isFrozen = false;
                slowPrint(this.name + FROZEN_EFFECT_END_MESSAGE, GREEN);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void showStatus() {
        System.out.println(YELLOW + STATUS_HEADER_PREFIX + name + STATUS_HEADER_SUFFIX + RESET);
        System.out.println(HP_PREFIX + RED + hp + "/" + maxHp + RESET);
        if (isStunned) {
            System.out.println(CYAN + STUNNED_STATUS + " (" + stunTurns + TURNS_LEFT_SUFFIX + RESET);
        }
        if (isPoisoned) {
            System.out.println(GREEN + POISON_STATUS_PREFIX + poisonTurns + TURNS_LEFT_SUFFIX + RESET);
        }
        if (isBurned) {
            System.out.println(RED + BURN_STATUS_PREFIX + burnTurns + TURNS_LEFT_SUFFIX + RESET);
        }
        if (isFrozen) {
            System.out.println(CYAN + FROZEN_STATUS_PREFIX + frozenTurns + TURNS_LEFT_SUFFIX + RESET);
        }
        System.out.println(YELLOW + STATUS_FOOTER + RESET);
    }
}
