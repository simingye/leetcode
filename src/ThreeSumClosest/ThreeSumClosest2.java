package ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by SimingYe on 1/26/16.
 */
public class ThreeSumClosest2
{
    public int threeSumClosest(int[] nums, int target)
    {
        if (nums == null || nums.length < 3)
            return 0;

        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++)
        {
            int first = i + 1;
            int last = nums.length - 1;

            while (first < last)
            {
                int sum = nums[i] + nums[last] + nums[first];

                if (Math.abs(target - sum) < min)
                {
                    result = sum;
                    min = Math.abs(target - sum);
                }

                if (target ==  nums[i] + nums[last] + nums[first])
                {
                    return result;
                }
                else if (target > nums[i] + nums[last] + nums[first])
                {
                    first++;
                }
                else
                {
                    last--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest2 test = new ThreeSumClosest2();
        int[] nums = {-1,2,1,4};
        System.out.println(test.threeSumClosest(nums, 1));
    }
}
