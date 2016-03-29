package CoinsInaLine;

/**
 * Created by SimingYe on 3/16/16.
 */
public class CoinsInaLine
{
    public boolean firstWillWin(int n)
    {
        int[] dp = new int[n+1];

        return search(n, dp);
    }

    public boolean search(int n, int[] dp)
    {
        if (dp[n] != 0)
        {
            if (dp[n] == 1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        if (n <= 0)
        {
            dp[n] = 1;
        }
        else if (n == 1 || n == 2)
        {
            dp[n] = 2;
        }
        else if (n == 3)
        {
            dp[n] = 1;
        }
        else
        {
            if ((search(n-2, dp) && search(n-3, dp)) || (search(n-3, dp) && search(n-4, dp)))
            {
                dp[n] = 2;
            }
            else
            {
                dp[n] = 1;
            }
        }

        if (dp[n] == 1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        CoinsInaLine test = new CoinsInaLine();
        System.out.println(test.firstWillWin(100));
    }
}
