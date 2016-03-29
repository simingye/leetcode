package DecodeWays;

/**
 * Created by Siming on 10/21/15.
 */
public class DecodeWaysDP
{
    public int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        int one = 1;
        int two;
        int three = 0;

        if (isValid(s.substring(0, 1)))
        {
            two = 1;
        }
        else
        {
            two = 0;
        }

        for (int i = 2; i <= s.length(); i++)
        {
            three = 0;

            if (isValid(s.substring(i - 1, i)))
            {
                three += two;
            }

            if (isValid(s.substring(i-2, i)))
            {
                three += one;
            }

            one = two;
            two = three;
        }

        return three;
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
        {
            return false;
        }

        int num = Integer.valueOf(s);

        return num <= 26 && num >= 1;
    }

    public static void main(String[] args) {
        DecodeWaysDP test = new DecodeWaysDP();
        System.out.println(test.numDecodings("12"));
    }
}
