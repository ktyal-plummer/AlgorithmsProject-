import java.util.ArrayList;

import SortingAlgorithms.*;

public class Main 
{
    public static void main(String[] args)
    {
        // Unsorted File generation 
        // GenerateFiles gf = new GenerateFiles(30, 1000000, "./UnsortedFiles/LargeList");
        // gf.generate();

        // Generating sorted files from unsorted files
        // for(int i=1; i < 31; i++){
        //     HeapSort hSort = new HeapSort("./UnsortedFiles/LargeList/File" + i + ".txt");
        //     hSort.sort();
        //     ArrayList<Integer> sorted = hSort.getSortedArray();
            
        //     GenerateFiles gf = new GenerateFiles(sorted, "./SortedFiles/LargeList/File" + i + ".txt");
        //     gf.generateFromList();
        // }
        
        // Generating reverse sorted files
        // for(int i=1; i < 31; i++){
        //     HeapSort hSort = new HeapSort("./UnsortedFiles/LargeList/File" + i + ".txt");
        //     hSort.sort();
        //     ArrayList<Integer> sorted = hSort.getSortedArray();
            
        //     GenerateFiles gf = new GenerateFiles(sorted, "./ReverseSortedFiles/LargeList/File" + i + ".txt");
        //     gf.generateReverseFromList();
        // }

        // Calling quick sort
        // QuickSort qSort = new QuickSort("./UnsortedFiles/SmallList/File1.txt");
        // qSort.sort();

        // Calling merge sort
        // MergeSort mSort = new MergeSort("./UnsortedFiles/SmallList/File1.txt");
        // mSort.sort();

        // Calling heap sort
        // HeapSort hSort = new HeapSort("./UnsortedFiles/SmallList/File1.txt");
        // hSort.sort();
        
        //Outputs the sorted array to the console 
        // ArrayList<Integer> Sorted = hSort.getSortedArray();
        // System.out.println("Sorted array: ");
        // for (int i : Sorted) {
        //     System.out.println(i);
        // }
        // System.out.println("Finished");
    }
}




