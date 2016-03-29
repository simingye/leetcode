package Backpack;

/**
 * Created by SimingYe on 3/21/16.
 */
public class Backpack
{
    public int backpack(int m, int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        boolean dp[][] = new boolean[A.length+1][m+1];

        for (int i = 0; i < dp[0].length; i++)
        {
            dp[0][i] = false;
        }

        for (int i = 0; i < dp.length; i++)
        {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]])
                {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = m; i >= 0; i--)
        {
            if (dp[A.length][i])
            {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Backpack test = new Backpack();
        int[] nums = {3,4,8,5};
        System.out.println(test.backpack(10, nums));
    }
}
