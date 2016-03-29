package HouseRobber;

/**
 * Created by SimingYe on 3/16/16.
 */
public class HouseRobber2
{
    public long houseRobber(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        if (A.length == 1)
            return A[0];

        if (A.length == 2)
            return Math.max(A[0], A[1]);

        int[] dp = new int[A.length+1];
        dp[0] = 0;
        dp[1] = A[0];
        dp[2] = Math.max(A[0], A[1]);

        for (int i = 3; i < dp.length; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i-1]);
        }

        return dp[dp.length-1];
    }
}
