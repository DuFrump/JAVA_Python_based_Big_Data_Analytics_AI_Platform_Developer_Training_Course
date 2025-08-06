package com.textrpg.item;

import com.textrpg.character.Player;
import java.io.Serializable;
import static com.textrpg.game.GameUtils.*;

public class Item implements Serializable {
    private static final String ITEM_INFO_FORMAT = "%s%s%s (가격: %dG)";
    private static final String ATTACK_BONUS_FORMAT = " | " + RED + "공격력+%d" + RESET;
    private static final String DEFENSE_BONUS_FORMAT = " | " + BLUE + "방어력+%d" + RESET;

    public enum ItemType {
        WEAPON, ARMOR, CONSUMABLE, ETC
    }

    public enum ItemRarity {
        COMMON(WHITE), UNCOMMON(GREEN), RARE(BLUE), EPIC(PURPLE), LEGENDARY(YELLOW);

        private final String color;

        ItemRarity(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    protected String name;
    protected int price;
    protected int attackBonus;
    protected int defenseBonus;
    protected ItemType type;
    protected ItemRarity rarity;

    public Item(String name, int price, int attackBonus, int defenseBonus, ItemType type, ItemRarity rarity) {
        this.name = name;
        this.price = price;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.type = type;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public ItemType getType() {
        return type;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public String getItemInfo() {
        String info = String.format(ITEM_INFO_FORMAT, rarity.getColor(), name, RESET, price);
        if (attackBonus > 0) {
            info += String.format(ATTACK_BONUS_FORMAT, attackBonus);
        }
        if (defenseBonus > 0) {
            info += String.format(DEFENSE_BONUS_FORMAT, defenseBonus);
        }
        return info;
    }

    public void use(Player player) {
        // No default action. Override in subclasses for consumable items.
    }
}
