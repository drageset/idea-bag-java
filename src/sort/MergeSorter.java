package sort;

/**
 * This class is responsible for methods pertaining to Merge Sorting
 * @author drageset
 */
class MergeSorter {

    /**
     * This is the main recursive method for merge sorting an array of any comparable type
     *
     * @param array is the actual array that is to be sorted, of any type of comparable
     * @param tempArray is a temporary array of the same size and type as the original array
     * @param firstIndex is the index of the first item in the array that is to be sorted
     * @param lastIndex is the index of the last item in the array that is to be sorted
     * @param <T> is a comparable type
     * @return a sorted array of type T
     */
    static <T extends Comparable<? super T>> T[] recursiveMergeSort(T[] array, T[] tempArray, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middle = (lastIndex + firstIndex) / 2;
            recursiveMergeSort(array, tempArray, firstIndex, middle);
            recursiveMergeSort(array, tempArray, middle + 1, lastIndex);
            merge(array, tempArray, firstIndex, middle, lastIndex);
        }
        return array;
    }

    /**
     * This method merges two sorted adjacent sub arrays into one sorted sub array
     *
     * @param array is the array in which the two adjacent sorted sub arrays are located
     * @param tempArray is a temporary array of equal size as the main array, that is used in the process
     * @param firstIndex is the first item in the first sub array
     * @param middleIndex is the last item in the first sub array
     * @param lastIndex is the last item in the second sub array
     * @param <T> is the comparable type of the array items
     */
    private static <T extends Comparable<? super T>> void merge(T[] array, T[] tempArray, int firstIndex, int middleIndex, int lastIndex) {
        int mergedIndex = 0;
        int i = firstIndex;
        int j = middleIndex + 1;
        while (i <= middleIndex && j <= lastIndex) {
            T leftItem = array[i];
            T rightItem = array[j];

            if (leftItem.compareTo(rightItem) <= 0) {
                tempArray[mergedIndex] = leftItem;
                i++;
            } else {
                tempArray[mergedIndex] = rightItem;
                j++;
            }
            mergedIndex++;
        }
        //copy remaining entries from other sub-array to tempArray
        while (i <= middleIndex) {
            tempArray[mergedIndex] = array[i];
            i++;
            mergedIndex++;
        }
        while (j <= lastIndex) {
            tempArray[mergedIndex] = array[j];
            j++;
            mergedIndex++;
        }
        //copy entries from tempArray to array
        for (int l = 0; l < mergedIndex; l++) {
            array[firstIndex + l] = tempArray[l];
        }

    } //end merge

} //end class
