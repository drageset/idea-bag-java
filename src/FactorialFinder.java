import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A console app for calculating factorials of non-negative integers supplied by the user.
 */
public class FactorialFinder {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("#   Welcome! to! the! factorial! calculator!    #");
        do { // asks the user for inputs until the user exits or gives valid input
            try {
                System.out.println("Please enter a non-negative integer, or type 'exit' to end the session:");
                String userInput = br.readLine();
                if (userInput.equals("exit")) {
                    System.out.println("Thank you for using the factorial calculator! Goodbye!");
                    System.exit(0);
                } else {
                    int userInputInteger = Integer.parseInt(userInput);
                    //System.out.println("!" + userInputInteger + " is " + calculateFactorialIteratively(userInputInteger));
                    System.out.println("!" + userInputInteger + " is " + calculateFactorialRecursively(userInputInteger));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR, invalid input. " + e);
            }
        } while (true);
    }

    /**
     * Calculates the factorial (!input) of an input non-negative int through an iterative process
     *
     * @param input must be a non-negative integer
     * @return an integer that is the !factorial of the input
     */
    public static int calculateFactorialIteratively(int input) {
        int factorial = 1;
        for (int i = input; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Calculates the factorial (!input) of an input non-negative int through recursive calls
     *
     * @param input must be a non-negative integer
     * @return an integer that is the !factorial of the input
     */
    public static int calculateFactorialRecursively(int input) {
        if (input == 0) {
            return 1;
        } else {
            return input * calculateFactorialRecursively(input - 1);
        }
    }

}