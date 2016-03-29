package LongestPalindromicSubstring;

import SumRootToLeafNumbers.SumRootToLeafNumbers;

/**
 * Created by SimingYe on 3/16/16.
 */
public class LongestPalindromicSubstring3
{
    public String longestPalindrome(String s)
    {
        String result = "";

        if (s == null || s.length() == 0)
            return s;

        for (int i = 0; i < s.length(); i++)
        {
            String temp = getPalindrome(s, i, i);
            if (result.length() < temp.length())
            {
                result = temp;
            }

            temp = getPalindrome(s, i, i+1);
            if (result.length() < temp.length())
            {
                result = temp;
            }
        }

        return result;
    }

    public String getPalindrome(String s, int left, int right)
    {
        while (left >= 0 && right < s.length())
        {
            if (s.charAt(left) != s.charAt(right))
            {
                break;
            }
            else
            {
                left--;
                right++;
            }
        }

        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring3 test = new LongestPalindromicSubstring3();
        System.out.println(test.longestPalindrome("abcdzdcab"));
    }
}
