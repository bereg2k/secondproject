import sweets.Chocolate;
import sweets.Jellybean;
import sweets.Lollipop;
import sweets.Sweets;

import java.util.Scanner;

/**
 * This is a separate class for Packing the Gift functionality.
 * Local method "main()" is called from the Base.java class to access this functionality.
 * User can add a single item of each  type of sweets available (currently, 3 types).
 *
 * @author Oleg Berezhnoy
 */
class Gift {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        //creating class objects for available types of sweets -- chocolate, jelly beans, lollipops
        Chocolate chocolate1 = new Chocolate("Alpen Gold Milky", 100, 45.99, "milk");
        Chocolate chocolate2 = new Chocolate("Alpen Gold Cappuccino", 100, 68.99, "milk");
        Chocolate chocolate3 = new Chocolate("Lindt 99%", 100, 155.50, "dark");
        Chocolate chocolate4 = new Chocolate("Snickers KingSize", 89.45, 65.25, "milk");
        Chocolate chocolate5 = new Chocolate("Milka Arctic", 50.75, 75.10, "white");

        Jellybean jellySB = new Jellybean("Haribo Bears", 90.54, 45.30, "strawberry");
        Jellybean jellyBanana = new Jellybean("Skittles popups", 45, 30.90, "banana");

        Lollipop lolliChup = new Lollipop("Chupa-Chups Megastar", 40.99, 38.50, "XL");
        Lollipop lolliBubble = new Lollipop("Bubble Dinger Vanilla", 10.45, 20.50, "S");
        Lollipop lolliTop = new Lollipop("TOP of the POP", 15.99, 25.99, "M");

        //creating additional arrays for respective sweets
        Sweets chocolatePackage[] = new Sweets[]{chocolate1, chocolate2, chocolate3, chocolate4, chocolate5};
        Sweets jellybeanPackage[] = new Sweets[]{jellySB, jellyBanana};
        Sweets lollipopPackage[] = new Sweets[]{lolliChup, lolliBubble, lolliTop};
        //creating variables to store user's choice of respective sweets
        int chocolateChoice;
        int jellyBeanChoice;
        int lollipopChoice;

        System.out.println("\nThis is 'Packing the Gift' functionality!\n");

        System.out.println("Let's first choose all the necessary sweets to add to the gift.");
        System.out.println("\nHere's all the available chocolate bars:");
        printSweetsArray(chocolatePackage);
        System.out.print("Choose the chocolate you want to add to the gift (enter its number): ");
        chocolateChoice = scanner.nextInt();

        System.out.println("\nHere's all the available jelly beans:");
        printSweetsArray(jellybeanPackage);
        System.out.print("Choose the jelly beans you want to add to the gift (enter its number): ");
        jellyBeanChoice = scanner.nextInt();

        System.out.println("\nHere's all the available lollipops:");
        printSweetsArray(lollipopPackage);
        System.out.print("Choose the lollipops you want to add to the gift (enter its number): ");
        lollipopChoice = scanner.nextInt();

        Sweets gift[] = new Sweets[3]; //declaring target gift array for 3 elements, each for every type of sweets.

        //adding chocolate element to gift box depending on the previous user's choice
        switch (chocolateChoice) {
            case 1: {
                gift[0] = chocolate1;
                break;
            }
            case 2: {
                gift[0] = chocolate2;
                break;
            }
            case 3: {
                gift[0] = chocolate3;
                break;
            }
            case 4: {
                gift[0] = chocolate4;
                break;
            }
            case 5: {
                gift[0] = chocolate5;
                break;
            }
            default: {
                gift[0] = null;
                break;
            }
        }

        //adding jelly beans element to gift box depending on the previous user's choice
        switch (jellyBeanChoice) {
            case 1: {
                gift[1] = jellySB;
                break;
            }
            case 2: {
                gift[1] = jellyBanana;
                break;
            }
            default: {
                gift[1] = null;
                break;
            }
        }

        //adding lollipop element to gift box depending on the previous user's choice
        switch (lollipopChoice) {
            case 1: {
                gift[2] = lolliChup;
                break;
            }
            case 2: {
                gift[2] = lolliBubble;
                break;
            }
            case 3: {
                gift[2] = lolliTop;
                break;
            }
            default: {
                gift[2] = null;
                break;
            }
        }

        //In case user chose non-existent product previously, the program throws an error and stops execution.
        if (gift[0] == null || gift[1] == null || gift[2] == null) {
            System.err.println("Invalid number of some sweets was entered! Program aborted!");
            System.exit(1);
        }
        //printing formed gift box's contents
        System.out.println("\nThank you for your choice! Here's the contents of your gift:");
        printSweetsArray(gift);

        //calling methods for calculating total weight and total price of resulting gift box
        System.out.printf("\nTotal weight of the gift is %.2f grams.", getGiftTotalWeight(gift));
        System.out.printf("\nTotal price of the gift is %.2f rubles.", getGiftTotalPrice(gift));
    }

    /**
     * This method calculates the total weight of the given gift box.
     * @param giftArray array of Sweets class consisting of various sweets
     * @return total weight value
     */
    private static double getGiftTotalWeight(Sweets giftArray[]) {
        double giftTotalWeight = 0;
        for (Sweets giftWeight : giftArray
        ) {
            giftTotalWeight += giftWeight.getWeight();
        }
        return giftTotalWeight;
    }

    /**
     * This method calculates the total price of the given gift box.
     * @param giftArray array of Sweets class consisting of various sweets
     * @return total price value
     */
    private static double getGiftTotalPrice(Sweets giftArray[]) {
        double giftTotalPrice = 0;
        for (Sweets giftPrice : giftArray
        ) {
            giftTotalPrice += giftPrice.getPrice();
        }
        return giftTotalPrice;
    }

    /**
     * This method prints a given array of Sweets class.
     * The printing adds numeric values to elements (starting with 1 instead of 0!).
     * @param sweetsArray array of Sweets class consisting of various sweets
     */
    private static void printSweetsArray(Sweets sweetsArray[]) {
        for (int i = 0; i < sweetsArray.length; i++) {
            System.out.println((i + 1) + ". " + sweetsArray[i].toString());
        }
    }
}
