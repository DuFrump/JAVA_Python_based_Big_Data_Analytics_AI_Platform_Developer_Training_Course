package com.textrpg.character;

import com.textrpg.item.Armor;
import com.textrpg.item.Item;
import com.textrpg.item.Weapon;
import com.textrpg.monster.Monster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.textrpg.game.GameUtils.*;

public abstract class Player implements Serializable {
    // Constants for messages
    private static final String INVALID_SKILL_NUMBER_MESSAGE = "잘못된 스킬 번호입니다.";
    private static final String SKILL_LIST_HEADER = "------ 스킬 목록 ------";
    private static final String NO_SKILLS_MESSAGE = "배운 스킬이 없습니다.";
    private static final String MP_CONSUMPTION_SUFFIX = " 소모) - ";
    private static final String SKILL_LIST_FOOTER = "-----------------------";
    private static final String STATUS_HEADER_PREFIX = "------ ";
    private static final String STATUS_HEADER_SUFFIX = " ------";
    private static final String LEVEL_PREFIX = "레벨: ";
    private static final String HP_PREFIX = "HP: ";
    private static final String MP_PREFIX = "MP: ";
    private static final String ATTACK_PREFIX = "공격력: ";
    private static final String DEFENSE_PREFIX = "방어력: ";
    private static final String EXPERIENCE_PREFIX = "경험치: ";
    private static final String GOLD_PREFIX = "골드: ";
    private static final String WEAPON_PREFIX = "무기: ";
    private static final String ARMOR_PREFIX = "방어구: ";
    private static final String NONE_EQUIPPED = "(없음)";
    private static final String STATUS_FOOTER = "--------------------------";
    private static final String DAMAGE_TAKEN_MESSAGE_PREFIX = "이(가) ";
    private static final String DAMAGE_TAKEN_MESSAGE_SUFFIX = "의 피해를 입었습니다. (남은 HP: ";
    private static final String EXP_GAINED_MESSAGE_PREFIX = "이(가) ";
    private static final String EXP_GAINED_MESSAGE_SUFFIX = "의 경험치를 획득했습니다.";
    private static final String LEVEL_UP_MESSAGE_PREFIX = "레벨 업! ";
    private static final String LEVEL_UP_MESSAGE_MIDDLE = "의 레벨이 ";
    private static final String LEVEL_UP_MESSAGE_SUFFIX = "이(가) 되었습니다!";
    private static final String INVENTORY_MOVE_MESSAGE_SUFFIX = "을(를) 인벤토리로 옮겼습니다.";
    private static final String EQUIP_MESSAGE_SUFFIX = "을(를) 장착했습니다.";
    private static final String ITEM_ACQUIRED_MESSAGE_SUFFIX = "을(를) 획득했습니다.";
    private static final String INVENTORY_HEADER_PREFIX = "------ ";
    private static final String INVENTORY_HEADER_SUFFIX = "의 인벤토리 ------";
    private static final String INVENTORY_EMPTY_MESSAGE = "인벤토리가 비어있습니다.";
    private static final String INVENTORY_FOOTER = "---------------------------------";
    private static final String INVALID_ITEM_NUMBER_MESSAGE = "잘못된 아이템 번호입니다.";
    private static final String POISONED_MESSAGE_PREFIX = "이(가) 독에 중독되었습니다!";
    private static final String POISON_STATUS_PREFIX = "상태: 독 (";
    private static final String TURNS_LEFT_SUFFIX = "턴 남음)";
    private static final String POISON_DAMAGE_MESSAGE_PREFIX = "은(는) 독으로 인해 ";
    private static final String POISON_EFFECT_END_MESSAGE = "의 독 효과가 사라졌습니다.";
    private static final String BURNED_MESSAGE_PREFIX = "이(가) 화상에 걸렸습니다!";
    private static final String BURN_STATUS_PREFIX = "상태: 화상 (";
    private static final String BURN_DAMAGE_MESSAGE_PREFIX = "은(는) 화상으로 인해 ";
    private static final String BURN_EFFECT_END_MESSAGE = "의 화상 효과가 사라졌습니다.";
    private static final String FROZEN_MESSAGE_PREFIX = "이(가) 빙결되었습니다!";
    private static final String FROZEN_STATUS_PREFIX = "상태: 빙결 (";
    private static final String FROZEN_EFFECT_MESSAGE = "은(는) 빙결되어 움직일 수 없습니다.";
    private static final String FROZEN_EFFECT_END_MESSAGE = "의 빙결 효과가 사라졌습니다.";

    protected String name;
    protected String job;
    protected int hp;
    protected int maxHp;
    protected int mp;
    protected int maxMp;
    protected int attack;
    protected int defense;
    protected int gold;
    protected int level;
    protected int experience;
    protected int maxExperience;
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;
    protected List<Item> inventory;
    protected boolean isPoisoned = false;
    protected int poisonTurns = 0;
    protected boolean isBurned = false;
    protected int burnTurns = 0;
    protected boolean isFrozen = false;
    protected int frozenTurns = 0;
    protected boolean isEvasionBuffActive = false; // Added missing field
    protected int evasionBuffTurns = 0; // Added missing field
    protected double criticalChance = 0.15; // 15% 치명타 확률
    protected double criticalMultiplier = 1.5; // 1.5배 치명타 피해
    protected List<Skill> skills;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.gold = 0;
        this.experience = 0;
        this.maxExperience = 100;
        this.inventory = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public abstract void attack(Monster monster);

    protected int calculateDamage() {
        int baseDamage = getAttack();
        // 피해량 무작위성 (90% ~ 110%)
        double damageVariance = 0.9 + (Math.random() * 0.2); // 0.9 ~ 1.1
        int finalDamage = (int) (baseDamage * damageVariance);

        // 치명타 적용
        if (Math.random() < this.criticalChance) {
            finalDamage = (int) (finalDamage * this.criticalMultiplier);
            slowPrint("치명타 발생!", YELLOW);
        }
        return finalDamage;
    }

    public boolean useSkill(int skillNumber, Monster monster) {
        if (skillNumber > 0 && skillNumber <= skills.size()) {
            Skill skill = skills.get(skillNumber - 1);
            if (this.mp >= skill.getRequiredMp()) {
                skill.use(this, monster);
                return true;
            } else {
                slowPrint("MP가 부족합니다!", RED);
                return false;
            }
        } else {
            slowPrint(INVALID_SKILL_NUMBER_MESSAGE, RED);
            return false;
        }
    }

    public void showSkills() {
        System.out.println(YELLOW + SKILL_LIST_HEADER + RESET);
        if (skills.isEmpty()) {
            System.out.println(NO_SKILLS_MESSAGE);
        } else {
            for (int i = 0; i < skills.size(); i++) {
                Skill skill = skills.get(i);
                System.out.println((i + 1) + ". " + skill.getName() + " (MP " + skill.getRequiredMp() + MP_CONSUMPTION_SUFFIX + skill.getDescription());
            }
        }
        System.out.println(YELLOW + SKILL_LIST_FOOTER + RESET);
    }

    public void showStatus() {
        System.out.println(YELLOW + STATUS_HEADER_PREFIX + name + " (" + job + ")" + STATUS_HEADER_SUFFIX + RESET);
        System.out.println(LEVEL_PREFIX + level);
        System.out.println(HP_PREFIX + RED + hp + "/" + maxHp + RESET);
        System.out.println(MP_PREFIX + BLUE + mp + "/" + maxMp + RESET);
        System.out.println(ATTACK_PREFIX + attack + " (" + attack + " + " + (getAttack() - attack) + ")");
        System.out.println(DEFENSE_PREFIX + defense + " (" + defense + " + " + (getDefense() - defense) + ")");
        System.out.println(EXPERIENCE_PREFIX + experience + "/" + maxExperience);
        System.out.println(GOLD_PREFIX + gold);
        System.out.println(WEAPON_PREFIX + (equippedWeapon != null ? equippedWeapon.getName() : NONE_EQUIPPED));
        System.out.println(ARMOR_PREFIX + (equippedArmor != null ? equippedArmor.getName() : NONE_EQUIPPED));
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

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void takeDamage(int damage) {
        if (isEvasionBuffActive && Math.random() < 0.3) { // 30% 확률로 회피
            slowPrint(this.name + "(이)가 공격을 회피했습니다!", BLUE);
            return;
        }

        int finalDamage = damage - getDefense();
        if (finalDamage < 0) {
            finalDamage = 0;
        }
        this.hp -= finalDamage;
        if (this.hp < 0) {
            this.hp = 0;
        }
        slowPrint(this.name + DAMAGE_TAKEN_MESSAGE_PREFIX + finalDamage + DAMAGE_TAKEN_MESSAGE_SUFFIX + this.hp + ")", RED);
    }

    public void decreaseBuffTurns() {
        if (isEvasionBuffActive) {
            evasionBuffTurns--;
            if (evasionBuffTurns <= 0) {
                isEvasionBuffActive = false;
                slowPrint(this.name + "의 회피 버프가 종료되었습니다.", BLUE);
            }
        }
    }
    
    public void gainExperience(int exp) {
        this.experience += exp;
        slowPrint(this.name + EXP_GAINED_MESSAGE_PREFIX + exp + EXP_GAINED_MESSAGE_SUFFIX, GREEN);
        if (this.experience >= this.maxExperience) {
            levelUp();
        }
    }

    private void levelUp() {
        this.level++;
        this.experience -= this.maxExperience;
        this.maxExperience *= 1.2;
        
        this.maxHp += 20;
        this.maxMp += 10;
        this.attack += 5;
        this.defense += 2;
        
        this.hp = this.maxHp;
        this.mp = this.maxMp;

        slowPrint(LEVEL_UP_MESSAGE_PREFIX + this.name + LEVEL_UP_MESSAGE_MIDDLE + this.level + LEVEL_UP_MESSAGE_SUFFIX, YELLOW);
        showStatus();
    }

    public int getAttack() {
        int totalAttack = this.attack;
        if (equippedWeapon != null) {
            totalAttack += equippedWeapon.getAttackBonus();
        }
        return totalAttack;
    }

    public int getDefense() {
        int totalDefense = this.defense;
        if (equippedArmor != null) {
            totalDefense += equippedArmor.getDefenseBonus();
        }
        return totalDefense;
    }

    public void equipWeapon(Weapon weapon) {
        if (this.equippedWeapon != null) {
            this.inventory.add(this.equippedWeapon);
            slowPrint(this.equippedWeapon.getName() + INVENTORY_MOVE_MESSAGE_SUFFIX);
        }
        this.equippedWeapon = weapon;
        this.inventory.remove(weapon);
        slowPrint(weapon.getName() + EQUIP_MESSAGE_SUFFIX, CYAN);
    }

    public void equipArmor(Armor armor) {
        if (this.equippedArmor != null) {
            this.inventory.add(this.equippedArmor);
            slowPrint(this.equippedArmor.getName() + INVENTORY_MOVE_MESSAGE_SUFFIX);
        }
        this.equippedArmor = armor;
        this.inventory.remove(armor);
        slowPrint(armor.getName() + EQUIP_MESSAGE_SUFFIX, CYAN);
    }

    public void addItem(Item item) {
        this.inventory.add(item);
        slowPrint(item.getName() + ITEM_ACQUIRED_MESSAGE_SUFFIX, GREEN);
    }

    public void removeItem(Item item) {
        this.inventory.remove(item);
    }

    public void showInventory() {
        System.out.println(YELLOW + INVENTORY_HEADER_PREFIX + name + INVENTORY_HEADER_SUFFIX + RESET);
        if (inventory.isEmpty()) {
            System.out.println(INVENTORY_EMPTY_MESSAGE);
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                System.out.println((i + 1) + ". " + inventory.get(i).getItemInfo());
            }
        }
        System.out.println(YELLOW + INVENTORY_FOOTER + RESET);
    }

    public void useItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            if (item.getType() == Item.ItemType.WEAPON) {
                equipWeapon((Weapon) item);
            } else if (item.getType() == Item.ItemType.ARMOR) {
                equipArmor((Armor) item);
            } else {
                item.use(this);
                if (item.getType() == Item.ItemType.CONSUMABLE) {
                    removeItem(item);
                }
            }
        } else {
            slowPrint(INVALID_ITEM_NUMBER_MESSAGE, RED);
        }
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned, int turns) {
        isPoisoned = poisoned;
        poisonTurns = turns;
        if (poisoned) {
            slowPrint(this.name + POISONED_MESSAGE_PREFIX, GREEN);
        }
    }

    public void applyPoisonEffect() {
        if (isPoisoned) {
            int poisonDamage = (int) (this.maxHp * 0.03);
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
            slowPrint(this.name + BURNED_MESSAGE_PREFIX, RED);
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
            slowPrint(this.name + FROZEN_MESSAGE_PREFIX, CYAN);
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMp() {
        return maxMp;
    }
    
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isEvasionBuffActive() {
        return isEvasionBuffActive;
    }

    public void setEvasionBuffActive(boolean evasionBuffActive) {
        isEvasionBuffActive = evasionBuffActive;
    }

    public int getEvasionBuffTurns() {
        return evasionBuffTurns;
    }

    public void setEvasionBuffTurns(int evasionBuffTurns) {
        this.evasionBuffTurns = evasionBuffTurns;
    }
}