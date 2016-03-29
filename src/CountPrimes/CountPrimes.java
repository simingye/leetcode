package CountPrimes;

/**
 * Created by Siming on 6/19/15.
 */
public class CountPrimes
{
    public int countPrimes (int n)
    {
        if (n <= 1)
        {
            return 0;
        }

        if (n == 2)
            return 0;

        if (n == 3)
            return 1;

        int count = 0;

        for (int i = 2; i < n; i++)
        {
            if (isPrime(i))
                count++;
        }

        return count;
    }

    public boolean isPrime (int num)
    {
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            if ((num % i) == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimes(4));
    }
}
