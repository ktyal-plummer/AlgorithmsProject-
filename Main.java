import SortingAlgorithms.QuickSort;

public class Main 
{
    public static void main(String[] args)
    {
        QuickSort qSort = new QuickSort("file/path");
        int arr[] = {5, 8, 6, 71, 1 , 5, 4, 8, 8, 2, 3, 5, 4, 7, 1, 2, 9, 2, 15};
        qSort.quickSort(arr, 0, arr.length-1);
        
        for (int i : arr) {
            System.out.println(i);
        }
    }
}


