package primes;

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
     *
     * @param number is the positive integer you want to find the prime factors of
     * @return a List of Integers containing the prime factors of the number input
     */
    public static List<Integer> PrimeFactorize(int number) {
        if (!PrimeFinder.isPrime(number)) {
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
     *
     * @param number is an integer you wish to find the smallest prime factor of
     * @return -1 if no prime factor is found. Otherwise returns the lowest prime factor of the input.
     */
    public static Integer getLowestPrimeFactor(int number) {
        List<Integer> primes = PrimeFinder.sieveOfEratosthenes(number);
        for (Integer primeFactor : primes) {
            if (number % primeFactor == 0) {
                return primeFactor;
            }
        }
        return -1;
    }



} // end primes.PrimeFactorFinder
