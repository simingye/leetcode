package WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by SimingYe on 1/12/16.
 */
public class WordPattern
{
    public boolean wordPattern(String pattern, String str)
    {
        if (str == null || str.length() == 0 || pattern.length() == 0)
            return false;

        String[] s = str.split(" ");
        if (s.length != pattern.length())
        {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
        {
            if (map.containsKey(pattern.charAt(i)))
            {
                if (!map.get(pattern.charAt(i)).equals(s[i]))
                {
                    return false;
                }
            }
            else if (map.containsValue(s[i]))
            {
                return false;
            }
            else
            {
                map.put(pattern.charAt(i), s[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
    }
}