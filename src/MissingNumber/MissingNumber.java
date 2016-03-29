package MissingNumber;

/**
 * Created by SimingYe on 1/20/16.
 */
public class MissingNumber
{
    public int missingNumber(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return -1;

        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        return  n * (n + 1) / 2 - sum;
    }
}
