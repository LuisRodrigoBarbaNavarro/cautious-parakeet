/*
 * @author Rodrigo 'Shinia'
 * Class Token
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Token 
{
    private String name;
    private String pattern;

    public Token() {}

    public Token(String name, String pattern) 
    {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPattern()
    {
        return pattern;
    }
    
    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

    public String validate(String data)
    throws Exception
    {
        if (Pattern.matches(pattern, data))
        {
            return this.name;
        }
        else
        {
            throw new Exception("Error");
        }     
    }
}