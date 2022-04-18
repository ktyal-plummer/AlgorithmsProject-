package SortingAlgorithms;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;  

public class QuickSort implements Sort {
    private ArrayList<Integer> sortedArray;
    private double totalSortingTime;

    public QuickSort(){}

    /**
     * Calls the quick sort functionality 
     */
    public void sort(String file)
    {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();

        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
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
        quickSort(unsortedArray, 0, unsortedArray.size()-1);
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
     * Sorts a subarray by quicksort
     * 
     * @param array
     *          the original unsorted array of numbers 
     * @param left 
     *          the starting left indice 
     * @param right 
     *          the starting right indice
     */
    public void quickSort(ArrayList<Integer> array, int left, int right)
    {
        if(left < right)                                                          // if l<r
        {
            int splitPosition = lomutoPartition(array, left, right);              // s <- Partition(A[l..r])
            quickSort(array, left, splitPosition-1);                              // Quicksort(A[l..s − 1])
            quickSort(array, splitPosition+1, right);                             // Quicksort(A[s + 1..r])
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
    private int lomutoPartition(ArrayList<Integer> array, int left, int right) 
    {
        int pivot = array.get(left);                                // p <- A[l]
        int indexOfLastElement = left;                              // s <- l

        for(int i = left; i <= right; i++){                         // for i <- l + 1 to r do     
            if(array.get(i) < pivot)                                // if A[i] < p
            {
                indexOfLastElement += 1;                            // s <- s + 1;
                
                int tempS = array.get(indexOfLastElement);          // swap(A[s], A[i])
                int tempI = array.get(i);
                array.set(indexOfLastElement, tempI);
                array.set(i, tempS);
            }
        }

        int tempL = array.get(left);                                // swap(A[l], A[s])
        int tempS = array.get(indexOfLastElement);
        array.set(left, tempS);
        array.set(indexOfLastElement, tempL);

        return indexOfLastElement;                                  // return s
    }

    /**
     * 
     * @return the sorted array from quick sorting 
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
        return "Quick Sort";
    }
}
