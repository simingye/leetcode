package PowerOfTwo;

/**
 * Created by Siming on 11/20/15.
 */
public class PowerOfTwo
{
    public boolean isPowerOfTwo(int n)
    {
        while (n > 1)
        {
            Double temp = n / 2.0;
            n = n >> 1;

            if (!temp.equals(Double.valueOf(n)))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo test = new PowerOfTwo();
        System.out.println(test.isPowerOfTwo(14));
    }
}
