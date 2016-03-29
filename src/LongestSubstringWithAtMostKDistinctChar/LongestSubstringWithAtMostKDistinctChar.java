package LongestSubstringWithAtMostKDistinctChar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by SimingYe on 3/11/16.
 */
public class LongestSubstringWithAtMostKDistinctChar
{
    public int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        if (s == null || s.length() == 0)
            return 0;

        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);

            if (map.containsKey(c))
            {
                map.put(c, map.get(c) + 1);
            }
            else
            {
                map.put(c, 1);
                while (map.size() > k)
                {
                    char slowChar = s.charAt(left);

                    int count = map.get(slowChar);
                    if (count > 1)
                    {
                        map.put(slowChar, map.get(slowChar) - 1);
                    }
                    else
                    {
                        map.remove(slowChar);
                    }

                    left++;
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctChar test = new LongestSubstringWithAtMostKDistinctChar();
        System.out.println(test.lengthOfLongestSubstringKDistinct("world", 4));
    }
}
