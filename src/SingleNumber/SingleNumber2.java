package SingleNumber;

/**
 * Created by SimingYe on 3/26/16.
 */
public class SingleNumber2
{
    public int singleNumber(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        for (int i = 1; i < nums.length ; i++)
        {
            nums[i] = nums[i] ^ nums[i-1];
        }

        return nums[nums.length - 1];
    }
}
