package sort;

/**
 * Sort an array by selection sort, at O(n^2)
 * @author drageset
 */
class SelectionSorter {

    static <T extends Comparable<? super T>> T[] selectionSort(T[] array){
        int minimalItemIndex;
        T switcher;
        for (int i = 0; i < array.length; i++) {
            minimalItemIndex = i;
            for (int j = i; j < array.length; j++) { //find the smallest unsorted item
                if (array[j].compareTo(array[minimalItemIndex]) < 0){
                    minimalItemIndex = j;
                }
            }
            //put the smallest unsorted item at the end of the sorted part of the array
            switcher = array[minimalItemIndex];
            array[minimalItemIndex] = array[i];
            array[i] = switcher;
        }
        return array;
    }
}
