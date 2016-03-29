package FactorialTrailingZeroes;

/**
 * Created by Siming on 6/16/15.
 */
public class FactorialTrailingZeroes
{
    public int trailingZeroes (int n )
    {
        if (n < 0)
            return -1;

        int count = 0;

        for (int i = 5; n / i >= 1; i *= 5)
        {
            count = count + n / i;
        }

        return count;
    }
}
