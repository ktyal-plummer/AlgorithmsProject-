package SortingAlgorithms;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;  

public class QuickSort implements Sort {
    private ArrayList<Integer> sortedArray;
    private double totalSortingTime;
    private int leftOfPivot;
    private int rightOfPivot;

    public QuickSort(){}

    /**
     * Calls the quick sort functionality 
     */
    public void sort(String filePath)
    {
        ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
        sortedArray = new ArrayList<Integer>();
        totalSortingTime = 0.0;
        leftOfPivot = 0;
        rightOfPivot = 0;

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
        if(left < right)
        {
            DijkstraPartition(array, left, right);
            quickSort(array, left, leftOfPivot-1);
            quickSort(array, rightOfPivot+1, right);
        }
    }


    /**
     * Using a three-way partition this method will update the index to the left and right of the pivot
     * 
     * @param array
     *          the unsorted array
     * @param left
     *          the left indice
     * @param right
     *          the right indice 
     */
    private void DijkstraPartition(ArrayList<Integer> array, int left, int right)
    {
        int i = left;
        int j = left;
        int k = right;
        int mid = array.get(left);
        
        while(j <= k)
        {
            if(array.get(j) < mid)
            {
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);

                i += 1;
                j += 1;
            }
            else if(array.get(j) > mid)
            {
                int temp = array.get(j);
                array.set(j, array.get(k));
                array.set(k, temp);

                k -= 1;
            }
            else 
            {
                j += 1;
            }
        }

        leftOfPivot = i;
        rightOfPivot = k;
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