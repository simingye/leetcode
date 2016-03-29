package strStr;

/**
 * Created by Siming on 10/13/15.
 */
public class strStr
{
    public int strStr(String haystack, String needle)
    {
        if (haystack == null || haystack.length() == 0)
            return -1;

        if (needle == null || needle.length() == 0)
            return 0;

        if (needle.length() > haystack.length())
            return -1;

        for (int i = 0; i < haystack.length(); i++)
        {
            if (i + needle.length() > haystack.length())
                return -1;

            int m = i;
            for (int j = 0; j < needle.length(); j++)
            {
                if (haystack.charAt(m) == needle.charAt(j))
                {
                    if (j == needle.length() - 1)
                    {
                        return i;
                    }
                    m++;
                }
                else
                {
                    break;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        strStr test = new strStr();
        System.out.println(test.strStr("abcdefghijk", "def"));
    }
}
