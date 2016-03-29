package Amazon;

/**
 * Created by SimingYe on 2/18/16.
 */
public class LongestPalindromicSubstring2
{
    public String longestPalindrome(String s)
    {
        if (s == null || s.length() < 2)
            return s;

        String result = "";

        for (int i = 0; i < s.length(); i++)
        {
            String temp = helper(s, i, i);
            if (result.length() < temp.length())
            {
                result = temp;
            }

            temp = helper(s, i, i+1);
            if (result.length() < temp.length())
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
