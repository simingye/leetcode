package LongestSubstringWithoutRepeatingChar;

import java.util.HashMap;

/**
 * Created by Siming on 7/2/15.
 */
public class LongestSubstringWithoutRepeatingChar
{
    public int lengthOfLongestSubstring (String s)
    {
        int max = 0;
        int head = 0;
        boolean[] letter = new boolean[256];

        for (int i = 0; i < s.length(); i++)
        {
            if (!letter[s.charAt(i)])
            {
                letter[s.charAt(i)] = true;
            }
            else
            {
                while (s.charAt(head) != s.charAt(i))
                {
                    letter[s.charAt(head)] = false;
                    head++;
                }
                head++;
            }

            max = Math.max(max, i - head + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar test = new LongestSubstringWithoutRepeatingChar();;
        System.out.println(test.lengthOfLongestSubstring("abcdggg"));
    }
}
