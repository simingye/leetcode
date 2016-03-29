package LongestIncreasingContinuousSubsequence;

/**
 * Created by SimingYe on 3/12/16.
 */
public class LongestIncreasingContinuousSubsequence
{
    public int longestIncreasingContinuousSubsequence(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        int result = 0;
        for (i = 0; i < A.length; i++)
        {
            if (i < A.length - 1 && A[i] >= A[i+1])
            {
                result = Math.max(result, i - j + 1);
                j = i + 1;
            }

            if (i == A.length - 1)
            {
                result = Math.max(result, i - j + 1);
            }
        }

        j = 0;
        int res = 0;
        for (i = 0; i < A.length; i++)
        {
            if (i < A.length - 1 && A[i] <= A[i+1])
            {
                res = Math.max(res, i - j + 1);
                j = i + 1;
            }

            if (i == A.length - 1)
            {
                res = Math.max(res, i - j + 1);
            }
        }

        return Math.max(res, result);
    }

    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequence test = new LongestIncreasingContinuousSubsequence();
        int[] nums = {8,4,2,1};
        System.out.println(test.longestIncreasingContinuousSubsequence(nums));
    }
}
