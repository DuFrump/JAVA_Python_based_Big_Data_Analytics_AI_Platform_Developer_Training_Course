package com.textrpg.game;

import com.textrpg.character.*;
import com.textrpg.item.Armor;
import com.textrpg.item.Consumable;
import com.textrpg.item.Item;
import com.textrpg.item.Weapon;
import com.textrpg.monster.Boss;
import com.textrpg.monster.Monster;
import com.textrpg.monster.Spider;
import com.textrpg.monster.Skeleton;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

import static com.textrpg.game.GameUtils.*;
import static com.textrpg.item.Item.ItemRarity.*;
import static com.textrpg.item.Consumable.ConsumableEffect.*;

public class Game {
    private static final String GAME_TITLE = "#########################\n# 텍스트 RPG에 오신 것을 환영합니다! #\n#########################";
    private static final String NEW_GAME_OPTION = "1. 새 게임 시작";
    private static final String LOAD_GAME_OPTION = "2. 게임 불러오기";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String GAME_OVER_MESSAGE = "당신은 패배했습니다... GAME OVER";
    private static final String SAVE_SUCCESS_MESSAGE = "게임이 저장되었습니다!";
    private static final String SAVE_FAIL_MESSAGE = "게임 저장에 실패했습니다: ";
    private static final String LOAD_SUCCESS_MESSAGE = "게임을 불러왔습니다!";
    private static final String NO_SAVE_FILE_MESSAGE = "저장된 게임이 없습니다. 새 게임을 시작합니다.";
    private static final String LOAD_FAIL_MESSAGE = "게임 불러오기에 실패했습니다: ";
    private static final String EXPLORE_PROMPT = "어디로 이동하시겠습니까? (북/남/동/서)";
    private static final String NO_ENCOUNTER_MESSAGE = "아무 일도 일어나지 않았습니다.";
    private static final String ENTER_DUNGEON_MESSAGE = "적을 찾아 던전에 들어갑니다...";
    private static final String BOSS_APPEAR_MESSAGE = "강력한 기운이 느껴집니다... 보스가 나타났습니다!";
    private static final String MONSTER_APPEAR_MESSAGE = "이(가) 나타났다!";
    private static final String PLAYER_TURN_MESSAGE = "--- 플레이어의 턴 ---";
    private static final String MONSTER_TURN_MESSAGE = "--- 몬스터의 턴 ---";
    private static final String ACTION_PROMPT = "행동을 선택하세요:";
    private static final String ATTACK_OPTION = "1. 일반 공격";
    private static final String SKILL_OPTION = "2. 스킬 사용";
    private static final String DEFEND_OPTION = "3. 방어";
    private static final String RUN_OPTION = "4. 도망";
    private static final String INVALID_SKILL_NUMBER = "잘못된 스킬 번호입니다.";
    private static final String DEFEND_MESSAGE = "이(가) 방어 태세를 갖춥니다.";
    private static final String BOSS_RUN_FAIL_MESSAGE = "보스에게서는 도망칠 수 없습니다!";
    private static final String RUN_SUCCESS_MESSAGE = "무사히 도망쳤습니다!";
    private static final String RUN_FAIL_MESSAGE = "도망에 실패했습니다...";
    private static final String MONSTER_DEFEATED_MESSAGE = "을(를) 물리쳤습니다!";
    private static final String GOLD_ACQUIRED_MESSAGE = " 골드를 획득했습니다.";
    private static final String GAME_WIN_MESSAGE = "축하합니다! 최종 보스를 물리치고 게임에서 승리했습니다!";
    private static final String STUNNED_MESSAGE = "이(가) 기절해서 움직일 수 없습니다.";
    private static final String FROZEN_MESSAGE = "이(가) 빙결되어 움직일 수 없습니다.";
    private static final String HEAL_COST_MESSAGE = "체력과 마나를 모두 회복하려면 ";
    private static final String GOLD_REQUIRED_MESSAGE = " 골드가 필요합니다.";
    private static final String CURRENT_GOLD_MESSAGE = "현재 골드: ";
    private static final String HEAL_CONFIRM_PROMPT = "회복하시겠습니까? (y/n): ";
    private static final String HEAL_SUCCESS_MESSAGE = "체력과 마나가 모두 회복되었습니다.";
    private static final String HEAL_CANCEL_MESSAGE = "회복을 취소했습니다.";
    private static final String NOT_ENOUGH_GOLD_MESSAGE = "골드가 부족합니다.";
    private static final String SHOP_WELCOME_MESSAGE = "어서오세요! 무엇을 도와드릴까요? (현재 골드: ";
    private static final String WEAPON_SHOP_OPTION = "1. 무기 상점";
    private static final String ARMOR_SHOP_OPTION = "2. 방어구 상점";
    private static final String CONSUMABLE_SHOP_OPTION = "3. 소모품 상점";
    private static final String SHOP_EXIT_OPTION = "4. 나가기";
    private static final String SHOP_GOODBYE_MESSAGE = "다음에 또 들러주세요.";
    private static final String BUY_PROMPT = "구매할 아이템 번호를 입력하세요: ";
    private static final String NOT_ENOUGH_GOLD_SHOP_MESSAGE = "골드가 부족합니다.";
    private static final String INVALID_ITEM_NUMBER = "잘못된 번호입니다.";
    private static final String ENTER_NUMBER_PROMPT = "숫자를 입력해주세요.";
    private static final String INVENTORY_USE_OPTION = "1. 아이템 사용";
    private static final String INVENTORY_EXIT_OPTION = "2. 뒤로가기";
    private static final String USE_ITEM_PROMPT = "사용할 아이템 번호를 입력하세요: ";
    private static final String INVALID_ITEM_INDEX = "잘못된 아이템 번호입니다.";

    private static final int BOSS_BATTLE_THRESHOLD = 30;
    private static final double BOSS_APPEAR_CHANCE = 0.05;
    private static final double ITEM_DROP_CHANCE = 0.3;
    private static final double RUN_CHANCE = 0.5;
    private static final double MONSTER_SKILL_CHANCE = 0.3;
    private static final int HEAL_COST = 50;

    private Player player;
    private Scanner scanner;
    private int battleCount = 0;
    private List<Weapon> weaponShop;
    private List<Armor> armorShop;
    private List<Consumable> consumableShop;
    private com.textrpg.game.Map gameMap;
    private List<Monster> forestMonsters;
    private List<Monster> fieldMonsters;
    private List<Monster> mountainMonsters;
    private List<Monster> lairMonsters;
    private final String SAVE_FILE = "textrpg_save.ser";
    private java.util.Map<String, Integer> defeatedMonstersCount;

    public Game() {
        this.scanner = new Scanner(System.in);
        initializeShop();
        initializeMonsters();
        this.gameMap = new Map();
        this.defeatedMonstersCount = new java.util.HashMap<>();
    }

    private void initializeShop() {
        weaponShop = new ArrayList<>();
        weaponShop.add(new Weapon("낡은 검", 50, 5, COMMON));
        weaponShop.add(new Weapon("강철 검", 200, 15, UNCOMMON));
        weaponShop.add(new Weapon("마법 지팡이", 180, 12, UNCOMMON));
        weaponShop.add(new Weapon("암살자의 단검", 250, 20, RARE));
        weaponShop.add(new Weapon("영웅의 검", 1000, 50, EPIC));

        armorShop = new ArrayList<>();
        armorShop.add(new Armor("가죽 갑옷", 40, 5, COMMON));
        armorShop.add(new Armor("사슬 갑옷", 180, 15, UNCOMMON));
        armorShop.add(new Armor("마법사의 로브", 150, 10, UNCOMMON));
        armorShop.add(new Armor("그림자 로브", 220, 18, RARE));
        armorShop.add(new Armor("수호자의 갑옷", 900, 45, EPIC));

        consumableShop = new ArrayList<>();
        consumableShop.add(new Consumable("작은 체력 물약", 30, HEAL_HP, 50));
        consumableShop.add(new Consumable("작은 마나 물약", 30, HEAL_MP, 30));
        consumableShop.add(new Consumable("해독제", 50, CURE_POISON, 0));
    }

    private void initializeMonsters() {
        forestMonsters = new ArrayList<>();
        forestMonsters.add(new Monster("고블린", 80, 15, 5, 50, 30));
        forestMonsters.add(new Spider());
        forestMonsters.add(new Monster("슬라임", 60, 10, 2, 30, 20));

        fieldMonsters = new ArrayList<>();
        fieldMonsters.add(new Monster("오크", 120, 20, 8, 80, 50));
        fieldMonsters.add(new Skeleton());

        mountainMonsters = new ArrayList<>();
        mountainMonsters.add(new Monster("산적", 150, 25, 10, 100, 70));
        mountainMonsters.add(new Monster("트롤", 200, 30, 12, 150, 100));

        lairMonsters = new ArrayList<>();
        lairMonsters.add(new Monster("어둠의 기사", 250, 35, 15, 200, 120));
        lairMonsters.add(new Monster("고대 골렘", 300, 40, 20, 250, 150));
    }

    public void start() {
        System.out.println(GAME_TITLE);
        System.out.println(NEW_GAME_OPTION);
        System.out.println(LOAD_GAME_OPTION);
        System.out.print("선택: ");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                createPlayer();
                break;
            case "2":
                loadGame();
                break;
            default:
                slowPrint(INVALID_INPUT_MESSAGE + ". " + NEW_GAME_OPTION.substring(3) + "을(를) 시작합니다.", RED);
                createPlayer();
                break;
        }
        mainLoop();
    }

    private void saveGame() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(player);
            oos.writeInt(battleCount);
            oos.writeObject(gameMap);
            slowPrint(SAVE_SUCCESS_MESSAGE, GREEN);
        } catch (IOException e) {
            slowPrint(SAVE_FAIL_MESSAGE + e.getMessage(), RED);
        }
    }

    private void loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            player = (Player) ois.readObject();
            battleCount = ois.readInt();
            gameMap = (Map) ois.readObject();
            slowPrint(LOAD_SUCCESS_MESSAGE, GREEN);
            player.showStatus();
        } catch (FileNotFoundException e) {
            slowPrint(NO_SAVE_FILE_MESSAGE, YELLOW);
            createPlayer();
        } catch (IOException | ClassNotFoundException e) {
            slowPrint(LOAD_FAIL_MESSAGE + e.getMessage(), RED);
            createPlayer();
        }
    }

    private void mainLoop() {
        while (true) {
            System.out.println(YELLOW + " 무엇을 하시겠습니까?" + RESET);
            System.out.println("현재 위치: " + gameMap.getCurrentLocationName());
            System.out.println(gameMap.getAvailableDirections());
            System.out.println("1. 탐험 (전투)");
            System.out.println("2. 회복");
            System.out.println("3. 상점");
            System.out.println("4. 인벤토리");
            System.out.println("5. 내 정보 확인");
            System.out.println("6. 게임 저장");
            System.out.println("7. 게임 종료");
            System.out.print("선택: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    explore(); // 탐험 메뉴로 변경
                    break;
                case "2":
                    heal();
                    break;
                case "3":
                    showShop();
                    break;
                case "4":
                    showInventoryMenu();
                    break;
                case "5":
                    player.showStatus();
                    break;
                case "6":
                    saveGame();
                    break;
                case "7":
                    slowPrint(GAME_OVER_MESSAGE, RED);
                    return;
                default:
                    slowPrint(INVALID_INPUT_MESSAGE, RED);
                    break;
            }
            
            if (!player.isAlive()) {
                slowPrint(GAME_OVER_MESSAGE, RED);
                break;
            }
        }
    }

    private void explore() {
        slowPrint(EXPLORE_PROMPT, YELLOW);
        System.out.print("방향 입력: ");
        String direction = scanner.nextLine();
        gameMap.move(direction);

        if (gameMap.shouldEncounterMonster()) {
            startBattle();
        } else {
            slowPrint(NO_ENCOUNTER_MESSAGE, GREEN);
        }
    }


    private void startBattle() {
        slowPrint(ENTER_DUNGEON_MESSAGE, YELLOW);
        Monster monster;
        // 전투 30회 이상, 5% 확률로 보스 출현
        if (battleCount >= BOSS_BATTLE_THRESHOLD && Math.random() < BOSS_APPEAR_CHANCE) {
            slowPrint(BOSS_APPEAR_MESSAGE, RED);
            monster = new Boss("마왕", 800, 50, 25, 2000, 1000);
        } else {
            // 맵 위치에 따라 몬스터 생성
            String locationType = gameMap.getCurrentLocationType();
            List<Monster> monstersInArea;
            switch (locationType) {
                case "forest":
                    monstersInArea = forestMonsters;
                    break;
                case "field":
                    monstersInArea = fieldMonsters;
                    break;
                case "mountain":
                    monstersInArea = mountainMonsters;
                    break;
                case "lair":
                    monstersInArea = lairMonsters;
                    break;
                default:
                    monstersInArea = forestMonsters; // 기본값
                    break;
            }
            monster = monstersInArea.get((int) (Math.random() * monstersInArea.size()));
            slowPrint(monster.getName() + MONSTER_APPEAR_MESSAGE, RED);

            // 몬스터 처치 횟수에 따라 능력치 조정
            int defeatedCount = defeatedMonstersCount.getOrDefault(monster.getName(), 0);
            if (defeatedCount > 0) {
                double multiplier = Math.pow(1.1, defeatedCount);
                monster.setMaxHp((int) (monster.getMaxHp() * multiplier));
                monster.setHp(monster.getMaxHp()); // 현재 HP도 최대 HP에 맞춰 조정
                monster.setAttack((int) (monster.getAttack() * multiplier));
                monster.setDefense((int) (monster.getDefense() * multiplier));
                monster.setGold((int) (monster.getGold() * multiplier));
                monster.setExperience((int) (monster.getExperience() * multiplier));
                slowPrint(monster.getName() + "(이)가 " + defeatedCount + "번 처치되어 더욱 강력해졌습니다!", YELLOW);
            }
        }

        battle(monster);
    }

    private void battle(Monster monster) {
        while (player.isAlive() && monster.isAlive()) {
            System.out.println(CYAN + "\n" + PLAYER_TURN_MESSAGE + RESET);
            player.showStatus();
            monster.showStatus();
            
            // 플레이어 독, 화상, 빙결 효과 적용
            applyStatusEffects(player, monster);

            // 플레이어가 빙결 상태면 행동 불가
            if (player.isFrozen()) {
                slowPrint(player.getName() + FROZEN_MESSAGE, CYAN);
            } else {
                System.out.println(YELLOW + ACTION_PROMPT + RESET);
                System.out.println(ATTACK_OPTION);
                System.out.println(SKILL_OPTION);
                System.out.println(DEFEND_OPTION);
                System.out.println(RUN_OPTION);
                System.out.print("선택: ");
                String choice = scanner.nextLine();
                boolean isDefending = false;

                switch (choice) {
                    case "1":
                        player.attack(monster);
                        break;
                    case "2":
                        player.showSkills();
                        System.out.print("사용할 스킬 번호를 입력하세요: ");
                        try {
                            int skillChoice = Integer.parseInt(scanner.nextLine());
                            if (!player.useSkill(skillChoice, monster)) {
                                slowPrint("MP가 부족합니다!", RED);
                                continue; // 스킬 사용 실패 시 다시 행동 선택
                            }
                        } catch (NumberFormatException e) {
                            slowPrint(ENTER_NUMBER_PROMPT, RED);
                            continue; // 잘못된 입력 시 다시 행동 선택
                        }
                        break;
                    case "3":
                        isDefending = true;
                        slowPrint(player.getName() + DEFEND_MESSAGE, BLUE);
                        break;
                    case "4":
                        if (monster instanceof Boss) {
                            slowPrint(BOSS_RUN_FAIL_MESSAGE, RED);
                        } else if (Math.random() < RUN_CHANCE) { // 50% 확률로 도망 성공
                            slowPrint(RUN_SUCCESS_MESSAGE, GREEN);
                            return; // 전투 종료
                        } else {
                            slowPrint(RUN_FAIL_MESSAGE, RED);
                        }
                        break;
                    default:
                        slowPrint(INVALID_INPUT_MESSAGE, RED);
                        break;
                }
            }

            if (!monster.isAlive()) {
                slowPrint(monster.getName() + MONSTER_DEFEATED_MESSAGE, GREEN);
                player.gainExperience(monster.getExperience());
                player.setGold(player.getGold() + monster.getGold());
                slowPrint(monster.getGold() + GOLD_ACQUIRED_MESSAGE, YELLOW);
                
                // 몬스터 처치 횟수 업데이트
                defeatedMonstersCount.put(monster.getName(), defeatedMonstersCount.getOrDefault(monster.getName(), 0) + 1);

                // 아이템 드롭 로직 추가
                if (Math.random() < ITEM_DROP_CHANCE) { // 30% 확률로 아이템 드롭
                    Item droppedItem = getRandomItem();
                    if (droppedItem != null) {
                        player.addItem(droppedItem);
                    }
                }

                this.battleCount++; // 전투 승리 시 카운트 증가
                if (monster instanceof Boss) {
                    slowPrint(GAME_WIN_MESSAGE, YELLOW);
                    System.exit(0); // 게임 종료
                }
                break; // 전투 종료
            }

            slowPrint(CYAN + "\n" + MONSTER_TURN_MESSAGE + RESET);
            // 몬스터 독, 화상, 빙결 효과 적용
            applyStatusEffects(monster, player);

            if (monster.isStunned() || monster.isFrozen()) {
                if (monster.isStunned()) slowPrint(monster.getName() + STUNNED_MESSAGE, CYAN);
                if (monster.isFrozen()) slowPrint(monster.getName() + FROZEN_MESSAGE, CYAN);
            } else {
                // 몬스터가 스킬을 사용할 확률 (예: 30%)
                if (Math.random() < MONSTER_SKILL_CHANCE) {
                    monster.useSkill(player);
                }
                else {
                    monster.attack(player);
                }
            }
            
            // 플레이어 버프 턴 감소 (applyStatusEffects로 이동)
        }
    }

    private void applyStatusEffects(Player player, Monster monster) {
        player.applyPoisonEffect();
        player.applyBurnEffect();
        player.applyFrozenEffect();
    }

    private void applyStatusEffects(Monster monster, Player player) {
        monster.applyPoisonEffect();
        monster.applyBurnEffect();
        monster.applyFrozenEffect();
    }

    private void heal() {
        System.out.println(HEAL_COST_MESSAGE + HEAL_COST + GOLD_REQUIRED_MESSAGE);
        System.out.println(CURRENT_GOLD_MESSAGE + player.getGold());
        if (player.getGold() >= HEAL_COST) {
            System.out.print(HEAL_CONFIRM_PROMPT);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                player.setGold(player.getGold() - HEAL_COST);
                player.setHp(player.getMaxHp());
                player.setMp(player.getMaxMp());
                slowPrint(HEAL_SUCCESS_MESSAGE, GREEN);
                player.showStatus();
            } else {
                slowPrint(HEAL_CANCEL_MESSAGE, RED);
            }
        } else {
            slowPrint(NOT_ENOUGH_GOLD_MESSAGE, RED);
        }
    }

    private <T extends Item> void displayShop(String shopName, List<T> shopList) {
        while (true) {
            System.out.println(YELLOW + "\n--- " + shopName + " ---" + RESET);
            for (int i = 0; i < shopList.size(); i++) {
                System.out.println((i + 1) + ". " + shopList.get(i).getItemInfo());
            }
            System.out.println((shopList.size() + 1) + ". 뒤로가기");
            System.out.print(BUY_PROMPT);

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0 && choice <= shopList.size()) {
                    T selectedItem = shopList.get(choice - 1);
                    if (player.getGold() >= selectedItem.getPrice()) {
                        player.setGold(player.getGold() - selectedItem.getPrice());
                        player.addItem(selectedItem); // 인벤토리에 추가
                    } else {
                        slowPrint(NOT_ENOUGH_GOLD_SHOP_MESSAGE, RED);
                    }
                } else if (choice == shopList.size() + 1) {
                    break;
                } else {
                    slowPrint(INVALID_ITEM_NUMBER, RED);
                }
            } catch (NumberFormatException e) {
                slowPrint(ENTER_NUMBER_PROMPT, RED);
            }
        }
    }

    private void showShop() {
        while (true) {
            System.out.println(YELLOW + "\n--- 상점 ---" + RESET);
            System.out.println(SHOP_WELCOME_MESSAGE + player.getGold() + ")");
            System.out.println(WEAPON_SHOP_OPTION);
            System.out.println(ARMOR_SHOP_OPTION);
            System.out.println(CONSUMABLE_SHOP_OPTION);
            System.out.println(SHOP_EXIT_OPTION);
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayShop("무기 상점", weaponShop);
                    break;
                case "2":
                    displayShop("방어구 상점", armorShop);
                    break;
                case "3":
                    displayShop("소모품 상점", consumableShop);
                    break;
                case "4":
                    slowPrint(SHOP_GOODBYE_MESSAGE, GREEN);
                    return;
                default:
                    slowPrint(INVALID_INPUT_MESSAGE, RED);
                    break;
            }
        }
    }

    private void showInventoryMenu() {
        while (true) {
            player.showInventory();
            System.out.println(YELLOW + INVENTORY_USE_OPTION + RESET);
            System.out.println(YELLOW + INVENTORY_EXIT_OPTION + RESET);
            System.out.print("선택: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print(USE_ITEM_PROMPT);
                    try {
                        int itemIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        player.useItem(itemIndex);
                    } catch (NumberFormatException e) {
                        slowPrint(ENTER_NUMBER_PROMPT, RED);
                    }
                    break;
                case "2":
                    return;
                default:
                    slowPrint(INVALID_INPUT_MESSAGE, RED);
                    break;
            }
        }
    }

    private Item getRandomItem() {
        List<Item> allItems = new ArrayList<>();
        allItems.addAll(weaponShop);
        allItems.addAll(armorShop);
        allItems.addAll(consumableShop); // 소모품 추가

        if (allItems.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * allItems.size());
        return allItems.get(randomIndex);
    }

    private void createPlayer() {
        System.out.print("플레이어 이름 입력: ");
        String name = scanner.nextLine();

        System.out.println("직업을 선택하세요:");
        System.out.println("1. 전사");
        System.out.println("2. 마법사");
        System.out.println("3. 도적");
        System.out.print("선택: ");
        String jobChoice = scanner.nextLine();

        switch (jobChoice) {
            case "1":
                player = new Swordsman(name);
                break;
            case "2":
                player = new Mage(name);
                break;
            case "3":
                player = new Thief(name);
                break;
            default:
                slowPrint(INVALID_INPUT_MESSAGE + ". 기본 직업인 전사로 시작합니다.", RED);
                player = new Swordsman(name);
                break;
        }
        player.showStatus();
    }
}