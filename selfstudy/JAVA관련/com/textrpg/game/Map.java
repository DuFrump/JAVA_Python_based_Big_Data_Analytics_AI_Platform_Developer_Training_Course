package com.textrpg.game;

import java.io.Serializable;
import java.util.Random;

import static com.textrpg.game.GameUtils.slowPrint;
import static com.textrpg.game.GameUtils.YELLOW;

public class Map implements Serializable {
    private static final String UNKNOWN_DIRECTION_MESSAGE = "알 수 없는 방향입니다.";
    private static final String MOVED_TO_MESSAGE_SUFFIX = "(으)로 이동했습니다.";
    private static final String NO_MORE_MOVE_MESSAGE = "더 이상 이동할 수 없는 지역입니다.";
    private static final String AVAILABLE_DIRECTIONS_PREFIX = "이동 가능한 방향: ";

    private static final String[][] MAP_DATA = {
        {"숲 입구", "어두운 숲", "늑대 굴"},
        {"강가", "평원", "고블린 캠프"},
        {"산기슭", "동굴 입구", "드래곤의 둥지"}
    };

    private int currentRow;
    private int currentCol;
    private Random random;

    public Map() {
        this.currentRow = 0;
        this.currentCol = 0;
        this.random = new Random();
    }

    public String getCurrentLocationName() {
        return MAP_DATA[currentRow][currentCol];
    }

    public void move(String direction) {
        int newRow = currentRow;
        int newCol = currentCol;

        switch (direction.toLowerCase()) {
            case "북":
                newRow--;
                break;
            case "남":
                newRow++;
                break;
            case "동":
                newCol++;
                break;
            case "서":
                newCol--;
                break;
            default:
                slowPrint(UNKNOWN_DIRECTION_MESSAGE, YELLOW);
                return;
        }

        if (newRow >= 0 && newRow < MAP_DATA.length && newCol >= 0 && newCol < MAP_DATA[0].length) {
            currentRow = newRow;
            currentCol = newCol;
            slowPrint(getCurrentLocationName() + MOVED_TO_MESSAGE_SUFFIX, YELLOW);
        } else {
            slowPrint(NO_MORE_MOVE_MESSAGE, YELLOW);
        }
    }

    public String getAvailableDirections() {
        StringBuilder sb = new StringBuilder(AVAILABLE_DIRECTIONS_PREFIX);
        if (currentRow > 0) sb.append("북 ");
        if (currentRow < MAP_DATA.length - 1) sb.append("남 ");
        if (currentCol < MAP_DATA[0].length - 1) sb.append("동 ");
        if (currentCol > 0) sb.append("서 ");
        return sb.toString().trim();
    }

    public boolean shouldEncounterMonster() {
        String currentLocation = getCurrentLocationName();
        switch (currentLocation) {
            case "숲 입구": return random.nextDouble() < 0.5;
            case "어두운 숲": return random.nextDouble() < 0.7;
            case "늑대 굴": return random.nextDouble() < 0.8;
            case "드래곤의 둥지": return random.nextDouble() < 0.9;
            default: return random.nextDouble() < 0.6;
        }
    }

    public String getCurrentLocationType() {
        String currentLocation = getCurrentLocationName();
        if (currentLocation.contains("숲")) return "forest";
        if (currentLocation.contains("강가") || currentLocation.contains("평원")) return "field";
        if (currentLocation.contains("산") || currentLocation.contains("동굴")) return "mountain";
        if (currentLocation.contains("캠프") || currentLocation.contains("굴") || currentLocation.contains("둥지")) return "lair";
        return "default";
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
}