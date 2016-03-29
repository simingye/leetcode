package ProductOfArrayExceptSelf;

/**
 * Created by SimingYe on 1/19/16.
 */
public class ProductOfArrayExceptSelf
{
    public int[] productExceptSelf(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return nums;

        /************************ normal solution ************************
        int[] result = new int[nums.length];
        int[] t1 = new int[nums.length];
        int[] t2 = new int[nums.length];

        t1[0] = 1;
        t2[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++)
        {
            t1[i] = nums[i - 1] * t1[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--)
        {
            t2[i] = t2[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++)
        {
            result[i] = t1[i] * t2[i];
        }
        ******************************************************************/
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--)
        {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++)
        {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}
