package LongestCommonPrefix;

/**
 * Created by Siming on 5/26/15.
 */

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix
{
    public String longestCommonPrefix (String[] strs)
    {
        if (strs.length == 0)
            return "";

        String result = strs[0];

        for (int i = 1; i < strs.length; i++)
        {
            result = commonPrefix(result, strs[i]);
        }

        return result;
    }

    public String commonPrefix (String str1, String str2)
    {
        int length = Math.min(str1.length(), str2.length());
        String temp = "";

        for (int i = 0; i < length; i++)
        {
            if (str1.charAt(i) == str2.charAt(i))
            {
                temp = temp + str1.substring(i, i + 1);
            }
            else
            {
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(0, 0));
    }
}
