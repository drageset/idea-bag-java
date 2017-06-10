import primes.PrimeFactorFinder;

import java.util.List;

/**
 * Created by Olve on 09.05.2017.
 */
public class PrimeFactorFinderTest {
//    @org.junit.Test
//    public void primeFactorize() throws Exception {
//    }
    @org.junit.Test
    public void sieveOfEratosthenesTest() throws Exception {
        List<Integer> primelist = PrimeFactorFinder.sieveOfEratosthenes(100);
        for (Integer integer : primelist) {
            assert PrimeFactorFinder.isPrime(integer);
            System.out.println(integer);
        }
    }

    @org.junit.Test
    public void lowestPrimeFactorTest() throws Exception {
        int number = 10;
        Integer factor = PrimeFactorFinder.getLowestPrimeFactor(number);
        System.out.println("The lowest prime factor of " + number + " is " + factor);
    }

}