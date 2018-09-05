import java.util.Scanner;

/**
 * 1. Array's Elements Swapping.
 * Declaring an array of an entered number of elements.
 * Initialize it with random integer numbers from the entered range.
 * Task: Find max negative and minimal positive elements and swap them.
 * Print the initial and resulting array on the screen.
 * <p>
 * 2. Packing the Gift
 * User is packing a gift.
 * The gift can include various sweets like Candy, Jellybean...
 * Each sweet has Name, Weight, Price and some unique parameter.
 * User forms a gift contained of several sweets.
 * All sweets are specific classes extending some abstract class.
 * Find and print Total Weight and Total Price.
 * Also print all the details of sweets in the Gift.
 *
 * @author Oleg Berezhnoy
 */
public class Base {
    public static void main(String[] args) {

        //startAgain - variable to let the "while"-cycle below know, whether user wants to exit the program or use it again.
        //scanner - basic console input.
        boolean startAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {
            //Main menu of the program. User can choose to open Array's Elements Swapping, Packing the Gift or Exit.
            System.out.println("\nHi there! This is the MAIN MENU. What would you like to work with?");
            System.out.print("Enter '1' for Array Elements Swapping, '2' for Packing the Gift, '3' for Exit: ");
            int mainChoice = scanner.nextInt();

            //This branch is for accessing Array's Elements Swapping from the main menu.
            if (mainChoice == 1) {
                ArraySwap.main(); //calling main method of ArraySwap class

                System.out.println();

                //calling method to start again and return a flag value for "while"-cycle
                startAgain = startAgainFunction(scanner, 'a');
            }

            //This branch is for Packing the Gift.
            else if (mainChoice == 2) {

                System.out.println("\nPacking the Gift. STUB");
                startAgain = startAgainFunction(scanner, 'g');
            }

            //This branch is for quitting the program from the main menu.
            else if (mainChoice == 3) {
                System.out.println("\nThank you! Bye!");
                startAgain = false;
            }

            //This branch is for handling invalid input from the main menu.
            else {
                System.err.println("\nInvalid number entered! Please try again!");
                startAgain = true;
            }
        }
        scanner.close();
    }

    private static boolean startAgainFunction(Scanner scanner, char flagForExit) {
        /*If user enters "y", then program goes back to main menu.
        If user enters "n", then program ends its execution.
        Otherwise, the program terminates with an error.*/

        boolean startAgainLocal; //startAgainLocal - to avoid confusion with main "startAgain" variable

        System.out.print("\nWould you like to start again [y/n]?: ");
        String exit = scanner.next(); //exit - additional string variable to exit the program after executing a function.

        if (exit.equals("y")) {
            startAgainLocal = true;
        } else if (exit.equals("n")) {
            switch (flagForExit) {  // flagForExit - variable for correct exit message on quitting the chosen module
                case 'a':
                    System.out.println("Thank you for using our 'Array's Elements Swapping' tool! Bye!");
                    break;
                case 'g':
                    System.out.println("Thank you for using our 'Packing the Gift' tool! Bye!");
                    break;
            }
            startAgainLocal = false;
        } else {
            System.err.println("Invalid input! Program aborted!");
            startAgainLocal = false;
        }
        return startAgainLocal;
    }
}



