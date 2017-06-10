package sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This class is responsible for radix sorting deques of non-negative Integers
 */
class RadixSorter {

    /**
     * Sorts a deque of non-negative Integers using the Radix Sort algorithm
     *
     * @param deque     that contains the Integers to be sorted
     * @param maxDigits is the max amount of digits in the numbers you are sorting
     * @return deque that has been sorted
     */
    static Deque<Integer> radixSort(Deque<Integer> deque, int maxDigits) {

		/* CONSTRUCT ARRAY OF BUCKETS */
        Deque<Integer>[] buckets = new Deque[10];

		/* CREATE THE BUCKETS and put them in bucket array. */
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayDeque<>();

		/* RADIX SORT UP TO A SET AMOUNT OF DIGITS */
        int currentDigitBeingSorted = 1; // decides is we sort the 1s, the 10s, the 100s or the 1000s, etc.
        for (int i = 0; i < maxDigits; i++) {

			/* CLEAR THE BUCKETS FOR NEXT ITERATION */
            for (Deque<Integer> bucket : buckets)
                //if (bucket != null)
                bucket.clear();

			/* Grab lectures from the front of the deque and place it into the bucket depending on the value of it's relevant digit */
            Integer element = deque.pollFirst();
            while (element != null) {
                int sortingDigit = (element / currentDigitBeingSorted) % 10; //retrieves the digit that the number is to be sorted by this iteration
                buckets[sortingDigit].addLast(element);
                //	buckets[(element/currentDigitBeingSorted)%10].addLast(element); //the same as above but in compact form
                element = deque.pollFirst();
            }
            currentDigitBeingSorted *= 10; // move up to the next digit towards the left

			/* Place contents of bucket[0], bucket[1], . . . , bucket[9] back into the deque */
            for (int j = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    deque.addLast(buckets[j].pollFirst());
                }
            }
        } // end of the sorting process loop
        return deque;
    } //end radix sort
}
