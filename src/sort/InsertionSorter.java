package sort;

/**
 * Sorts an array by insertion sort at O(n^2)
 * @author drageset
 */
class InsertionSorter {
    /**
     * Iterative implementation of insertion sort
     * @param array
     * @param <T>
     * @return
     */
    static <T extends Comparable<? super T>> T[] insertionSort(T[] array){
        int lastSortedIndex = 0; //a sub array of one item is always sorted
        T elem;
        for (int i = lastSortedIndex+1; i < array.length; i++) {
            elem = array[i]; //grab the item that is next to the sorted sub array
            for (int j = lastSortedIndex; j >= 0; j--) {
                if (array[j].compareTo(elem) > 0) { //if the next item on the left is larger than your unsorted item
                    array[j + 1] = array[j]; //move larger item one place to the right
                } else { // when your unsorted item is larger than the next sorted element
                    array[j + 1] = elem; //leave the element in the open slot
                    break; //grab a new unsorted element
                }
                if (j == 0){ //If your element is so small that you hit the end of the array
                    array[j] = elem; //leave your element there
                }
            }
            lastSortedIndex++; //we have now sorted one more item of the array
        }
        return array;
    }

    /**
     * Less effective way, where the element is moved one slot at a time instead
     * @param array
     * @param <T>
     * @return
     */
    static <T extends Comparable<? super T>> T[] insertionSort2(T[] array){
        int lastSortedIndex = 0;
        for (int i = lastSortedIndex+1; i < array.length; i++) {
            for (int j = lastSortedIndex; j >= 0; j--) {
                if (array[j].compareTo(array[j+1]) > 0) {
                    T switcher = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = switcher;
                } else {
                    break;
                }
            }
            lastSortedIndex++;
        }
        return array;
    }
}
