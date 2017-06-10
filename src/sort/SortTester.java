package sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is responsible for the handling of unit tests for the sort package
 */
class SortTester {

    @Test
    public void recursiveRadixSortTest() {
        Integer[] array = {7, 3, 123, 5, 99, 1, 8, 6, 2, 4};
        Deque<Integer> integerDeque = new ArrayDeque<>(10);
        for (Integer integer : array) {
            integerDeque.add(integer);
        }
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 99, 123};
        Integer[] actual = RadixSorter.radixSort(integerDeque, 3).toArray(array);
        System.out.println("Radix sorted actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void recursiveMergeSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] temp = new Integer[10];
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = MergeSorter.recursiveMergeSort(array, temp, 0, array.length - 1);
        System.out.println("Recursive Merge Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void recursiveBubbleSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = BubbleSorter.recursiveBubbleSort(array, 0, array.length - 1);
        System.out.println("Recursive Bubble Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void iterativeBubbleSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = BubbleSorter.iterativeBubbleSort(array);
        System.out.println("Iterative Bubble Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");

        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

}
