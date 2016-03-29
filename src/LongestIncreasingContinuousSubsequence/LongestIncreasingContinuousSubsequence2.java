package LongestIncreasingContinuousSubsequence;

/**
 * Created by SimingYe on 3/15/16.
 */
public class LongestIncreasingContinuousSubsequence2
{
    public int longestIncreasingContinuousSubsequence(int[] A)
    {
        if (A == null || A.length == 0)
        return 0;

        int length = 1;
        int len = 1;
        int res1 = Integer.MIN_VALUE;
        int res2 = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++)
        {
            if (A[i] < A[i-1])
            {
                length++;
            }
            else
            {
                length = 1;
            }
            res1 = Math.max(res1, length);

            if (A[i] > A[i-1])
            {
                len++;
            }
            else
            {
                len = 1;
            }
            res2 = Math.max(res2, len);
        }

        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        LongestIncreasingContinuousSubsequence2 test = new LongestIncreasingContinuousSubsequence2();
        int[] nums = {5,1,2,3,4};
        System.out.println(test.longestIncreasingContinuousSubsequence(nums));
    }
}
