package sort;

/**
 * Sorts an array by insertion sort, which is not particularly effective O(n^2), but more effective than selection sort
 */
class InsertionSorter {

    static <T extends Comparable<? super T>> T[] insertionSort(T[] array){
        int lastSortedIndex = 0;
        for (int i = 1; i < array.length; i++) {
            T element = array[i];
            for (int j = i-1; j > 0; j--) {
                if (array[j].compareTo(element) > 0) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = element;
                    break;
                }
            }
        }
        return array;
    }
}
