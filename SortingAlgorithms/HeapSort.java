package SortingAlgorithms;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Used pseudo code from this website: https://fullyunderstood.com/pseudocodes/heap-sort/ to build heap sort 
public class HeapSort {
    private String filePath;
    private ArrayList<Integer> sortedArray = new ArrayList<Integer>();

    public HeapSort(String path)
    {
        this.filePath = path;
    }

    /**
     * Calls the heap sort functionality
     */
    public void sort()
    {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String currentLine = "";
            
            while((currentLine = reader.readLine()) != null){
                String splitNumbers[] = currentLine.split(" ");
                for (int i = 0; i < splitNumbers.length; i++)
                {
                    int numberFromFile = -1;
                    try
                    {
                        numberFromFile = Integer.parseInt(splitNumbers[i]);
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println(e);
                    }

                    if(numberFromFile > -1)
                    {
                        unsortedArray.add(numberFromFile);
                    }
                }
            }
            
            reader.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        heapSort(unsortedArray);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.0000");
        System.out.println("Total execution time: " + formatter.format((end - start) / 1000d) + " seconds");

        sortedArray = unsortedArray;
    }

    /**
     * Sorts the heap after it has been heapified 
     * 
     * @param array
     *          The given unsorted array
     */
    private void heapSort(ArrayList<Integer> array)
    {
        int n = array.size();
        for(int i = (int)Math.floor(n/2)-1; i >= 0; i--)
        {
            heapify(array, n, i);
        }

        for(int i = n - 1; i >= 0; i--)
        {
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);

            heapify(array, i, 0);
        }

        sortedArray = array;
    }

    /**
     * Reshapes a binary tree into a heap data structure 
     * 
     * @param array
     *          the original array
     * @param n
     *          the current idex in the array
     * @param root
     *          the root node
     */
    private void heapify(ArrayList<Integer> array, int n, int root)
    {
        int max = root; 
        int leftChild = (2 * root) + 1;
        int rightChild = (2 * root) + 2;

        if(leftChild < n && array.get(max) < array.get(leftChild))
        {
            max = leftChild;
        }

        if(rightChild < n && array.get(max) < array.get(rightChild))
        {
            max = rightChild;
        }

        if(max != root)
        {
            int temp = array.get(root);
            array.set(root, array.get(max));
            array.set(max, temp);

            heapify(array, n, max);
        }
    }

    /**
    * 
    * @return the sorted array from merge sorting 
    */
    public ArrayList<Integer> getSortedArray()
    {
        return sortedArray;
    }
}
