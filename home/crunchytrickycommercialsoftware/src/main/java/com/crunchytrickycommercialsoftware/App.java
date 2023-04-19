/**
 * @author Rodrigo 'Shinia'
 * Class App
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class App
{
    public static void main(String[] args)
    {
        ReadFile reader = new ReadFile("code.txt");
        List list = new List();
        
        list.fill("name_pattern.txt");
        
        ArrayList<String[]> arraylist = reader.getAllStrings();

        for (String[] array : arraylist)
        {
            for (String element : array) {
                System.out.println(list.validate(element));
            }
        }   
    }
}
