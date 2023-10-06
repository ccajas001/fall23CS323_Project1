import java.util.Random;
/*MAIN CLASS
*   meant to set up random arrays and call sorting algorithm library to sort said array
* */

public class Main {

    static Random rand = new Random();

    public static void main(String[] args) {
        //System.out.println("a test for array of size 10");
        //SortingAlgorithmAnalysis SAA1 = new SortingAlgorithmAnalysis(randomSetOf(10));

        /*
        //FOR SMALL ARRAYS
        System.out.println("\n 100 tests for arrays of size 16 from 1-1,000,000");
        SortingAnalysis ana3 = new SortingAnalysis(randomSetOf(16,1000));
        System.out.println("\n 100 tests for arrays of size 32 from 1-1,000,000");
        SortingAnalysis ana4 = new SortingAnalysis(randomSetOf(32,1000));
        System.out.println("\n 100 tests for arrays of size 64 from 1-1,000,000");
        SortingAnalysis ana5 = new SortingAnalysis(randomSetOf(64,1000));
        System.out.println("\n 100 tests for arrays of size 128 from 1-1,000,000");
        SortingAnalysis ana6 = new SortingAnalysis(randomSetOf(128,1000));
        System.out.println("\n 100 tests for arrays of size 256 from 1-1,000,000");
        SortingAnalysis ana7 = new SortingAnalysis(randomSetOf(256,1000));
        */

        SortingAnalysis sa = new SortingAnalysis(randomSetOf(10, 100));
        sa.test();

        /*
        //FOR LARGE ARRAYS
        System.out.println("100 tests for arrays of size 10,000 from 1-1,000,000" );
        SortingAnalysis ana1 = new SortingAnalysis(randomSetOf(10000,1000000));

        System.out.println("\n 100 tests for arrays of size 10,000 from 1-1,000,000");
        SortingAnalysis ana2 = new SortingAnalysis(randomSetOf(100000,100000));
*/

    }

    public static int[] randomSetOf(int x,int upTo){
        int[] setOf10 = new int[x];
        for(int i=0; i<setOf10.length;i++){
            setOf10[i] = rand.nextInt(upTo-1)+1;
        }
        return setOf10;
    }




}