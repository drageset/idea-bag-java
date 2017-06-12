import primes.PrimeFactorFinder;
import primes.PrimeFinder;

import java.util.List;

/**
 * Test class for the prime package
 * @author drageset
 */
public class PrimeTest {
//    @org.junit.Test
//    public void primeFactorize() throws Exception {
//    }
    @org.junit.Test
    public void sieveOfEratosthenesTest() throws Exception {
        List<Integer> primelist = PrimeFinder.sieveOfEratosthenes(100);
        for (Integer integer : primelist) {
            System.out.println(integer);
            assert PrimeFinder.isPrime(integer);
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