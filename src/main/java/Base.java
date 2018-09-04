import java.util.Scanner;
import java.lang.Math;

//import java.util.concurrent.ThreadLocalRandom;

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
        //exit - additional string variable to exit the program after executing a function (array-20, gift packing...).
        //scanner - basic console input.
        boolean startAgain = true;
        String exit;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {

            //Main menu of the program. User can choose to open Array's Elements Swapping, Packing the Gift or Exit.
            System.out.println("\nHi there! This is the MAIN MENU. What would you like to work with?");
            System.out.print("Enter '1' for Array Elements Swapping, '2' for Packing the Gift, '3' for Exit: ");
            int mainChoice = scanner.nextInt();

            //This branch is for accessing Array's Elements Swapping from the main menu.
            if (mainChoice == 1) {
                System.out.println("This is 'Array's Elements Swapping' functionality.");
                System.out.print("Enter array's length: ");
                int arrayLength = scanner.nextInt();
                int randomNumberArray[] = new int[arrayLength];
                System.out.print("Enter lower bound of array: ");
                int minBound = scanner.nextInt();
                System.out.print("Enter upper bound of array: ");
                int maxBound = scanner.nextInt();
                if (arrayLength > maxBound - minBound + 1) {
                    System.err.println("Incompatible parameters of the array!");
                    System.exit(0);
                }

                System.out.println("\nHere's your original array: ");
                for (int i = 0; i < arrayLength; i++) {
                    randomNumberArray[i] = getRandomNumber(minBound, maxBound);
                    for (int j = i; j >= 0; j--) {
                        if (randomNumberArray[j] == randomNumberArray[i] && i != j) {
                            randomNumberArray[i] = getRandomNumber(minBound, maxBound);
                            j = i;
                        }
                    }
                    System.out.print(randomNumberArray[i] + " ");
                }
                System.out.println();

                int maxNegative = randomNumberArray[0];
                int indexMaxNegative = 0;
                boolean isMaxNegativePresent = false;
                int minPositive = randomNumberArray[0];
                int indexMinPositive = 0;
                boolean isMinPositivePresent = false;

                for (int k = 0; k < arrayLength; k++) {
                    if (randomNumberArray[k] > 0) {
                        if (randomNumberArray[k] < minPositive || minPositive <= 0 && randomNumberArray[k] > minPositive) {
                            minPositive = randomNumberArray[k];
                            indexMinPositive = k;
                        }
                        isMinPositivePresent = true;
                    }
                }

                for (int l = 0; l < arrayLength; l++) {
                    if (randomNumberArray[l] < 0) {
                        if (randomNumberArray[l] > maxNegative || maxNegative >= 0 && randomNumberArray[l] < maxNegative) {
                            maxNegative = randomNumberArray[l];
                            indexMaxNegative = l;
                        }
                        isMaxNegativePresent = true;
                    }
                }

                if (!isMinPositivePresent) {
                    System.err.println("There're no positive elements in the array! Please try again!");
                } else if (!isMaxNegativePresent) {
                    System.err.println("There're no negative elements in the array! Please try again!");
                } else {
                    System.out.println("minPositive = " + minPositive + ";");
                    System.out.println("indexMinPositive = " + indexMinPositive + ";");

                    System.out.println("maxNegative = " + maxNegative + ";");
                    System.out.println("indexMaxNegative = " + indexMaxNegative + ";");

                    int bufferForArray = randomNumberArray[indexMinPositive];
                    randomNumberArray[indexMinPositive] = randomNumberArray[indexMaxNegative];
                    randomNumberArray[indexMaxNegative] = bufferForArray;

                    System.out.println("\nHere's your resulted array (after swapping maxNegative and minPositive): ");

                    for (int m = 0; m < arrayLength; m++)
                        System.out.print(randomNumberArray[m] + " ");
                }

                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("\n\nWould you like to start again [y/n]?: ");
                exit = scanner.next();
                if (exit.equals("y")) {
                    startAgain = true;
                } else if (exit.equals("n")) {
                    System.out.println("Thank you for using our 'Array's Elements Swapping' tool! Bye!");
                    startAgain = false;
                } else {
                    System.err.println("Invalid input! Program aborted!");
                    startAgain = false;
                }

            }

            //This branch is for Packing the Gift.
            else if (mainChoice == 2) {
                System.out.print("\nPacking the Gift. STUB");

                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("\n\nWould you like to start again [y/n]?: ");
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

    private static int getRandomNumber(int minBound, int maxBound) {
        return (int) (Math.random() * ((maxBound - minBound) + 1)) + minBound;
    }
}



