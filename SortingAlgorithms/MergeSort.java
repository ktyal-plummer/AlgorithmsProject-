package SortingAlgorithms;

import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.io.*;

public class MergeSort {
    private String filePath;
    private ArrayList<Integer> sortedArray = new ArrayList<Integer>();

    public MergeSort(String file)
    {
        this.filePath = file;
    }

     /**
     * Calls the quick sort functionality 
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
        mergeSort(unsortedArray);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.0000");
        System.out.println("Total execution time: " + formatter.format((end - start) / 1000d) + " seconds");

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
            ArrayList<Integer> B = new ArrayList<Integer>();
            for(int i = 0; i <= (int)Math.floor(n/2)-1; i++)
            {
                B.add(array.get(i));
            }

            ArrayList<Integer> C = new ArrayList<Integer>();
            for(int i = (int)Math.floor(n/2); i < n; i++)
            {
                C.add(array.get(i));
            }
            
            mergeSort(B);
            mergeSort(C);
            merge(B, C, array);
        }

        sortedArray = array;
    }

    /**
     * Merges two sorted arrays into one sorted array
     * 
     * @param B
     *          The left side of the split array
     * @param C
     *          The right side of the split array
     * @param A
     *          The array to be overwritten with sorted values
     */
    public void merge(ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> A)
    {
        int i = 0, j = 0, k = 0;
        int p = B.size();
        int q = C.size();

        while(i < p && j < q) 
        {
            if(B.get(i) <= C.get(j)) 
            {
                A.set(k, B.get(i));
                i = i + 1;
            }
            else 
            {
                A.set(k, C.get(j));
                j = j + 1;
            }

            k = k + 1;
        }

        // This last part comes from a solution at: https://www.geeksforgeeks.org/merge-sort/
        while(i<p)
        {
            A.set(k, B.get(i));
            i = i + 1;
            k = k + 1;
        }

        while(j<q)
        {
            A.set(k, C.get(j));
            j = j + 1;
            k = k + 1;
        }

        // Solution from the books sudo code gave me the array [1, 2, 3, 4, 5, 7, 9, 9] from the input [8, 3, 2, 9, 7, 1, 5, 4] and I couldn't figure out why
        // System.out.println("Last part: ");
        // if(i == p)
        // {
        //     System.out.println("First If: ");
        //     for(int n = j; n <= q-1; n++)
        //     {
        //         for(int m = k; m <= (p+q)-1; m++)
        //         {
        //             A.set(m, C.get(n));
        //             System.out.println(C.get(n));
        //         }
        //     }
        // }
        // else
        // {
        //     System.out.println("Second else: ");
        //     for(int n = i; n <= p-1; n++)
        //     {
        //         for(int m = k; m <= (p+q)-1; m++)
        //         {
        //             A.set(m, B.get(n));
        //             System.out.println("Set index: " + m + " to: " + B.get(n));
        //         }
        //     }
        // }
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
