package sort;

import java.util.Arrays;

public class Sorter {

	public static enum RecursiveOrIterative {
		RECURSIVE, ITERATIVE
	}
	
	/**
	 * Merge Sorts arrays of any type in time complexity O(n log(n))
	 * @param array of any type
	 * @return a sorted array of same type as input
	 */
	public static <T extends Comparable<? super T>> T[] mergeSort(T[] array){
		T[] tempArray = Arrays.copyOf(array, array.length);
		return MergeSorter.recursiveMergeSort(array, tempArray, 0, array.length-1);
	}

	/**
	 * Bubble Sort your array of any type
	 * @param array of any type that you want to have sorted
	 * @param specification of if you want to use the RECURSIVE or ITERERATIVE bubble sort.
	 * @return A sorted array of same type as the one you sent in, null if something goes wrong with your selection of RECURSIVE or ITERATIVE
	 */
	public static <T extends Comparable<? super T>> T[] bubbleSort(T[] array, RecursiveOrIterative specification){
		switch (specification) {
		case RECURSIVE:
			return BubbleSorter.recursiveBubbleSort(array, 0, array.length-1);
		case ITERATIVE:
			return BubbleSorter.iterativeBubbleSort(array);
		default:
			return null;
		}
	}
	
	/**
	 * Default Bubble Sort of any type array, uses the iterative implementation of Bubble Sort
	 * This method is overloaded, the other implementation allows you to specify to use recursive implementation
	 * @param array of any type you want to have sorted
	 * @return a sorted array of same type you gave it, with time complexity O(n^2)
	 */
	public static <T extends Comparable<? super T>> T[] bubbleSort(T[] array){
		return BubbleSorter.iterativeBubbleSort(array);
	}
}
