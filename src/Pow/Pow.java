package Pow;

/**
 * Created by Siming on 9/10/15.
 */
public class Pow
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

        double value = power(x, n/2);

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
