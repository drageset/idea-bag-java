package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is responsible for the handeling of unit tests for the sort package
 */
class SortTester {

	@Test
	public void recursiveMergeSortTest() {
		Integer[] array = 		{7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
		Integer[] temp 	=		new Integer[10];
		Integer[] expected = 	{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer[] actual = MergeSorter.recursiveMergeSort(array, temp, 0, array.length-1);
		for(int i = 0; i < expected.length; i++){
			System.out.println("recmerge " + actual[i]);
		}
		for(int i = 0; i < expected.length; i++){
			assertEquals(expected[i], actual[i]);
		}

	}

	@Test
	public void recursiveBubbleSortTest() {
		Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
		Integer[] expected = {0,1,2,3,4,5,6,7,8,9};
		Integer[] actual = BubbleSorter.recursiveBubbleSort(array, 0, array.length-1);
		for(int i = 0; i < expected.length; i++){
			System.out.println("recbubble " + actual[i]);
		}
		for(int i = 0; i < expected.length; i++){
			assertEquals(expected[i], actual[i]);
		}

	}

	@Test
	public void iterativeBubbleSortTest() {
		Integer[] array = {7, 3, 9, 5, 0, 1, 8, 6, 2, 4};
		Integer[] expected = {0,1,2,3,4,5,6,7,8,9};
		Integer[] actual = BubbleSorter.iterativeBubbleSort(array);
		for(int i = 0; i < expected.length; i++){
			System.out.println("itbubble " +actual[i]);
		}
		for(int i = 0; i < expected.length; i++){
			assertEquals(expected[i], actual[i]);
		}

	}

}
