package Pow;

/**
 * Created by SimingYe on 2/2/16.
 */
public class Pow2
{
    public double myPow(double x, int n)
    {
        if (n < 0)
        {
            return 1 / power(x, n);
        }
        else
        {
            return power(x, n);
        }
    }

    public double power(double x, int n)
    {
        if (n == 0)
            return 1;

        double value = power(x, n / 2);

        if (n % 2 == 0)
        {
            return value * value;
        }
        else
        {
            return value * value * x;
        }
    }
}
