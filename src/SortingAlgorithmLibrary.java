

public class SortingAlgorithmLibrary {
    //create randomized array, sorted array, and stores for last sorting alg used
    public int[] randomArray;
    public int[] sortingArray;
    public String lastSortUsed;
    public String[] sortName = {"Insertion Sort","Heap Sort", "Merge Sort", "quickSort"};
    //>>>>>>>>>>>>>

    //Algorithm times in ns
    public double insertionSortTime;
    public double heapSortTime;
    public double mergeSortTime;
    public double quickSortTime;
    //>>>>>>>>>>>>>

    //COUNTERS
        //insertion sort counters
    public double insertionSortSwapCounter;
    public double insertionSortCompCounter;

        //heap sort counters
    public double heapSortSwapCounter;
    public double heapSortCompCounter;

        //merge sort counters
    public double mergeSortArrayCounter;
    public double mergeSortCompCounter;
    public double mergeSortSwapCounter;

        //quick sort counters
    public double quickSortSwapCounter;
    public double quickSortCompCounter;
    //>>>>>>>>>>>>>

    public SortingAlgorithmLibrary(int[] randomArray){
        this.randomArray=randomArray;
    }

    public void insertionSort(){
        lastSortUsed=sortName[0];
        sortingArray = randomArray.clone();

        insertionSortTime = System.nanoTime(); //startTime

        int n = sortingArray.length;
        for (int i = 1; i < n; ++i) {
            int key = sortingArray[i];
            int j = i - 1;

            /* Move elements of arr[0...i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && sortingArray[j] > key) {
                sortingArray[j + 1] = sortingArray[j];
                j = j - 1;
                insertionSortCompCounter+=1;
                insertionSortSwapCounter+=1;
            }
            sortingArray[j + 1] = key;
            insertionSortSwapCounter+=1;
        }

        insertionSortTime = System.nanoTime()-insertionSortTime; //endTime
    }

    public void heapSort(){
        lastSortUsed=sortName[1];
        sortingArray=randomArray.clone();

        heapSortTime = System.nanoTime(); //startTime

        //create heap using custom class
        MyHeap myHeap = new MyHeap(sortingArray);

        //remove max n-1 times
        for (int i = sortingArray.length - 1; i > 0; i--) {
            myHeap.removeMax(i); //puts removed element to the back of the array

        }
        heapSortSwapCounter = myHeap.swapCounter;
        heapSortCompCounter=myHeap.compCounter;

        heapSortTime = System.nanoTime()-heapSortTime; //endTime
    }
    public void mergeSort(){
        sortingArray = randomArray.clone();

        lastSortUsed=sortName[2];

        mergeSortTime= System.nanoTime();//startTime
        mergeSort(0,sortingArray.length-1);
        mergeSortTime= System.nanoTime()-mergeSortTime;//endTime
    }
    public void mergeSortAfterInsertionSort(){
        sortingArray = randomArray.clone();
        insertionSort();

        lastSortUsed=sortName[2];
        mergeSortTime= System.nanoTime();//startTime
        mergeSort();
        mergeSortTime= System.nanoTime()-mergeSortTime;//endTime
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void mergeSort(int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(l, m);
            mergeSort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }

    public void merge( int l, int m, int r)
    {
        // Find sizes of two sub arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = sortingArray[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = sortingArray[m + 1 + j];

        // Merge the temp arrays

        mergeSortArrayCounter+=2;

        // Initial indices of first and second sub arrays
        int i = 0, j = 0;

        // Initial index of merged sub array
        int k = l;
        while (i < n1 && j < n2) {
            mergeSortCompCounter+=1;
            if (L[i] <= R[j]) {
                sortingArray[k] = L[i];
                i++;
                mergeSortSwapCounter+=1;
            }
            else {
                sortingArray[k] = R[j]; // if (3,2,6)(1,4,5) say L[0] >R[0] then choose R[0] for that spot {kinda like swappinh w/ L[0] then placing it where L[0] used to sit on main arr}
                j++;
                mergeSortSwapCounter+=1;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            sortingArray[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            sortingArray[k] = R[j];
            j++;
            k++;
        }
    }


    public void quickSort(){
        lastSortUsed=sortName[3];
        sortingArray=randomArray.clone();

        quickSortTime = System.nanoTime();
        quickSort(this.sortingArray,0,sortingArray.length-1);
        quickSortTime = System.nanoTime()-quickSortTime;
    }

    public void quickSortAfterInsertionSort(){
        lastSortUsed=sortName[3];
        sortingArray=randomArray.clone();
        insertionSort();

        quickSortTime = System.nanoTime();
        quickSort(this.sortingArray,0,sortingArray.length-1);
        quickSortTime = System.nanoTime()-quickSortTime;
    }

    public void quickSort(int[] A, int low, int high){
        // If low is lesser than high
        if (low < high) {
            // idx is index of pivot element which is at its
            // sorted position
            int idx = partition(A, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(A, low, idx - 1);
            quickSort(A, idx + 1, high);
        }
    }

    private int partition(int[] A, int low, int high) {
        // First element as pivot
        int pivot = A[low];
        int k = high;// end points to the ending of the array
        for (int i = high; i > low; i--) {
            quickSortCompCounter+=1;
            if (A[i] > pivot){
                swap(A, i, k--);
            }

        }
        swap(A, low, k);

        // As we got pivot element index is end
        // now pivot element is at its sorted position
        // return pivot element index (end)
        return k;
    }

    // Function to swap two elements
    private void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        quickSortSwapCounter+=1;
    }


}
