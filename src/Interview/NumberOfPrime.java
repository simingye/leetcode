package Interview;

/**
 * Created by Siming on 10/7/15.
 */
public class NumberOfPrime
{
    public int solution(int A, int B)
    {
        int count = 0;
        for (int i = A; i <= B; i++)
        {
            if (isPrime(i))
            {
                count++;
            }
        }

        return count;
    }

    public boolean isPrime(int n)
    {
        if (n <= 1)
        {
            return false;
        }

        if (n == 2)
        {
            return true;
        }

        if (n % 2 == 0)
        {
            return false;
        }

        int temp = (int)Math.sqrt(n);
        for (int i = 3; i <= temp; i += 2)
        {
            if (n % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
