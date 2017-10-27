public class iterativeMethods<T> {
    private int[] a;
    private int length;
    
    /**
        SELECTIVE SORT
    */
    
    public static int[] selectiveSort(int[] a, int[] tempArray, int first, int last) {
        // selectiveSort
    }
    
    /**
        INSERTION SORT
    */
    
    public static int[] insertionSort(int[] a) {
        // insertionSort
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j > 0; j--) {
                if (a[j] < a[j-1]) {
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
        retun a;
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
        
    }
    
    /**
        QUICK SORT
    */
    
    public static int[] quickSort(int[] a, int[] tempArray, int first, int last) {
        // quickSort
    }
    
    /**
        RADIX SORT
    */
    
    public static int[] radixSort(int[] a, int[] tempArray, int first, int last) {
        // radixSort
    }