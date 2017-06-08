package sort;

import java.lang.reflect.Array;

/**
 * This class is responsible for methods pertaining to Merge Sorting
 */
class MergeSorter {

    static <T extends Comparable<? super T>> T[] recursiveMergeSort(T[] array, T[] tempArray, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int middle = (lastIndex + firstIndex) / 2;
            recursiveMergeSort(array, tempArray, firstIndex, middle);
            recursiveMergeSort(array, tempArray, middle + 1, lastIndex);
            merge(array, tempArray, firstIndex, middle, lastIndex);
        }
        return array;
    }

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
        //copy remaining entries from other subarray to tempArray
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

    }

    /**
     * Concatenate two arrays of the same type
     *
     * @param a the first array you wish to concatenate to the beginning of the second
     * @param b the second array you wish to concatenate to the end of the first
     * @return an array containing exactly a concatenated to b.
     */
    private static <T> T[] concatenate(T[] a, T[] b) {
        int aLen = a.length;
        int bLen = b.length;

        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }

}
