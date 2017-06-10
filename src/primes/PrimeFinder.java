package primes;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is for finding prime numbers
 * @author drageset
 */
public class PrimeFinder {

    /**
     * A method implementation of an ancient algorithm for finding every prime under a certain number.
     *
     * @param roof is the limit under which we will find all primes
     * @return all primes under the roof
     */
    public static List<Integer> sieveOfEratosthenes(int roof) {
        List<Integer> primeList = new ArrayList<>(3);
        for (int i = 2; i < roof; i++) {
            primeList.add(i);
        }
        for (int i = 2; i < roof; i++) {
            if (primeList.contains(i)) {
                for (int j = i * 2; j < roof; j += i) {
                    if (primeList.contains(j)) {
                        primeList.remove((Integer) j);
                    }
                }
            }
        }
        return primeList;
    }

    /**
     * This method checks whether a positiveInteger is prime or not
     *
     * @param positiveInteger to check if is prime or not
     * @return true if prime, false if not
     */
    public static boolean isPrime(int positiveInteger) {
        if (positiveInteger < 2 || positiveInteger%2 == 0) {
            return false;
        }
        double sqrtOfInteger = Math.sqrt(positiveInteger);
        boolean prime = true;
        double rest;
        for (int i = 3; i < sqrtOfInteger; i += 2) { // test that all the numbers are prime numbers
            rest = positiveInteger % i;
            if (rest == 0) { //if a number has 0 rest after division with any other number than itself or 1, it is not prime
                prime = false;
            }
        }
        return prime;
    }

    /**
     * Method for finding the next prime after the input
     *
     * @param number is the input for which we wil find the next prime
     * @return the next prime larger than the input number
     */
    public static int nextPrime(int number) {

        if (number <= 2){
            return 2;
        }
        if (number %2 == 0){
            number++;
        }
        while (!isPrimeNonEven(number)){
            number += 2;
        }
        return number;

    }

    /**
     * Private method used by nextPrime to check if a an odd number (3 or larger) is prime.
     *
     * @param positiveOddInteger should be odd, 3 or larger.
     * @return false if the number in a non-prime odd.
     */
    private static boolean isPrimeNonEven(int positiveOddInteger) {
        boolean prime = true;
        double sqrtOfInteger = Math.sqrt(positiveOddInteger); //no number is divisible only by a number larger than its sqrt
        double rest;
        for (int i = 3; i < sqrtOfInteger; i += 2) { // checks if the input is divisible by any odd number less than its sqrt
            rest = positiveOddInteger % i;
            if (rest == 0) { //if a number has 0 rest after division with any other number than itself or 1, it is not prime
                prime = false;
            }
        }
        return prime;
    }
}
