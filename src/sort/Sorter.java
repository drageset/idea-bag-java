package sort;

import java.util.Arrays;
import java.util.Deque;

/**
 * This class lets the user access the functionality of all the sorting classes in the sort package
 * as simply as possible.
 * @author drageset
 */
public class Sorter {

    public enum RecursiveOrIterative {
        RECURSIVE, ITERATIVE
    }

    /**
     * Radix sorts a deque of Integers with a specified max length.
     * Time complexity of Radix sort is proportional to k*n,
     * where k is max length of integers, and n is amount of integers.
     *
     * @param deque that is to be radix sorted.
     * @param maxLength of the integers in the deque.
     * @return a sorted deque.
     */
    public static Deque<Integer> radixSort(Deque<Integer> deque, int maxLength){
        return RadixSorter.radixSort(deque, maxLength);
    }

    /**
     * Merge sorts arrays of any type, time complexity O(n log(n))
     *
     * @param array of any type
     * @return a sorted array of same type as input
     */
    public static <T extends Comparable<? super T>> T[] mergeSort(T[] array) {
        T[] tempArray = Arrays.copyOf(array, array.length);
        return MergeSorter.recursiveMergeSort(array, tempArray, 0, array.length - 1);
    }

    /**
     * Bubble sort arrays of any type, time complexity O(n^2)
     *
     * @param array         of any type that you want to have sorted
     * @param specification of if you want to use the RECURSIVE or ITERATIVE bubble sort.
     * @return A sorted array of same type as the one you sent in, null if something goes wrong with your selection of RECURSIVE or ITERATIVE
     */
    public static <T extends Comparable<? super T>> T[] bubbleSort(T[] array, RecursiveOrIterative specification) {
        switch (specification) {
            case RECURSIVE:
                return BubbleSorter.recursiveBubbleSort(array, 0, array.length - 1);
            case ITERATIVE:
                return BubbleSorter.iterativeBubbleSort(array);
            default:
                return null;
        }
    }

    /**
     * Default Bubble Sort of any type array, uses the iterative implementation of Bubble Sort.
     * This method is overloaded,
     * the other implementation allows you to specify whether to use the recursive or the iterative implementation
     *
     * @param array of any type you want to have sorted
     * @return a sorted array of same type you gave it, with time complexity O(n^2)
     */
    public static <T extends Comparable<? super T>> T[] bubbleSort(T[] array) {
        return BubbleSorter.iterativeBubbleSort(array);
    }
}
