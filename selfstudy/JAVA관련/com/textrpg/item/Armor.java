package com.textrpg.item;

import java.io.Serializable;

import static com.textrpg.item.Item.ItemRarity.COMMON;

public class Armor extends Item implements Serializable {
    public Armor(String name, int price, int defenseBonus) {
        super(name, price, 0, defenseBonus, ItemType.ARMOR, COMMON);
    }

    public Armor(String name, int price, int defenseBonus, ItemRarity rarity) {
        super(name, price, 0, defenseBonus, ItemType.ARMOR, rarity);
    }
}
