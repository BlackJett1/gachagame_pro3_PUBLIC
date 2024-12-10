import java.util.Scanner;

public class GachaGame {
    private int totalGem = 3000;
    private int bankM;
    private int totalPull = 0;
    private int totalHome = 0;
    private int totalHomeless = 0;
    private int totalLoner = 0;
    private int totalSleep = 0;
    private int totalAqua = 0;
    private int totalGamer = 0;
    private int totalBlind = 0;
    private int totalYellow = 0;
    private int totalLight = 0;
    private int totalBlue = 0;
    private int totalPink = 0;
    private int totalOrange = 0;
    private int totalGreen = 0;
    private int totalBlack = 0;
    private int totalWhite = 0;
    private int totalRed = 0;
    private int totalPurple = 0;

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
        if (randomPull <= 0.5) {
            int goldChance = (int)(Math.random() * 100);
            if (goldChance <= 30) {
                totalHome++;
                System.out.println("Home spirit (gold) pulled.");
            } else {
                totalHomeless++;
                System.out.println("Homeless spirit (gold) pulled.");
            }
        } else if (randomPull <= 5.0) {
            int epicPull = (int)(Math.random() * 5) + 1;
            switch (epicPull) {
                case 1:
                    totalLoner++;
                    System.out.println("Loner spirit (epic) pulled.");
                    break;
                case 2:
                    totalSleep++;
                    System.out.println("Sleep spirit (epic) pulled.");
                    break;
                case 3:
                    totalAqua++;
                    System.out.println("Aqua spirit (epic) pulled.");
                    break;
                case 4:
                    totalGamer++;
                    System.out.println("Gamer spirit (epic) pulled.");
                    break;
                case 5:
                    totalBlind++;
                    System.out.println("Blind spirit (epic) pulled.");
                    break;
            }
        } else {
            int rarePull = (int)(Math.random() * 10) + 1;
            switch (rarePull) {
                case 1:
                    totalYellow++;
                    System.out.println("Yellow spirit (rare) pulled.");
                    break;
                case 2:
                    totalLight++;
                    System.out.println("Light spirit (rare) pulled.");
                    break;
                case 3:
                    totalBlue++;
                    System.out.println("Blue spirit (rare) pulled.");
                    break;
                case 4:
                    totalPink++;
                    System.out.println("Pink spirit (rare) pulled.");
                    break;
                case 5:
                    totalGreen++;
                    System.out.println("Green spirit (rare) pulled.");
                    break;
                case 6:
                    totalOrange++;
                    System.out.println("Orange spirit (rare) pulled.");
                    break;
                case 7:
                    totalBlack++;
                    System.out.println("Black spirit (rare) pulled.");
                    break;
                case 8:
                    totalWhite++;
                    System.out.println("White spirit (rare) pulled.");
                    break;
                case 9:
                    totalRed++;
                    System.out.println("Red spirit (rare) pulled.");
                    break;
                case 10:
                    totalPurple++;
                    System.out.println("Purple spirit (rare) pulled.");
                    break;
            }
        }
    }


    public void checkForEndingConditions() {
        if (totalPull >= 70) {
            int goldChance = (int)(Math.random() * 100);
            if (goldChance <= 30) {
                totalHome++;
                System.out.println("Home spirit (gold) pulled.");
            } else {
                totalHomeless++;
                System.out.println("Homeless spirit (gold) pulled.");
            }
            totalPull = 0;


            if (totalHome >= 4) {
                System.out.println("After obtaining 4 home spirits: The spirits brought a sense of warmth, guiding you to where you belong, a dream that repeats all throughout winter, bringing joy and happiness, all year long (good ending)");
                System.exit(0);
            } else if (totalHomeless >= 4) {
                System.out.println("After obtaining 4 homeless spirits: The spirits snapped you back to reality, the emptiness of your wallet dragged you deeply into your thoughts, you started to wonder the streets, while catching strays (bad ending)");
                System.exit(0);
            }
        }

        // Normal Ending
        if (totalGem < 150 && bankM == 0) {
            System.out.println("All money and gems used up: You are officially broke, good luck out there :) (Normal ending)");
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
        System.out.println("---Rare spirits---");
        System.out.println("Total Yellow spirits: " + totalYellow);
        System.out.println("Total Light spirits: " + totalLight);
        System.out.println("Total Blue spirits: " + totalBlue);
        System.out.println("Total Pink spirits: " + totalPink);
        System.out.println("Total Green spirits: " + totalGreen);
        System.out.println("Total Orange spirits: " + totalOrange);
        System.out.println("Total Black spirits: " + totalBlack);
        System.out.println("Total White spirits: " + totalWhite);
        System.out.println("Total Red spirits: " + totalRed);
        System.out.println("Total Purple spirits: " + totalPurple);

        System.out.println("---Epic spirits---");
        System.out.println("Total Loner spirits: " + totalLoner);
        System.out.println("Total Sleep spirits: " + totalSleep);
        System.out.println("Total Aqua spirits: " + totalAqua);
        System.out.println("Total Gamer spirits: " + totalGamer);
        System.out.println("Total Blind spirits: " + totalBlind);

        System.out.println("---Gold spirits---");
        System.out.println("Total Home spirits: " + totalHome);
        System.out.println("Total Homeless spirits: " + totalHomeless);
    }

    public void exitGame() {
        System.out.println("Thanks for playing, no refunds allowed!!!");
    }
}
