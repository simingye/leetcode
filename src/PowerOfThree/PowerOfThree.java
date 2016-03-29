package PowerOfThree;

/**
 * Created by SimingYe on 1/13/16.
 */
public class PowerOfThree
{
    public boolean isPowerOfThree(int n)
    {
        if (n <= 0)
            return false;

        while (n > 1)
        {
            if (n % 3 == 0)
            {
                n /= 3;
            }
            else
            {
                return false;
            }
        }

        return true;
    }
}
