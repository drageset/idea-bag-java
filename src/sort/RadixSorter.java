package sort;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class is responsible for radix sorting queues of non-negative Integers
 * @author drageset
 */
class RadixSorter {

    /**
     * Sorts a queue of non-negative Integers using the Radix Sort algorithm
     *
     * @param queue     that contains the Integers to be sorted
     * @param maxDigits is the max amount of digits in the numbers you are sorting
     * @return deque that has been sorted
     */
    static Queue<Integer> radixSort(Queue<Integer> queue, int maxDigits) {

		/* CONSTRUCT ARRAY OF BUCKETS */
        Queue<Integer>[] buckets = new Queue[10];

		/* CREATE THE BUCKETS and put them in bucket array. */
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayDeque<>();

		/* RADIX SORT UP TO A SET AMOUNT OF DIGITS */
        int currentDigitBeingSorted = 1; // decides is we sort the 1s, the 10s, the 100s or the 1000s, etc.
        for (int i = 0; i < maxDigits; i++) {
			/* CLEAR THE BUCKETS FOR NEXT ITERATION */
            for (Queue<Integer> bucket : buckets)
                bucket.clear();

			/* Grab lectures from the front of the deque and place it into the bucket depending on the value of it's relevant digit */
            Integer element = queue.poll();
            while (element != null) {
                int sortingDigit = (element / currentDigitBeingSorted) % 10; //retrieves the digit that the number is to be sorted by this iteration
                buckets[sortingDigit].add(element);
                //	buckets[(element/currentDigitBeingSorted)%10].add(element); //the same as above but in compact form
                element = queue.poll();
            }
            currentDigitBeingSorted *= 10; // move up to the next digit towards the left

			/* Place contents of bucket[0], bucket[1], . . . , bucket[9] back into the deque */
            for (int j = 0; j < buckets.length; j++) {
                while (!buckets[j].isEmpty()) {
                    queue.add(buckets[j].poll());
                }
            }
        } // end of the sorting process loop
        return queue;
    } //end radix sort
}
