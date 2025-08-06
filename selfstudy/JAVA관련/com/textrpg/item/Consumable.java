package com.textrpg.item;

import com.textrpg.character.Player;
import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.GREEN;
import static com.textrpg.game.GameUtils.BLUE;
import static com.textrpg.game.GameUtils.YELLOW;
import static com.textrpg.game.GameUtils.RED;

public class Consumable extends Item {
    private static final String HEAL_HP_MESSAGE_PREFIX = "이(가) ";
    private static final String HEAL_HP_MESSAGE_MIDDLE = "을(를) 사용하여 HP를 ";
    private static final String HEAL_HP_MESSAGE_SUFFIX = " 회복했습니다. (현재 HP: ";
    private static final String HEAL_MP_MESSAGE_PREFIX = "이(가) ";
    private static final String HEAL_MP_MESSAGE_MIDDLE = "을(를) 사용하여 MP를 ";
    private static final String HEAL_MP_MESSAGE_SUFFIX = " 회복했습니다. (현재 MP: ";
    private static final String CURE_POISON_MESSAGE_PREFIX = "이(가) ";
    private static final String CURE_POISON_MESSAGE_SUFFIX = "을(를) 사용하여 독을 치료했습니다!";
    private static final String NOT_POISONED_MESSAGE = "독에 걸려있지 않습니다.";
    private static final String HP_HEAL_INFO_FORMAT = " | HP %d 회복";
    private static final String MP_HEAL_INFO_FORMAT = " | MP %d 회복";
    private static final String CURE_POISON_INFO = " | 독 치료";

    public enum ConsumableEffect {
        HEAL_HP,
        HEAL_MP,
        CURE_POISON
    }

    private ConsumableEffect effect;
    private int amount;

    public Consumable(String name, int price, ConsumableEffect effect, int amount) {
        super(name, price, 0, 0, ItemType.CONSUMABLE, ItemRarity.COMMON);
        this.effect = effect;
        this.amount = amount;
    }

    @Override
    public void use(Player player) {
        switch (effect) {
            case HEAL_HP:
                int hpHealed = player.getHp() + amount;
                if (hpHealed > player.getMaxHp()) {
                    hpHealed = player.getMaxHp();
                }
                player.setHp(hpHealed);
                slowPrint(player.getName() + HEAL_HP_MESSAGE_PREFIX + name + HEAL_HP_MESSAGE_MIDDLE + amount + HEAL_HP_MESSAGE_SUFFIX + player.getHp() + ")", GREEN);
                break;
            case HEAL_MP:
                int mpHealed = player.getMp() + amount;
                if (mpHealed > player.getMaxMp()) {
                    mpHealed = player.getMaxMp();
                }
                player.setMp(mpHealed);
                slowPrint(player.getName() + HEAL_MP_MESSAGE_PREFIX + name + HEAL_MP_MESSAGE_MIDDLE + amount + HEAL_MP_MESSAGE_SUFFIX + player.getMp() + ")", BLUE);
                break;
            case CURE_POISON:
                if (player.isPoisoned()) {
                    player.setPoisoned(false, 0);
                    slowPrint(player.getName() + CURE_POISON_MESSAGE_PREFIX + name + CURE_POISON_MESSAGE_SUFFIX, GREEN);
                } else {
                    slowPrint(NOT_POISONED_MESSAGE, YELLOW);
                }
                break;
        }
    }

    @Override
    public String getItemInfo() {
        String info = super.getItemInfo();
        switch (effect) {
            case HEAL_HP:
                info += String.format(HP_HEAL_INFO_FORMAT, amount);
                break;
            case HEAL_MP:
                info += String.format(MP_HEAL_INFO_FORMAT, amount);
                break;
            case CURE_POISON:
                info += CURE_POISON_INFO;
                break;
        }
        return info;
    }
}