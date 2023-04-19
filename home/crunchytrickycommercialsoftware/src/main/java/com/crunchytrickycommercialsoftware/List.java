/*
 * @author Rodrigo 'Shinia'
 * Class List $ Node
*/

import java.util.ArrayList;

public class List
{

    private Node head;

    class Node
    {
        private Token data;
        private Node next;

        public Node(Token data)
        {
            this.data = data;
        }

        public Node(String name, String pattern)
        {
            data = new Token(name, pattern);
        }
    }

    public List()
    {
        head = null;
    }

    public boolean empty()
    {
        return head == null;
    }

    public void clean()
    {
        head = null;
    }

    public void add(String name, String pattern)
    {
        Token token = new Token(name, pattern);

        if (empty()) head = new Node(token);
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(token);
        }
    }

    public String validate(String data)
    {
        String matched = "Error";

        if (!empty())
        {
            Node temp = head;
            do
            {
                try
                {
                    matched = temp.data.validate(data);
                } catch (Exception e)
                {
                    temp = temp.next;
                }
            }
            while (temp != null && matched == "Error");
        }
        return matched;
    }

    public void fill(String path)
    {
        ReadFile readfile = new ReadFile(path);

        ArrayList<String[]> list = readfile.getAllStrings();
        
        for (String[] array : list)
        {
            this.add(array[0], array[1]);
        }
    }
}