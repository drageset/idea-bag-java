package sort;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is responsible for the handling of unit tests for the sort package
 * @author drageset
 */
public class SortTester {

    @Test
    public void RadixSortTest() {
        Integer[] array = {7, 3, 123, 5, 95, 1, 8, 6, 2, 4};
        Deque<Integer> integerDeque = new ArrayDeque<>(10);
        for (Integer integer : array) {
            integerDeque.add(integer);
        }
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 95, 123};
        Integer[] actual = Sorter.radixSort(integerDeque, 3).toArray(array);
        System.out.println("Radix sorted actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    /**
     * testing and printing time usage of both sorting and planning individually
     */
    @Test
    public void radixTimeUsageTest() {
        int maxLength = 5;
        int upperBound = (int) Math.pow(10, maxLength);
        int numOfElements = 100;
        int numOfIterations = 100000;
        double totalTime = 0;
        double averageTime;

        for (int i = 0; i < numOfIterations; i++) {
            Queue<Integer> integerQueue = new ArrayDeque<>();
            for (int j = 0; j < numOfElements; j++) {
                int number = (int) (Math.random() * upperBound);
                integerQueue.add(number);
            }
            long startTime = System.nanoTime();
            Queue<Integer> sorted = Sorter.radixSort(integerQueue, maxLength);
            long endTime = System.nanoTime();
            long sortTime = endTime - startTime;
            System.out.println(sortTime + " nanosecs to sort " + numOfElements + " elements");
            totalTime += sortTime;
        }
        averageTime = totalTime/numOfIterations;
        System.out.println("Radix sort AVG time: " + averageTime/1000 + " millis average. " + numOfIterations + " iterations. " + numOfElements + " elements. " + upperBound + " upperBound.");
        assert true;
    }

    @Test
    public void recursiveMergeSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = Sorter.mergeSort(array);
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
        Integer[] actual = Sorter.bubbleSort(array, Sorter.RecursiveOrIterative.RECURSIVE);
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
        Integer[] actual = Sorter.bubbleSort(array, Sorter.RecursiveOrIterative.ITERATIVE);
        System.out.println("Iterative Bubble Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");

        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void insertionSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = Sorter.insertionSort(array);
        System.out.println("Insertion Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void insertionSort2Test() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = InsertionSorter.insertionSort2(array);
        System.out.println("Insertion Sort 2 actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

    @Test
    public void selectionSortTest() {
        Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
        Integer[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actual = Sorter.selectionSort(array);
        System.out.println("Selection Sort actual: ");
        for (int i = 0; i < expected.length; i++) {
            System.out.print(actual[i] + " ");

        }
        System.out.println();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }

    }

}
