public class recursiveMethods<T> {
    private int[] a;
    private int[] tempArray;
    private int first;
    private int last;
    
    /**
        SELECTIVE SORT
    */
    
    public static int[] selectiveSort(int[] a, int[] tempArray, int first, int last) {
        // selectiveSort
    }
    
    /**
        INSERTION SORT
    */
    
    public static int[] insertionSort(int[] a, int[] tempArray, int first, int last) {
        // insertionSort
    }
    
    /**
        SHELL SORT
    */
    
    public static int[] shellSort(int[] a, int[] tempArray, int first, int last) {
        // shellSort
    }
    
    /**
        MERGE SORT
    */
    
    public static int[] mergeSort(int[] a, int[] tempArray, int first, int last) {
        // mergeSort
        int mid;
        // sort array entries a[first] through a[last] recursively.
        if (first < last) {
            mid = ((first + last)/2) + 1;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid+1, last);
            // merge the sorted halves
            merge(a, tempArray, first, last);
        }
    }
    public int[] merge(int[] a, int[] tempArray, int first, int last) {
        // merges adjacent subarrays that have been sorted
        beginHalf1 = first;
        endHalf1 = mid;
        beginHalf2 = mid+1;
        endHalf2 = last;
        /** While both subarrays are not empty, compare an entry in one subarray
        with an entry in the other subarray. Then copy the smaller item into
        the tempArray */
        int index = 0;
        while ( (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2) ) {
            if (a[beginHalf1] <= a[beginHalf2]) {
                tempArray[index] = a[beginHalf1];
                beginHalf1++;
            }
            else {
                tempArray[index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        // now do the other subarray
        while ( (
    }
    
    /**
        QUICK SORT
    */
    
    public void sort(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return;
        }
        this.a = inputArray;
        length = inputArray.length;
        quickSort(0, length-1);
    }
    public static int[] quickSort(int first, int last) {
        // quickSort
        int i = first;
        int j = last;
        // calculate pivot number
        int pivot = ((first + last)/2) + 1;
        // Make 2 subarrays
        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (first < j)
            quickSort(first, j);
        if (i < last)
            quickSort(i, last);
    }
    public void exchangeNumbers(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    /**
        RADIX SORT
    */
    
    public static int[] radixSort(int[] a, int[] tempArray, int first, int last) {
        // radixSort
    }