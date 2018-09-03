import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;

/**
 * 1. Array-20.
 * Declaring an array of 20 elements.
 * Initialize it with random integer numbers from -10 to 10.
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
        //exit - additional string variable to exit the program after executing a function (array-20, gift packing...).
        //scanner - basic console input.
        boolean startAgain = true;
        String exit;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {

            //Main menu of the program. User can choose to open Calculator, Find max element in array or Exit.
            System.out.println();
            System.out.println("Hi there! This is the MAIN MENU. What would you like to work with?");
            System.out.print("Enter '1' for Array-20, '2' for Packing the Gift, '3' for Exit: ");
            int mainChoice = scanner.nextInt();

            //This branch is for accessing Array-20 from the main menu.
            if (mainChoice == 1) {

                System.out.println("Array-20 stub");

                int[] randomNumberArray = {1, 2, 3, 4, 5};

                for (int i : randomNumberArray) {
                    System.out.print(i + " ");
                }

                System.out.println();
                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("Would you like to start again [y/n]?: ");
                exit = scanner.next();
                if (exit.equals("y")) {
                    startAgain = true;
                } else if (exit.equals("n")) {
                    System.out.println("Thank you for using our Array-20 tool! Bye!");
                    startAgain = false;
                } else {
                    System.err.println("Invalid input! Program aborted!");
                    startAgain = false;
                }

            }

            //This branch is for Packing the Gift.
            else if (mainChoice == 2) {
                System.out.println("Packing the Gift. STUB");

                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("Would you like to start again [y/n]?: ");
                exit = scanner.next();
                if (exit.equals("y")) {
                    startAgain = true;
                } else if (exit.equals("n")) {
                    System.out.println("Thank you for using our Packing the Gift tool! Bye!");
                    startAgain = false;
                } else {
                    System.err.println("Invalid input! Program aborted!");
                    startAgain = false;
                }
            }

            //This branch is for quitting the program from the main menu.
            else if (mainChoice == 3) {
                System.out.println("Thank you! Bye!");
                startAgain = false;
            }

            //This branch is for handling invalid input from the main menu.
            else {
                System.err.println("Invalid number entered! Please try again!");
                startAgain = true;
            }
        }
        scanner.close();
    }

}


