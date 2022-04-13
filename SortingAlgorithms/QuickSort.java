package SortingAlgorithms;

public class QuickSort {
    private final String fileName;

    public QuickSort(String file)
    {
        this.fileName = file;
    }
    
    /**
     * Sorts a subarray by quicksort
     * 
     * @param unsortedArray
     *          the original unsorted array of numbers 
     * @param left 
     *          the starting left indice 
     * @param right 
     *          the starting right indice
     */
    public void quickSort(int unsortedArray[], int left, int right)
    {
        if(left < right)                                                                  // if l<r
        {
            int splitPosition = lomutoPartition(unsortedArray, left, right);              // s <- Partition(A[l..r])
            quickSort(unsortedArray, left, splitPosition-1);                              // Quicksort(A[l..s − 1])
            quickSort(unsortedArray, splitPosition+1, right);                             // Quicksort(A[s + 1..r])
        }
    }

    /**
     * Partitions subarray by Lomuto’s algorithm using first element as pivot
     * 
     * @param array 
     *          the array of numbers you have to partition
     * @param left
     *          the left indice
     * @param right
     *          the right indice
     * @return the new position of the piviot 
     */
    private int lomutoPartition(int array[], int left, int right) 
    {
        int pivot = array[left];                                // p <- A[l]
        int indexOfLastElement = left;                          // s <- l

        for(int i = left; i <= right; i++){                     // for i <- l + 1 to r do     
            if(array[i] < pivot)                                // if A[i] < p
            {
                indexOfLastElement += 1;                        // s <- s + 1;
                
                int tempS = array[indexOfLastElement];          // swap(A[s], A[i])
                int tempI = array[i];
                array[indexOfLastElement] = tempI;
                array[i] = tempS;
            }
        }

        int tempL = array[left];                                // swap(A[l], A[s])
        int tempS = array[indexOfLastElement];
        array[left] = tempS;
        array[indexOfLastElement] = tempL;

        return indexOfLastElement;                              // return s
    }
}
