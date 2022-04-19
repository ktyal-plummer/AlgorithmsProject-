package SortingAlgorithms;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.io.*;

public class MergeSort implements Sort {
    private ArrayList<Integer> sortedArray = new ArrayList<Integer>();
    private double totalSortingTime;

    public MergeSort(){}

     /**
     * Calls the merge sort functionality 
     */
    public void sort(String filePath)
    {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
        sortedArray = new ArrayList<Integer>();
        totalSortingTime = 0.0;

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
        mergeSort(unsortedArray);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.0000");
        String finalTime = formatter.format((end - start) / 1000d);
        System.out.println(finalTime + " seconds");

        try{
            double convertedTime = Double.parseDouble(finalTime);
            totalSortingTime = convertedTime;
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        sortedArray = unsortedArray;
    }

    /**
     * Sorts array A[0..n-1] by recursive mergesort
     * 
     * @param array 
     *          The unsorted array A[0..n-1]
     */
    public void mergeSort(ArrayList<Integer> array)
    {
        int n = array.size();

        if(n > 1) 
        {
            ArrayList<Integer> leftArr = new ArrayList<Integer>();
            for(int i = 0; i <= (int)Math.floor(n/2)-1; i++)
            {
                leftArr.add(array.get(i));
            }

            ArrayList<Integer> rightArr = new ArrayList<Integer>();
            for(int i = (int)Math.floor(n/2); i < n; i++)
            {
                rightArr.add(array.get(i));
            }
            
            mergeSort(leftArr);
            mergeSort(rightArr);
            merge(leftArr, rightArr, array);
        }
    }

    /**
     * Merges two sorted arrays into one sorted array
     * 
     * @param leftArr
     *          The left side of the split array
     * @param rightArr
     *          The right side of the split array
     * @param mergeToArr
     *          The array to be overwritten with sorted values
     */
    public void merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr, ArrayList<Integer> mergeToArr)
    {
        int i = 0, j = 0, k = 0;
        int p = leftArr.size();
        int q = rightArr.size();

        while(i < p && j < q) 
        {
            if(leftArr.get(i) <= rightArr.get(j)) 
            {
                mergeToArr.set(k, leftArr.get(i));
                i = i + 1;
            }
            else 
            {
                mergeToArr.set(k, rightArr.get(j));
                j = j + 1;
            }

            k = k + 1;
        }

        // This last bit comes from a solution at: https://www.geeksforgeeks.org/merge-sort/
        while(i<p)
        {
            mergeToArr.set(k, leftArr.get(i));
            i = i + 1;
            k = k + 1;
        }

        while(j<q)
        {
            mergeToArr.set(k, rightArr.get(j));
            j = j + 1;
            k = k + 1;
        }

        /*
        My attempted solution from the books pseudo code gave me the array [1, 2, 3, 4, 5, 7, 9, 9] from the input [8, 3, 2, 9, 7, 1, 5, 4] and I couldn't figure out why
        System.out.println("Last part: ");
        if(i == p)
        {
            System.out.println("First If: ");
            for(int n = j; n <= q-1; n++)
            {
                for(int m = k; m <= (p+q)-1; m++)
                {
                    A.set(m, C.get(n));
                    System.out.println(C.get(n));
                }
            }
        }
        else
        {
            System.out.println("Second else: ");
            for(int n = i; n <= p-1; n++)
            {
                for(int m = k; m <= (p+q)-1; m++)
                {
                    A.set(m, B.get(n));
                    System.out.println("Set index: " + m + " to: " + B.get(n));
                }
            }
        }
        */
    }

    
    /**
     * 
     * @return the sorted array from merge sorting 
     */
    public ArrayList<Integer> getSortedArray()
    {
        return sortedArray;
    }

    /**
     * 
     * @return the total amount of time it took to sort the given array
     */
    public double getTotalSortingTime()
    {
        return totalSortingTime;
    }

    /**
     * 
     * @return the class name
     */
    public String toString()
    {
        return "Merge Sort";
    }
}
