
/**
 * @author Rodrigo 'Shinia'
 * Class StringTokenizer
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StringTokenizer {

    public static void main(String[] args)
    {
       // Object Scanner and File with path
       Scanner scanner = null;
       File file = new File("StringTokenizer.txt");

       // Verify if file exists
       try 
       {
           scanner = new Scanner(file);
       } 
       catch (FileNotFoundException e) 
       {
           e.printStackTrace();
       }

       // ArrayList to store Strings
       ArrayList<String> list = new ArrayList<String>();
       
       // Read line by line
       while (scanner.hasNextLine()) 
       {
           // Indicates array position
           int i;
           
           // Get only one line separated by blank spaces
           String[] splitLine = scanner.nextLine().split("\\s");
           
           for (i = 0; i < splitLine.length;) 
           {
               // If its a String or Datetime with any character inside
               if (splitLine[i].matches("^\".*$") || splitLine[i].matches("^\'.*$"))
               {
                   StringBuilder tmp = new StringBuilder();
                   
                   for (int j = i; j < splitLine.length; j++)
                   {
                       // If it finds the last part of the string
                       if (splitLine[j].matches("^.*\"$") || splitLine[j].matches("^.*\'$"))
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
                   
                   list.add(tmp.toString().trim());
               }
               // If its a comment with any character inside
               else if (splitLine[i].matches("^#.*$"))
               {
                   StringBuilder tmp = new StringBuilder();
                   
                   // Create up to the last position of the array
                   for (int j = i; j < splitLine.length; j++) tmp.append(splitLine[j] + " ");
                   
                   list.add(tmp.toString().trim());
                   
                   // Set array position to length
                   i = splitLine.length;
               } else 
               {
                   // If its not a blank space, add string to list
                   if (splitLine[i] != "") list.add(splitLine[i]);
                   i += 1;
               }
           }
       }
       
       System.out.println(list);
       scanner.close();
   }
}