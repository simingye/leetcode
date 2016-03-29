package Amazon;

import java.util.Arrays;

/**
 * Created by SimingYe on 2/17/16.
 */
public class ThreeSumCloset
{
    public int threeSumCloset(int[] nums, int target)
    {
        if (nums == null || nums.length < 3)
            return 0;

        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            int begin = i + 1;
            int end = nums.length - 1;

            while (begin < end)
            {
                int sum = nums[i] + nums[begin] + nums[end];
                int diff = Math.abs(sum - target);

                if (diff < min)
                {
                    min = diff;
                    result = sum;
                }

                if (diff == 0)
                {
                    return result;
                }
                else if (sum - target > 0)
                {
                    end--;
                }
                else
                {
                    begin++;
                }
            }
        }

        return result;
    }
}
