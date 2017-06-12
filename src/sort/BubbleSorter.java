package sort;

/**
 * This class is responsible for methods pertaining to Bubble Sorting, a very ineffective O(n^2) algo
 * @author drageset
 */
class BubbleSorter {

    /**
     * Iterative implementation of Bubble Sort on any type of array. O(n^2) time complexity
     *
     * @param array that you wish to sort, of any type
     * @return sorted array with same elements
     */
    static <T extends Comparable<? super T>> T[] iterativeBubbleSort(T[] array) {
        for (int j = 0; j < array.length; j++)
            for (int i = 0; i < array.length - 1; i++) {
                T thisT = array[i];
                T nextT = array[i + 1];
                if (thisT.compareTo(nextT) > 0) {
                    T temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }
        return array;
    }

    /**
     * Recursive implementation of Bubble Sort on any type of array. O(n^2) time complexity
     *
     * @param array      that you wish to sort, of any type
     * @param firstIndex of the array, so 0 to start with
     * @param lastIndex  of the array, so array.length-1 to start with
     * @return sorted array with the same elements
     */
    static <T extends Comparable<? super T>> T[] recursiveBubbleSort(T[] array, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            recursiveBubbleSort(array, 0, lastIndex - 1);
        } else if (firstIndex < lastIndex) {
            T head = array[firstIndex];
            T next = array[firstIndex + 1];
            if (head.compareTo(next) > 0) {
                T temp = next;
                array[firstIndex + 1] = head;
                array[firstIndex] = temp;
            }
            recursiveBubbleSort(array, firstIndex + 1, lastIndex);
        }
        return array;
    }

}
