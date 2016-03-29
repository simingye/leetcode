package LongestPalindromicSubstring;

import SubsetsTwo.SubsetsTwo;

/**
 * Created by SimingYe on 1/25/16.
 */
public class LongestPalindromicSubstring2
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() == 0)
            return s;

        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++)
        {
            String temp = helper(s, i, i);
            if (temp.length() > result.length())
            {
                result = temp;
            }

            temp = helper(s, i, i + 1);
            if (temp.length() > result.length())
            {
                result = temp;
            }
        }

        return result;
    }

    public String helper(String s, int start, int end)
    {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring2 test = new LongestPalindromicSubstring2();
        System.out.println(test.longestPalindrome("a"));
    }
}
