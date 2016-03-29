package ImplementStr;

/**
 * Created by SimingYe on 1/28/16.
 */
public class ImplementStr2
{
    public int strStr(String haystack, String needle)
    {
        if (haystack == null || haystack.length() == 0 || needle == null)
            return -1;

        if (needle.length() == 0)
            return 0;

        int p1 = 0;

        while (p1 <= haystack.length() - needle.length())
        {
            if (haystack.charAt(p1) == needle.charAt(0))
            {
                for (int i = 0; i < needle.length(); i++)
                {
                    if (needle.charAt(i) != haystack.charAt(p1 + i))
                    {
                        break;
                    }

                    if (i == needle.length() - 1 && needle.charAt(i) == haystack.charAt(p1 + i))
                    {
                        return p1;
                    }
                }
            }

            p1++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementStr2 test = new ImplementStr2();
        System.out.println(test.strStr("abcdefg", "cd"));
    }
}
