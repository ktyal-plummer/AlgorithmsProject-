import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GenerateFiles 
{
    private int totalFiles;
    private int totalNumbers;
    private String fileLocation;
    private ArrayList<Integer> sortedList;

    GenerateFiles(int fileNum, int numbersNum, String location)
    {
        this.totalFiles = fileNum;
        this.totalNumbers = numbersNum;
        this.fileLocation = location;
    }

    GenerateFiles(ArrayList<Integer> sortedList, String location)
    {
       this.sortedList = sortedList;
       this.fileLocation = location;
    }

    public void generateFromList()
    {
        try 
        {
            FileWriter file = new FileWriter(fileLocation);
            BufferedWriter output = new BufferedWriter(file);

            for(int i = 0; i < sortedList.size(); i++) 
            {
                if(i == 0)
                {
                    output.write("" + sortedList.get(i));
                }
                else 
                {
                    output.write(" " + sortedList.get(i));
                }
            }

            output.close();
        }
        catch(Exception e) 
        {
            e.getStackTrace();
        }
    }

    
    public void generateReverseFromList() {
        try 
        {
            FileWriter file = new FileWriter(fileLocation);
            BufferedWriter output = new BufferedWriter(file);

            for(int i = sortedList.size()-1; i >= 0; i--)
            {
                if(i == sortedList.size()-1)
                {
                    output.write("" + sortedList.get(i));
                }
                else 
                {
                    output.write(" " + sortedList.get(i));
                }
            }

            output.close();
        }
        catch(Exception e) 
        {
            e.getStackTrace();
        }
    }

    public void generate()
    {
        Random rand = new Random();
        int upperBound = 10000; // 0 - 9999

        for(int i = 1; i < this.totalFiles+1; i++) 
        {
            try 
            {
                FileWriter file = new FileWriter(this.fileLocation + "/File" + i + ".txt");
                BufferedWriter output = new BufferedWriter(file);

                for(int j = 0; j < this.totalNumbers; j++) 
                {
                    int int_random = rand.nextInt(upperBound);
                    if(j == 0)
                    {
                        output.write(""+int_random);
                    }
                    else 
                    {
                        output.write(" " + int_random);
                    }
                }

                output.close();
            } 
            catch (Exception e) 
            {
                e.getStackTrace();
            }
        }
    }
}
