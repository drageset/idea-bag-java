package sort;

/**
 * Sort an array by selection sort, which is not particularly effective, at O(n^2)
 */
class SelectionSorter {

    static <T extends Comparable<? super T>> T[] selectionSort(T[] array){
        int minimumIndex = 0;
        T switcher;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j].compareTo(array[minimumIndex]) < 0){
                    minimumIndex = j;
                }
            }
            switcher = array[minimumIndex];
            array[minimumIndex] = array[i];
            array[i] = switcher;
        }
        return array;
    }
}
