import java.lang.Math;
import java.util.Scanner;

/**
 * This is a separate class for Array's Elements Swapping functionality.
 * Local method "main()" is called from the Base.java class to access this functionality.
 *
 * @author Oleg Berezhnoy
 */
class ArraySwap {
    static void main() {
        Scanner scanner = new Scanner(System.in);

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
        //initializing an array with random integer numbers

        arrayRandomNumberInitialize(minBound, maxBound, randomNumberArray);

        System.out.println("\nHere's your original array[" + arrayLength + "]: ");
        arrayPrint(randomNumberArray); //printing new array after initializing

        System.out.println();

        //swapping the biggest negative and the smallest positive element in the array
        //toProcessArray is a flag to let the program print the resulted array after swapping
        boolean toProcessArray = swapMinPositiveAndMaxNegativeInArray(randomNumberArray);

        if (toProcessArray) {
            System.out.println("\nHere's your resulted array (after swapping the biggest negative and the smallest positive elements): ");
            arrayPrint(randomNumberArray); //printing resulted array after swapping elements
        } else {
            System.out.println("The program won't process your array because it's invalid!");
        }
    }

    /**
     * This is a method for getting a random integer number in the given range.
     *
     * @param minBound lower bound of the range
     * @param maxBound upper bound of the range
     * @return actual random number
     */
    private static int getRandomNumber(int minBound, int maxBound) {
        return (int) (Math.random() * ((maxBound - minBound) + 1)) + minBound;
    }

    /**
     * This is a method for initializing an array with random integer numbers in the given range.
     *
     * @param minBound         lower bound of the range
     * @param maxBound         upper bound of the range
     * @param arrayToRandomize array for initialization
     */
    private static void arrayRandomNumberInitialize(int minBound, int maxBound, int arrayToRandomize[]) {
        for (int i = 0; i < arrayToRandomize.length; i++) {
            arrayToRandomize[i] = getRandomNumber(minBound, maxBound);
            for (int j = i; j >= 0; j--) {
                if (arrayToRandomize[j] == arrayToRandomize[i] && i != j) {
                    arrayToRandomize[i] = getRandomNumber(minBound, maxBound);
                    j = i;
                }
            }
        }
    }

    /**
     * This is a method for swapping 2 elements in the array -- the biggest negative and the smallest positive ones.
     * The method makes sure that there's at least 1 positive AND 1 negative element in the array to choose from.
     * If either negative or positive elements are not present in the array, the method throws an appropriate error.
     * In this case there would be NO printing of the resulted array (hence, return boolean variable).
     *
     * @param arrayToSwapElements array for swapping elements in it.
     * @return the flag to let the main module know to print the resulted array or not
     */
    private static boolean swapMinPositiveAndMaxNegativeInArray(int arrayToSwapElements[]) {
        int minPositive = arrayToSwapElements[0];
        int indexMinPositive = 0;
        boolean isMinPositivePresent = false;

        for (int k = 0; k < arrayToSwapElements.length; k++) {
            if (arrayToSwapElements[k] > 0) {
                if (arrayToSwapElements[k] < minPositive || minPositive <= 0 && arrayToSwapElements[k] > minPositive) {
                    minPositive = arrayToSwapElements[k];
                    indexMinPositive = k;
                }
                isMinPositivePresent = true;
            }
        }

        int maxNegative = arrayToSwapElements[0];
        int indexMaxNegative = 0;
        boolean isMaxNegativePresent = false;

        for (int l = 0; l < arrayToSwapElements.length; l++) {
            if (arrayToSwapElements[l] < 0) {
                if (arrayToSwapElements[l] > maxNegative || maxNegative >= 0 && arrayToSwapElements[l] < maxNegative) {
                    maxNegative = arrayToSwapElements[l];
                    indexMaxNegative = l;
                }
                isMaxNegativePresent = true;
            }
        }

        boolean toProcessArrayDecision = true;

        if (!isMinPositivePresent && !isMaxNegativePresent) {
            System.out.println("Looks like the array is empty (zero)! Please try again!");
            toProcessArrayDecision = false;
        } else if (!isMinPositivePresent) {
            System.out.println("There're no positive elements in the array! Please try again!");
            toProcessArrayDecision = false;
        } else if (!isMaxNegativePresent) {
            System.out.println("There're no negative elements in the array! Please try again!");
            toProcessArrayDecision = false;
        } else {
            System.out.println("The smallest positive element = array[" + indexMinPositive + "] = " + minPositive + ";");
            System.out.println("The biggest negative element = array[" + indexMaxNegative + "] = " + maxNegative + ";");

            int bufferForArray = arrayToSwapElements[indexMinPositive];
            arrayToSwapElements[indexMinPositive] = arrayToSwapElements[indexMaxNegative];
            arrayToSwapElements[indexMaxNegative] = bufferForArray;
        }
        return toProcessArrayDecision;
    }

    /**
     * This is the method for printing a given array.
     *
     * @param arrayToPrint array for printing
     */
    private static void arrayPrint(int arrayToPrint[]) {
        for (int arrayElement : arrayToPrint) System.out.print(arrayElement + " ");
    }
}
