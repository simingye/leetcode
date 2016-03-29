package DecodeWays;

/**
 * Created by Siming on 10/20/15.
 */
public class DecodeWaysTrd
{
    public int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        int[] results = new int[s.length()+1];
        results[0] = 1;

        if (isValid(s.substring(0, 1)))
        {
            results[1] = 1;
        }
        else
        {
            results[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++)
        {
            if (isValid(s.substring(i-1, i)))
            {
                results[i] += results[i-1];
            }

            if (isValid(s.substring(i-2, i)))
            {
                results[i] += results[i-2];
            }
        }

        return results[s.length()];
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0' || s == null)
            return false;

        int num = Integer.parseInt(s);

        return num <= 26 && num > 0;
    }

    public static void main(String[] args) {
        DecodeWaysTrd test = new DecodeWaysTrd();
        System.out.println(test.numDecodings("01"));
    }
}
