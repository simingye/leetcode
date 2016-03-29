package ImplementStr;

/**
 * Created by Siming on 5/30/15.
 */

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStr
{
    public int strStr (String haystack, String needle)
    {
        if (needle.length() > haystack.length())
            return -1;

        if (haystack == null || needle == null)
            return -1;

        if (needle.length() == 0)
            return 0;

        int pointer1 = 0; // for needle
        int pointer2 = 0; // for haystack

        for (int j = 0; j < haystack.length(); j++)
        {
            if (needle.charAt(0) == haystack.charAt(j))
            {
                if (haystack.length() - j < needle.length())
                    return -1;

                pointer1 = j;

                for (int i = 0; i < needle.length(); i++)
                {
                    if (needle.charAt(i) != haystack.charAt(i + j))
                    {
                        break;
                    }
                    else
                    {
                        if (i == needle.length() - 1)
                            return pointer1 + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStr test = new ImplementStr();
        System.out.println(test.strStr("a", "a"));
    }
}
