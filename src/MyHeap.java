

public class MyHeap {
    private int[] arr;
    private int size;

    public double swapCounter=0;
    public double compCounter=0;

    public MyHeap(int[] arr){
        size = arr.length;
        this.arr=arr;
        buildMaxHeap();
    }

/*
    public void heapify(int i) {
        int largest = i;


        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;

        if (leftChild < arr.length
                && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        if (rightChild < arr.length
                && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(largest);
        }


    }

    public int removeMax(){
        int largest = arr[0];
        arr[0] = arr[size-1];

        size--;

        heapify(0);

        System.out.println(largest);
        return largest;


    }*/
    // function build Max Heap where value
    // of each child is always smaller
    // than value of their parent
    public void buildMaxHeap()
    {
        for (int i = 1; i < size; i++)
        {
            compCounter+=1;
            // if child is bigger than parent
            if (arr[i] > arr[(i - 1) / 2])
            {
                int j = i;

                // swap child and parent until
                // parent is smaller
                while (arr[j] > arr[(j - 1) / 2])
                {
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;

                }
            }
        }
    }

    public void removeMax(int i)
    {
        // swap value of first indexed
        // with last indexed
        swap(arr, 0, i);


        // maintaining heap property
        // after each swapping
        int j = 0, index;

        do
        {
            index = (2 * j + 1);

            // if left child is smaller than
            // right child point index variable
            // to right child
            compCounter+=1;
            if (index < (i - 1) && arr[index] < arr[index + 1])
                index++;

            // if parent is smaller than child
            // then swapping parent with child
            // having higher value
            compCounter+=1;
            if (index < i && arr[j] < arr[index])
                swap(arr, j, index);


            j = index;

        } while (index < i);

    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j] = temp;
        swapCounter+=1;
    }





}
