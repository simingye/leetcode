package LongestSubstringWithoutRepeatingChar;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 3/11/16.
 */
public class LongestSubstringWithoutRepeatingChar3
{
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null)
            return 0;

        if (s.length() <= 1)
            return s.length();

        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;

        while (left <= right && right < s.length())
        {
            if (!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right));
                result = Math.max(result, set.size());
                right++;
            }
            else
            {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar3 test = new LongestSubstringWithoutRepeatingChar3();
        System.out.println(test.lengthOfLongestSubstring("abcbdef"));
    }
}
