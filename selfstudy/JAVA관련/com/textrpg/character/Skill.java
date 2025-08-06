package com.textrpg.character;

import com.textrpg.monster.Monster;

import java.io.Serializable;

public interface Skill extends Serializable {
    String getName();
    String getDescription();
    int getRequiredMp();
    void use(Player player, Monster monster);
}