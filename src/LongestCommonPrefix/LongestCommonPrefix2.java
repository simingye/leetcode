package LongestCommonPrefix;

/**
 * Created by SimingYe on 1/26/16.
 */
public class LongestCommonPrefix2
{
    public String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        int length = 0;
        for (String str : strs)
        {
            minLen = Math.min(minLen, str.length());
        }

        for (int i = 0; i < minLen; i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++)
            {
                if (c == strs[j].charAt(i))
                {
                    continue;
                }
                else
                {
                    return strs[0].substring(0, i);
                }
            }
            length++;
        }

        return strs[0].substring(0, length);
    }
}
