/*
 * @author Rodrigo 'Shinia'
 * Class ReadFile
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile
{
    private Scanner scanner;
    private String path;

    public ReadFile() {}
    
    public ReadFile(String path)
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }

    public void setPath(String path) 
    {
        this.path = path;
    }

    public ArrayList<String[]> getAllStrings()
    {
        File file = new File(path);

        try
        {
            scanner = new Scanner(file);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        ArrayList<String[]> list = new ArrayList<String[]>();

        // Read line by line
        while (scanner.hasNextLine()) 
        {

            // Indicates array position
            int i;
            ArrayList<String> tmp_list = new ArrayList<String>();

            // Get only one line separated by blank spaces
            String[] splitLine = scanner.nextLine().split("\\s");
            
            for (i = 0; i < splitLine.length;) 
            {
                // If its a String with any character
                // inside or Datetime
                if (splitLine[i].matches("^\".*$") ||
                    splitLine[i].matches("^\'.*$"))
                {
                    StringBuilder tmp = new StringBuilder();
                    
                    for (int j = i; j < splitLine.length; j++)
                    {
                        // If it finds the last part of 
                        // the String or Datetime
                        if (splitLine[j].matches("^.*\"$") ||
                            splitLine[j].matches("^.*\'$"))
                        {
                            tmp.append(splitLine[j] + " ");
                            i += 1;
                            break;
                        }
                        else 
                        {
                            tmp.append(splitLine[j] + " ");
                            i += 1;
                        }
                    }
                    
                    tmp_list.add(tmp.toString().trim());
                }
                // If its a comment 
                // with any character inside
                else if (splitLine[i].matches("^#.*$"))
                {
                    i = splitLine.length;
                } 
                else 
                {
                    // If its not a blank space, 
                    // add string to list
                    if (splitLine[i] != "")
                        tmp_list.add(splitLine[i]);
                    i += 1;
                }
            }
        
            String[] arr = new String[tmp_list.size()];
            arr = tmp_list.toArray(arr);
            list.add(arr);
        }
        
        scanner.close();
        return list;
    }
} 