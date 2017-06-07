import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class finds prime factors of positive integers
 */
public class PrimeFactorFinder {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a positive integer to factorize:");
        try {
            int input = Integer.parseInt(br.readLine());
            List<Integer> primeFactors = PrimeFactorize(input);
            System.out.println("Prime factors of " + input + ":");
            for (Integer primeFactor : primeFactors) {
                System.out.print(primeFactor + " ");
            }
        } catch (IOException e) {
            System.out.println("ERROR: Input not an integer.");
            e.printStackTrace();
        }
    } // end main

    /**
     * A recursive method for finding the prime factors of a positive integer
     * @param number is the positive integer you want to find the prime factors of
     * @return a List of Integers containing the prime factors of the number input
     */
    public static List<Integer> PrimeFactorize(int number){
        if(!isPrime(number)) {
            Integer factor = getLowestPrimeFactor(number);
            List<Integer> primeFactorList = PrimeFactorize(number / factor);
            primeFactorList.add(factor);
            return primeFactorList;
        } else {
            List<Integer> primeFactorList = new ArrayList<Integer>(5);
            primeFactorList.add(number);
            return primeFactorList;
        }
    }

    /**
     * A method for finding the lowest prime factor of a positive integer.
     * @param number is an integer you wish to find the smallest prime factor of
     * @return -1 if no prime factor is found. Otherwise returns the lowest prime factor of the input.
     */
    public static Integer getLowestPrimeFactor(int number) {
        List<Integer> primes = sieveOfEratosthenes(number);
        for (Integer primeFactor : primes){
            if(number%primeFactor == 0){
                return primeFactor;
            }
        }
        return -1;
    }

    /**
     * A method implementation of an ancient algorithm for finding every prime under a certain number.
     * @param roof is the limit under which we will find all primes
     * @return all primes under the roof
     */
    public static List<Integer> sieveOfEratosthenes(int roof) {
        List<Integer> primeList = new ArrayList<>(3);
        for (int i = 2; i < roof; i++) {
            primeList.add(i);
        }
        for (int i = 2; i < roof; i++) {
            if (primeList.contains(i)){
                for (int j = i*2; j < roof; j += i) {
                    if(primeList.contains(j)) {
                        primeList.remove((Integer)j);
                    }
                }
            }
        }
        return primeList;
    }

    /**
     * This method checks whether a number is prime or not
     * @param integer to check if is prime or not
     * @return true if prime, false if not
     */
     public static boolean isPrime(int integer){
        boolean prime = true;
         for (int i = 2; i < integer; i++) { // test that all the numbers are prime numbers
             double rest = integer%i;
             if(rest == 0) { //if a number has 0 rest after division with any other number than itself or 1, it is not prime
                 prime = false;
             }
         }
         return prime;
     }

} // end PrimeFactorFinder
