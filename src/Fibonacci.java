import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class runs a console app for getting fibonacci numbers and sequences.
 * @author drageset
 */
public class Fibonacci {
    public static void main(String[] args) {
        boolean quit = false;
        int menuSelectionInt;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!quit) {
            System.out.println("1 - Find the n'th Fibonacci number");
            System.out.println("2 - Find the n first Fibonacci numbers");
            //System.out.println("3 - Find Fibonacci numbers under n");
            System.out.println("Q - Quit");
            try {
                input = br.readLine();
                if (input.toLowerCase().equals("q")) {
                    quit = true;
                } else {
                    menuSelectionInt = Integer.parseInt(input);
                    switch (menuSelectionInt) {
                        case 1:
                            findFibN(); //new menu for finding the n first fibonacci numbers
                            break;
                        case 2:
                            System.out.println("How many fibonacci number should we find?");
                            input = br.readLine();
                            int n = Integer.parseInt(input);
                            List<Integer> fibList = findFibSequence(n);
                            printIntList(fibList); //prints the list of fibonacci numbers on a single line
                            break;
                        case 3:
                            //fibsUnderN();
                            //TODO: Implement fibsUnderN(), and uncomment the line above and the CLI menu option print;
                            break;
                        default:
                            System.out.println("Choose between option '1', '2', '3', and 'Q'");
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println("Error: Could not parse input to an integer");
            }
        } //end menu while loop

    }//end main

    /**
     * separates the menu for finding the n first fibonacci numbers from the main menu
     */
    private static void findFibN() {
        boolean quit = false;
        int n;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Give a positive integer n, or type 'q'/'Q' to quit to main menu:");
            try {
                input = br.readLine();
                if (input.toLowerCase().equals("q")) {
                    quit = true;
                } else {
                    n = Integer.parseInt(input);
                    if (n >= 1) {
                        System.out.println("Fib number " + n + " is " + fibN(n));
                    } else {
                        System.out.println("Please give an integer larger than 0");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException nfe) {
                System.out.println("Error: Could not parse input to an integer");
            }
        } while (!quit);
    }

    /**
     * Returns the n'th fibonacci number
     *
     * @param n is the index of the fibonacci number you want to return
     * @return the fibonacci number at index n
     */
    public static int fibN(int n) {
        int last = 1;
        int secondLast = 0;
        for (int i = 2; i < n; i++) {
            last = last + secondLast;
            secondLast = last - secondLast;
        }
        return last + secondLast;
    }

    /**
     * return a list of the n first fibonacci number
     *
     * @param n is the length of the fibonacci sequence you want to return
     * @return a list of Integers in the fibonacci sequence of length n
     */
    public static List<Integer> findFibSequence(int n) {
        List<Integer> fibList = new ArrayList<>(n);
        int last = 1;
        int secondLast = 0;
        for (int i = 1; i < n; i++) {
            fibList.add(last + secondLast);
            last = last + secondLast;
            secondLast = last - secondLast;
        }
        return fibList;
    }

    private static void printIntList(List<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.print(integer + " ");
        }
    }
}
