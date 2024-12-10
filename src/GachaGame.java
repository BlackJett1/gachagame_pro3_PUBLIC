import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class GachaGame {
    private int totalGem = 3000;
    private int bankM;
    private int totalPull = 0;

    private Map<String, Integer> spiritCounts = new HashMap<>();

    private Scanner sc = new Scanner(System.in);

    public GachaGame() {
        bankM = (int)(Math.random() * 2001);
    }

    public void startGame() {
        System.out.println("Welcome to the Fundamental Gacha Game (Game save not implemented).");
        System.out.println("Total Gem(s): " + totalGem);
        System.out.println("Bank Money: " + bankM);

        while (true) {
            System.out.println("\nPull");
            System.out.println("Buy Gems");
            System.out.println("Collection");
            System.out.println("Exit");

            System.out.print("\nChoose an option (pull, buy gems, collection, exit): ");
            String choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "pull":
                    performPull();
                    break;
                case "buy gems":
                    buyGems();
                    break;
                case "collection":
                    displayCollection();
                    break;
                case "exit":
                    exitGame();
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }

    public void performPull() {
        System.out.println("Total Gem(s): " + totalGem);
        System.out.print("Do you want to perform 1 pull or 10 pulls? ");
        String pullChoice = sc.nextLine().toLowerCase();

        if (pullChoice.equals("1 pull")) {
            if (totalGem >= 150) {
                totalGem -= 150;
                totalPull++;
                gachaPull();
                System.out.println("You have " + totalGem + " gems left after 1 pull.");
                checkForEndingConditions();
            } else {
                System.out.println("Not enough gems for 1 pull.");
            }
        } else if (pullChoice.equals("10 pulls")) {
            if (totalGem >= 1500) {
                totalGem -= 1500;
                for (int i = 0; i < 10; i++) {
                    totalPull++;
                    gachaPull();
                }
                System.out.println("You have " + totalGem + " gems left after 10 pulls.");
                checkForEndingConditions();
            } else {
                System.out.println("Not enough gems for 10 pulls.");
            }
        } else {
            System.out.println("Invalid input, please try again.");
        }
    }

    public void gachaPull() {
        double randomPull = Math.random() * 100;
        Spirit pulledSpirit = null;

        String type = "";
        String rarity = "";

        if (randomPull <= 0.5) {
            int goldChance = (int)(Math.random() * 100);
            if (goldChance <= 30) {
                pulledSpirit = new Spirit("Home", "Gold");
                type = "Home";
                rarity = "Gold";
                System.out.println("Home spirit (gold) pulled.");
            } else {
                pulledSpirit = new Spirit("Homeless", "Gold");
                type = "Homeless";
                rarity = "Gold";
                System.out.println("Homeless spirit (gold) pulled.");
            }
        } else if (randomPull <= 5.0) {
            int epicPull = (int)(Math.random() * 5) + 1;
            switch (epicPull) {
                case 1:
                    pulledSpirit = new Spirit("Loner", "Epic");
                    type = "Loner";
                    rarity = "Epic";
                    System.out.println("Loner spirit (epic) pulled.");
                    break;
                case 2:
                    pulledSpirit = new Spirit("Sleep", "Epic");
                    type = "Sleep";
                    rarity = "Epic";
                    System.out.println("Sleep spirit (epic) pulled.");
                    break;
                case 3:
                    pulledSpirit = new Spirit("Aqua", "Epic");
                    type = "Aqua";
                    rarity = "Epic";
                    System.out.println("Aqua spirit (epic) pulled.");
                    break;
                case 4:
                    pulledSpirit = new Spirit("Gamer", "Epic");
                    type = "Gamer";
                    rarity = "Epic";
                    System.out.println("Gamer spirit (epic) pulled.");
                    break;
                case 5:
                    pulledSpirit = new Spirit("Blind", "Epic");
                    type = "Blind";
                    rarity = "Epic";
                    System.out.println("Blind spirit (epic) pulled.");
                    break;
            }
        } else {
            int rarePull = (int)(Math.random() * 10) + 1;
            switch (rarePull) {
                case 1:
                    pulledSpirit = new Spirit("Yellow", "Rare");
                    type = "Yellow";
                    rarity = "Rare";
                    System.out.println("Yellow spirit (rare) pulled.");
                    break;
                case 2:
                    pulledSpirit = new Spirit("Light", "Rare");
                    type = "Light";
                    rarity = "Rare";
                    System.out.println("Light spirit (rare) pulled.");
                    break;
                case 3:
                    pulledSpirit = new Spirit("Blue", "Rare");
                    type = "Blue";
                    rarity = "Rare";
                    System.out.println("Blue spirit (rare) pulled.");
                    break;
                case 4:
                    pulledSpirit = new Spirit("Pink", "Rare");
                    type = "Pink";
                    rarity = "Rare";
                    System.out.println("Pink spirit (rare) pulled.");
                    break;
                case 5:
                    pulledSpirit = new Spirit("Green", "Rare");
                    type = "Green";
                    rarity = "Rare";
                    System.out.println("Green spirit (rare) pulled.");
                    break;
                case 6:
                    pulledSpirit = new Spirit("Orange", "Rare");
                    type = "Orange";
                    rarity = "Rare";
                    System.out.println("Orange spirit (rare) pulled.");
                    break;
                case 7:
                    pulledSpirit = new Spirit("Black", "Rare");
                    type = "Black";
                    rarity = "Rare";
                    System.out.println("Black spirit (rare) pulled.");
                    break;
                case 8:
                    pulledSpirit = new Spirit("White", "Rare");
                    type = "White";
                    rarity = "Rare";
                    System.out.println("White spirit (rare) pulled.");
                    break;
                case 9:
                    pulledSpirit = new Spirit("Red", "Rare");
                    type = "Red";
                    rarity = "Rare";
                    System.out.println("Red spirit (rare) pulled.");
                    break;
                case 10:
                    pulledSpirit = new Spirit("Purple", "Rare");
                    type = "Purple";
                    rarity = "Rare";
                    System.out.println("Purple spirit (rare) pulled.");
                    break;
            }
        }


        updateSpiritCount(type, rarity);
    }

    public void updateSpiritCount(String type, String rarity) {
        String key = type + " (" + rarity + ")";
        spiritCounts.put(key, spiritCounts.getOrDefault(key, 0) + 1);
    }

    public void checkForEndingConditions() {
        if (totalPull >= 70) {
            int goldChance = (int)(Math.random() * 100);
            if (goldChance <= 30) {
                updateSpiritCount("Home", "Gold");
                System.out.println("Home spirit (gold) pulled.");
            } else {
                updateSpiritCount("Homeless", "Gold");
                System.out.println("Homeless spirit (gold) pulled.");
            }
            totalPull = 0;


            long homeCount = spiritCounts.getOrDefault("Home (Gold)", 0) + spiritCounts.getOrDefault("Home (Epic)", 0) + spiritCounts.getOrDefault("Home (Rare)", 0);
            long homelessCount = spiritCounts.getOrDefault("Homeless (Gold)", 0) + spiritCounts.getOrDefault("Homeless (Epic)", 0) + spiritCounts.getOrDefault("Homeless (Rare)", 0);

            if (homeCount >= 4) {
                System.out.println("After obtaining 4 home spirits: The spirits brought a sense of warmth, guiding you to where you belong, a dream that repeats all throughout winter, bring joy and happiness, all year long (good ending)");
                System.exit(0);
            } else if (homelessCount >= 4) {
                System.out.println("After obtaining 4 homeless spirits: The spirits snapped you back  to reality, the emptiness of your wallet dragged you deeply into your thoughts, you started to wonder the streets, while catching strays(bad ending)");
                System.exit(0);
            }
        }


        if (totalGem < 150 && bankM == 0) {
            System.out.println("All money and gems used up:You are official broke, good luck out there :D (Normal ending)");
            System.exit(0);
        }
    }

    public void buyGems() {
        System.out.println("Total Gem(s): " + totalGem);
        System.out.println("Bank Money: " + bankM);

        System.out.println("30 gems = $1");
        System.out.println("1500 gems = $50");
        System.out.println("3000 gems = $100");
        System.out.println("6500 gems = $200");
        System.out.println("18000 gems = $500");

        while (true) {
            System.out.print("Enter amount (1, 50, 100, 200, 500, or back): ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    if (bankM >= 1) {
                        totalGem += 30;
                        bankM -= 1;
                        System.out.println("You bought 30 gems for $1");
                    } else {
                        System.out.println("Sorry, you don't have enough to buy.");
                    }
                    break;
                case "50":
                    if (bankM >= 50) {
                        totalGem += 1500;
                        bankM -= 50;
                        System.out.println("You bought 1500 gems for $50");
                    } else {
                        System.out.println("Sorry, you don't have enough to buy.");
                    }
                    break;
                case "100":
                    if (bankM >= 100) {
                        totalGem += 3000;
                        bankM -= 100;
                        System.out.println("You bought 3000 gems for $100");
                    } else {
                        System.out.println("Sorry, you don't have enough to buy.");
                    }
                    break;
                case "200":
                    if (bankM >= 200) {
                        totalGem += 6500;
                        bankM -= 200;
                        System.out.println("You bought 6500 gems for $200");
                    } else {
                        System.out.println("Sorry, you don't have enough to buy.");
                    }
                    break;
                case "500":
                    if (bankM >= 500) {
                        totalGem += 18000;
                        bankM -= 500;
                        System.out.println("You bought 18000 gems for $500");
                    } else {
                        System.out.println("Sorry, you don't have enough to buy.");
                    }
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again.");
                    continue;
            }

            System.out.println("Total Gems: " + totalGem);
            System.out.println("Bank Money: " + bankM);
        }
    }

    public void displayCollection() {

        Map<String, Integer> rareSpirits = new TreeMap<>();
        Map<String, Integer> epicSpirits = new TreeMap<>();
        Map<String, Integer> goldSpirits = new TreeMap<>();


        for (Map.Entry<String, Integer> entry : spiritCounts.entrySet()) {
            String spiritKey = entry.getKey();
            int count = entry.getValue();

            if (spiritKey.contains("Gold")) {
                goldSpirits.put(spiritKey, count);
            } else if (spiritKey.contains("Epic")) {
                epicSpirits.put(spiritKey, count);
            } else if (spiritKey.contains("Rare")) {
                rareSpirits.put(spiritKey, count);
            }
        }


        System.out.println("---Your Collection---");


        System.out.println("\n---Gold Spirits---");
        for (Map.Entry<String, Integer> entry : goldSpirits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pulled");
        }


        System.out.println("\n---Epic Spirits---");
        for (Map.Entry<String, Integer> entry : epicSpirits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pulled");
        }


        System.out.println("\n---Rare Spirits---");
        for (Map.Entry<String, Integer> entry : rareSpirits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " pulled");
        }
    }

    public void exitGame() {
        System.out.println("Thanks for playing, no refunds allowed!!!");
    }
}
