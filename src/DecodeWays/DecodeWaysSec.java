package DecodeWays;

/**
 * Created by Siming on 10/18/15.
 */
public class DecodeWaysSec
{
    public int numDecodings(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        int opt[] = new int[s.length()+1];
        opt[0] = 1;

        if (isValid(s.substring(0, 1)))
        {
            opt[1] = 1;
        }
        else
        {
            opt[0] = 0;
        }

        for (int i = 2; i <= s.length(); i++)
        {
            if (isValid(s.substring(i-1, i)))
            {
                opt[i] += opt[i-1];
            }

            if (isValid(s.substring(i-2, i)))
            {
                opt[i] += opt[i-2];
            }
        }

        return opt[s.length()];
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(s);

        return num <= 26 && num >= 1;
    }
}
