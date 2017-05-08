import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olve on 08.05.2017.
 */
public class PrimeFactorFinder {
    public static void main(String[] args) {

    } // end main

    public static List<Integer> PrimeFactorize(int number){

        Integer factor = getLowestPrimeFactor(number);
        if(factor != number) {
            List<Integer> primeFactorList = PrimeFactorize(number / factor);
            primeFactorList.add(factor);
            return primeFactorList;
        } else {
            List<Integer> primeFactorList = new ArrayList<Integer>(5);
            primeFactorList.add(factor);
            return primeFactorList;
        }
    }

    /**
     *
     * @param number is an integer you wish to find the smallest prime factor of
     * @return -1 if no prime factor is found. Otherwise returns the lowest prime factor of the input.
     */
    private static Integer getLowestPrimeFactor(int number) {
        List<Integer> primes = getPrimesBelow(number);
        for (Integer primeFactor : primes){
            if(number/primeFactor == 0){
                return primeFactor;
            }
        }
        return -1;
    }

    private static List<Integer> getPrimesBelow(int roof) {
        List<Integer> primeList = new ArrayList<>(3);
        for (int i = 2; i <= roof; i++) {
            primeList.add(i);
        }
        for (int i = 0; i < roof; i++) {
            if (primeList.contains((Integer)i)){
                for (int j = i*2; j < roof; j+=j) {
                    primeList.remove((Integer) j);
                }
            }
        }
        return null;
    }

} // end PrimeFactorFinder
