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

        System.out.println("\nThis is 'Packing the Gift' functionality!\n");
        System.out.print("Please enter the desired number of sweets in the gift box : ");
        int giftSize = scanner.nextInt();
        Sweets gift[] = new Sweets[giftSize];   //creating an array for a gift of entered size

        //filling the gift box with various sweets. User chooses type and certain sweets by keyboard input.
        System.out.println("Let's first choose all the necessary sweets to add to the gift.");
        int choice;
        for (int i = 0; i < giftSize; i++) {
            System.out.print("Enter '1' to add chocolate, '2' to add jelly beans, or '3' to add lollipops: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose the chocolate you want to add to the gift (enter its number): ");
                    gift[i] = selectSweet(chocolatePackage);
                    System.out.println("You have " + (giftSize - i - 1) + " more sweets to complete your gift box.\n");
                    break;
                case 2:
                    System.out.println("Choose the jelly beans you want to add to the gift (enter its number): ");
                    gift[i] = selectSweet(jellybeanPackage);
                    System.out.println("You have " + (giftSize - i - 1) + " more sweets to complete your gift box.\n");
                    break;
                case 3:
                    System.out.println("Choose the lollipops you want to add to the gift (enter its number): ");
                    gift[i] = selectSweet(lollipopPackage);
                    System.out.println("You have " + (giftSize - i - 1) + " more sweets to complete your gift box.\n");
                    break;
                default:
                    System.out.println("Invalid number entered! Please try again!"); //invalid number entered handling
                    i--;
                    break;
            }
        }

        //printing formed gift box's contents
        System.out.println("Thank you for your choice! Here's the contents of your gift:");
        printSweetsArray(gift);

        //calling methods for calculating total weight and total price of resulting gift box
        System.out.printf("\nTotal weight of the gift is %.2f grams.", getGiftTotalWeight(gift));
        System.out.printf("\nTotal price of the gift is %.2f rubles.", getGiftTotalPrice(gift));
    }

    /**
     * This method calculates the total weight of the given gift box.
     *
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
     *
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
     *
     * @param sweetsArray array of Sweets class consisting of various sweets
     */
    private static void printSweetsArray(Sweets sweetsArray[]) {
        for (int i = 0; i < sweetsArray.length; i++) {
            System.out.println((i + 1) + ". " + sweetsArray[i].toString());
        }
    }

    /**
     * This method selects a user's sweets of choice in the given package (chocolate, jelly beans or lollipops)
     * @param sweetsArray chosen sweets package (chocolate, jelly beans or lollipops)
     * @return the chosen piece of sweets
     */
    private static Sweets selectSweet(Sweets sweetsArray[]) {
        printSweetsArray(sweetsArray);
        Scanner scanner = new Scanner(System.in);
        int sweetsChoice = scanner.nextInt();
        while (sweetsChoice > sweetsArray.length || sweetsChoice <= 0) { //invalid input handling
            System.out.println("The number is invalid! Please try again!");
            sweetsChoice = scanner.nextInt();
        }
        return sweetsArray[sweetsChoice - 1]; //numbering on the screen starts with 1 (unlike in java array's logic)
    }
}
