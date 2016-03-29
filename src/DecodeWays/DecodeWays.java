package DecodeWays;

/**
 * Created by Siming on 9/30/15.
 */
public class DecodeWays
{
    public int numDecodeings(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        int[] t = new int[s.length() + 1];
        t[0] = 1;

        if (isValid(s.substring(0, 1)))
        {
            t[1] = 1;
        }
        else
        {
            t[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++)
        {
            if (isValid(s.substring(i-1, i)))
            {
                t[i] += t[i-1];
            }

            if (isValid(s.substring(i-2, i)))
            {
                t[i] += t[i-2];
            }
        }

        return t[s.length()];
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(s);

        return num <= 26 && num >= 1;
    }

    public static void main(String[] args) {
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodeings("6666"));
    }
}
