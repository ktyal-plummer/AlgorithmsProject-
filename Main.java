import java.util.ArrayList;
import java.io.PrintWriter;

import SortingAlgorithms.*;

public class Main {
    public static void main(String[] args) {
        // Write data from all the sorts to a results file
        // try {
        //     PrintWriter writer = new PrintWriter("./results.txt", "UTF-8");
        //     QuickSort qSort = new QuickSort();
        //     HeapSort hSort = new HeapSort();
        //     MergeSort mSort = new MergeSort();

        //     //Unsorted small
        //     printStatsToFile(writer, "Unsorted", "Small", qSort);
        //     printStatsToFile(writer, "Unsorted", "Small", hSort);
        //     printStatsToFile(writer, "Unsorted", "Small", mSort);

        //     // Unsorted Medium
        //     printStatsToFile(writer, "Unsorted", "Medium", qSort);
        //     printStatsToFile(writer, "Unsorted", "Medium", hSort);
        //     printStatsToFile(writer, "Unsorted", "Medium", mSort);

        //     // Unsorted Large
        //     printStatsToFile(writer, "Unsorted", "Large", qSort);
        //     printStatsToFile(writer, "Unsorted", "Large", hSort);
        //     printStatsToFile(writer, "Unsorted", "Large", mSort);

        //     // Sorted Small
        //     printStatsToFile(writer, "Sorted", "Small", qSort);
        //     printStatsToFile(writer, "Sorted", "Small", hSort);
        //     printStatsToFile(writer, "Sorted", "Small", mSort);

        //     // Sorted Medium
        //     printStatsToFile(writer, "Sorted", "Medium", qSort);
        //     printStatsToFile(writer, "Sorted", "Medium", hSort);
        //     printStatsToFile(writer, "Sorted", "Medium", mSort);

        //     // Sorted Large
        //     printStatsToFile(writer, "Sorted", "Large", qSort);
        //     printStatsToFile(writer, "Sorted", "Large", hSort);
        //     printStatsToFile(writer, "Sorted", "Large", mSort);

        //     // Reverse Sorted Small
        //     printStatsToFile(writer, "ReverseSorted", "Small", qSort);
        //     printStatsToFile(writer, "ReverseSorted", "Small", hSort);
        //     printStatsToFile(writer, "ReverseSorted", "Small", mSort);

        //     // Reverse Sorted Medium
        //     printStatsToFile(writer, "ReverseSorted", "Medium", qSort);
        //     printStatsToFile(writer, "ReverseSorted", "Medium", hSort);
        //     printStatsToFile(writer, "ReverseSorted", "Medium", mSort);

        //     // Reverse Sorted Large
        //     printStatsToFile(writer, "ReverseSorted", "Large", qSort);
        //     printStatsToFile(writer, "ReverseSorted", "Large", hSort);
        //     printStatsToFile(writer, "ReverseSorted", "Large", mSort);

        //     writer.close();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }

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
        // ArrayList<Integer> Sorted = qSort.getSortedArray();
        // System.out.println("Sorted array: ");
        // for (int i : Sorted) {
        // System.out.println(i);
        // }
        // System.out.println("Finished");
    }

    /**
     * Goes through a list a files and uses a specified sorting algorithm to sort and finally writes the stats of that sort into that file
     * 
     * @param writer
     *          the file writer
     * @param fileType
     *          the type of file: sorted, unsorted, reverse sorted
     * @param fileSize
     *          the size of the file: small, medium, large
     * @param sortingAlgo
     *          the sorting algorithm to be used: quick, merge, heap
     */
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
