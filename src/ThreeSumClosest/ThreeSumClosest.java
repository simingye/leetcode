package ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by Siming on 7/10/15.
 */
public class ThreeSumClosest
{
    public int threeSumClosest (int[] nums, int target)
    {
        if (nums == null || nums.length < 3)
        {
            return 0;
        }

        Arrays.sort(nums);

        int result = nums[0] + nums[nums.length-1] + nums[1];

        for (int i = 0; i < nums.length - 2; i++)
        {
            int head = i + 1;
            int last = nums.length - 1;

            while (head < last)
            {
                int temp = nums[i] + nums[head] + nums[last];
                int diff = Math.abs(temp - target);

                if (diff == 0)
                {
                    return temp;
                }

                if (Math.abs(temp - target) < Math.abs(result - target))
                {
                    result = temp;
                }

                if (temp < target)
                {
                    head++;
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
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = {1,1,1,0};
        System.out.println(test.threeSumClosest(nums, 100));
    }
}
