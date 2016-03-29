package IsomorphicStrings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SimingYe on 3/22/16.
 */
public class IsomorphicStrings2
{
    public boolean isIsomorphic(String s, String t)
    {
        if (s == null || t == null)
            return false;

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), t.charAt(i));
            }
            else
            {
                if (map.get(s.charAt(i)) != t.charAt(i))
                {
                    return false;
                }
            }

            if (!map1.containsKey(t.charAt(i)))
            {
                map1.put(t.charAt(i), s.charAt(i));
            }
            else
            {
                if (map1.get(t.charAt(i)) != s.charAt(i))
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings2 test = new IsomorphicStrings2();
        System.out.println(test.isIsomorphic("ab", "ca"));
    }
}
