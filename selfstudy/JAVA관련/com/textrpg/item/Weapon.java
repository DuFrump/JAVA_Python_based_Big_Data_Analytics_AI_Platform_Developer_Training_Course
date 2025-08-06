package com.textrpg.item;

import java.io.Serializable;

import static com.textrpg.item.Item.ItemRarity.COMMON;

public class Weapon extends Item implements Serializable {
    public Weapon(String name, int price, int attackBonus) {
        super(name, price, attackBonus, 0, ItemType.WEAPON, COMMON);
    }

    public Weapon(String name, int price, int attackBonus, ItemRarity rarity) {
        super(name, price, attackBonus, 0, ItemType.WEAPON, rarity);
    }
}
