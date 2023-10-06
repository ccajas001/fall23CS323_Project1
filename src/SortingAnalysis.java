import java.util.Arrays;


/*
* Covers part {One} of Project
* */

public class SortingAnalysis extends SortingAlgorithmLibrary{

        public SortingAnalysis(int[] randomArray) {
            super(randomArray);
        }

        public double insertionSortAVG;
        public double heapSortAVG;
        public double mergeSortAVG;
        public double quickSortAVG;

        public double insertionSortSwapCounterAVG;
        public double insertionSortCompCounterAVG;

        public double heapSortSwapCounterAVG;
        public double heapSortCompCounterAVG;

        public double mergeSortArrayCounterAVG;
        public double mergeSortCompCounterAVG;

        public double quickSortSwapCounterAVG;
        public double quickSortCompCounterAVG;

        public void test(){

            insertionSort();


            System.out.println("using "+ lastSortUsed +
                    " takes "+ insertionSortTime +" ns OR " + insertionSortTime*0.000001 + " ms to sort"+
                    " >> sorted: " + Arrays.toString(sortingArray));


           /* */

            //merge sort test

            mergeSort();


           System.out.println("using "+ lastSortUsed +
                  " takes "+ mergeSortTime +" ns OR " + mergeSortTime*0.000001 + " ms to sort"+
                   " >> sorted: " + Arrays.toString(sortingArray));
            /**/

            mergeSortAfterInsertionSort();


            System.out.println("using "+ lastSortUsed +
                    " takes "+ mergeSortTime +" ns OR " + mergeSortTime*0.000001 + " ms to sort"+
                    " >> sorted: " + Arrays.toString(sortingArray));
            /**/

            //heap sort test
            heapSort();


            System.out.println("using "+ lastSortUsed +
                    " takes "+ heapSortTime +" ns OR " + heapSortTime*0.000001 + " ms to sort"+
                    " >> sorted: " + Arrays.toString(sortingArray));
            /**/

            //quick sort test

            quickSort();


            System.out.println("using "+ lastSortUsed +
                  " takes "+ quickSortTime +" ns OR " + quickSortTime*0.000001 + " ms to sort"+
                    " >> sorted: " + Arrays.toString(sortingArray));
           /* */

            quickSortAfterInsertionSort();


            System.out.println("using "+ lastSortUsed +
                    " takes "+ quickSortTime +" ns OR " + quickSortTime*0.000001 + " ms to sort"+
                    " >> sorted: " + Arrays.toString(sortingArray));
            /* */

        }

        public void testSetOf(int runs, int arraySize){

            for(int i=0; i<runs;i++){
               System.out.print(".");
                insertionSort();
                mergeSort();
                heapSort();
                quickSort();

               insertionSortAVG += insertionSortTime;
               mergeSortAVG+= mergeSortTime;
               heapSortAVG+= heapSortTime;
               quickSortAVG+=quickSortTime;

               heapSortSwapCounterAVG+=heapSortSwapCounter;
               heapSortCompCounterAVG+=heapSortCompCounter;

            }

            //official avgs
            insertionSortAVG/= runs;
            mergeSortAVG/=runs;
            heapSortAVG/=runs;
            quickSortAVG/=runs;


            //NUMBER OF SWAPS AVG
            insertionSortSwapCounterAVG=insertionSortSwapCounter/runs;
            heapSortSwapCounterAVG/=runs;
            quickSortSwapCounterAVG=quickSortSwapCounter/runs;

            ///NUMBER OF COMPARISONS AVG
            insertionSortCompCounterAVG=insertionSortCompCounter/runs;
            heapSortCompCounterAVG/=runs;
            mergeSortCompCounterAVG=mergeSortCompCounter/runs;
            quickSortCompCounterAVG=quickSortCompCounter/runs;

            //AVG # OF TEMP ARRAYS for merge sort
            mergeSortArrayCounterAVG=mergeSortArrayCounter/runs;


            System.out.println("\nFOR ARRAYS OF SIZE: " + arraySize);

            System.out.println("AVG TIMES (ms)");
            System.out.println("Insertion sort : " + insertionSortAVG*0.000001 + " ms");
            System.out.println("     Heap sort : "+ heapSortAVG*0.000001 + " ms");
            System.out.println("    Merge sort : "+ mergeSortAVG*0.000001 + " ms");
            System.out.println("    Quick sort : "+ quickSortAVG*0.000001 + " ms\n");

            System.out.println("AVG # of SWAPS for" + "\n"+
                    "   Insertion sort: " + insertionSortSwapCounterAVG + "\n"+
                    "        Heap Sort: "+ heapSortSwapCounterAVG+"\n" +
                    "       Merge sort: doesn't have swaps (in place) \n" +
                    "       Quick sort: " +quickSortSwapCounterAVG+"\n");

            System.out.println("AVG # of COMPARISONS for " + "\n" +
                    "   Insertion sort: " + insertionSortCompCounterAVG + "\n"+
                    "        Heap Sort: "+heapSortCompCounterAVG+"\n" +
                    "       Merge sort: " +mergeSortCompCounterAVG +"\n" +
                    "       Quick sort: " +quickSortCompCounterAVG+"\n");


            System.out.println("AVG # of temp arrays for Merge Sort: " + mergeSortArrayCounterAVG+"\n");


            //RUNNING ALGORITHMS AFTER INSERTION SORT SORTS THE ARRAY!
            mergeSortAfterInsertionSort();

            System.out.println("for one Run only: \n" +
                    "    Merge sort using Insertion Sort's sorted array: "+ mergeSortTime*0.000001 + " ms\n");

            quickSortAfterInsertionSort();

            System.out.println(
                    "    Quick sort using Insertion Sort's sorted array: "+ quickSortTime*0.000001 + " ms\n");

        }

}
