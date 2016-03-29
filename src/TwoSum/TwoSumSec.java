package TwoSum;

import java.util.HashMap;

/**
 * Created by Siming on 10/13/15.
 */
public class TwoSumSec
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        if (nums == null || nums.length == 0 || nums.length == 1)
            return result;

        HashMap<Integer, Integer> map = new HashMap<>();
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(target - nums[i], i);
            }
            else
            {
                num1 = map.get(nums[i]) + 1;
                num2 = i + 1;
                break;
            }
        }

        if (num1 < num2)
        {
            result[0] = num1;
            result[1] = num2;
        }
        else
        {
            result[0] = num2;
            result[1] = num1;
        }

        return result;
    }
}
