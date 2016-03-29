package Amazon;

/**
 * Created by SimingYe on 2/17/16.
 */
public class LongestPalindromicSubstring
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() == 0)
            return null;

        String result = "";

        for (int i = 0; i < s.length(); i++)
        {
            String temp = helper(s, i, i);
            if (temp.length() > result.length())
            {
                result = temp;
            }

            temp = helper(s, i, i+1);
            if (temp.length() > result.length())
            {
                result = temp;
            }
        }

        return result;
    }

    public String helper(String s, int begin, int end)
    {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end))
        {
            begin--;
            end++;
        }

        return s.substring(begin+1, end);
    }
}
