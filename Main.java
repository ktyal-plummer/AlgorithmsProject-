
//import java.util.ArrayList;
import java.io.PrintWriter;

import SortingAlgorithms.*;

public class Main {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("./results.txt", "UTF-8");
            QuickSort qSort = new QuickSort();
            HeapSort hSort = new HeapSort();
            MergeSort mSort = new MergeSort();

            printStatsToFile(writer, "Unsorted", "Small", qSort);
            printStatsToFile(writer, "Unsorted", "Small", hSort);
            printStatsToFile(writer, "Unsorted", "Small", mSort);

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Unsorted File generation
        // GenerateFiles gf = new GenerateFiles(30, 1000000,
        // "./UnsortedFiles/LargeList");
        // gf.generate();

        // Generating sorted files from unsorted files
        // for(int i=1; i < 31; i++){
        // HeapSort hSort = new HeapSort("./UnsortedFiles/LargeList/File" + i + ".txt");
        // hSort.sort();
        // ArrayList<Integer> sorted = hSort.getSortedArray();

        // GenerateFiles gf = new GenerateFiles(sorted, "./SortedFiles/LargeList/File" +
        // i + ".txt");
        // gf.generateFromList();
        // }

        // Generating reverse sorted files
        // for(int i=1; i < 31; i++){
        // HeapSort hSort = new HeapSort();
        // hSort.sort("./UnsortedFiles/LargeList/File" + i + ".txt");
        // ArrayList<Integer> sorted = hSort.getSortedArray();

        // GenerateFiles gf = new GenerateFiles(sorted,
        // "./ReverseSortedFiles/LargeList/File" + i + ".txt");
        // gf.generateReverseFromList();
        // }

        // Calling quick sort
        // QuickSort qSort = new QuickSort();
        // qSort.sort("./UnsortedFiles/SmallList/File1.txt");

        // Calling merge sort
        // MergeSort mSort = new MergeSort();
        // mSort.sort("./UnsortedFiles/SmallList/File1.txt");

        // Calling heap sort
        // HeapSort hSort = new HeapSort();
        // hSort.sort("./UnsortedFiles/SmallList/File1.txt");

        // Outputs the sorted array to the console
        // ArrayList<Integer> Sorted = hSort.getSortedArray();
        // System.out.println("Sorted array: ");
        // for (int i : Sorted) {
        // System.out.println(i);
        // }
        // System.out.println("Finished");
    }

    public static void printStatsToFile(PrintWriter writer, String fileType, String fileSize, Sort sortingAlgo) 
    {
        double avgArr[];
        avgArr = new double[30];
        double average = 0;

        writer.println("=====================");
        writer.println(fileType + " " + fileSize + " Files");
        writer.println("=====================");
        writer.println(sortingAlgo.toString());
        writer.println("=====================");
        for (int i = 1; i < 31; i++) {
            sortingAlgo.sort("./" + fileType + "Files/"+ fileSize + "List/File" + i + ".txt");
            avgArr[i - 1] = sortingAlgo.getTotalSortingTime();
            writer.println("File " + i + ": " + String.format("%.4f", sortingAlgo.getTotalSortingTime()));
        }
        for (int i = 0; i < avgArr.length; i++) {
            average += avgArr[i];
        }
        String totalTimeFormatted = String.format("%.4f", average);
        String avgTimeFormatted = String.format("%.4f", average / 30);
        writer.println("--------STATS--------");
        writer.println("Total time: " + totalTimeFormatted);
        writer.println("Average: " + avgTimeFormatted);
        writer.println("Standard Deviation: " + String.format("%.4f", calculateSD(avgArr)));
        writer.println("");
    }

    // Method comes from: https://www.programiz.com/java-programming/examples/standard-deviation
    public static double calculateSD(double numArray[]) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for (double num : numArray) {
            sum += num;
        }

        double mean = sum / length;

        for (double num : numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / length);
    }
}
