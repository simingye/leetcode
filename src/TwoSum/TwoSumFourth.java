package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siming on 10/27/15.
 */
public class TwoSumFourth
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] results = new int[2];

        if (nums == null || nums.length < 2)
            return results;

        Map<Integer, Integer> map = new HashMap<>();
        int one = 0;
        int two = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                one = map.get(nums[i]);
                two = i;
            }
            else
            {
                map.put(target - nums[i], i);
            }
        }

        if (one >= two)
        {
            results[0] = two + 1;
            results[1] = one + 1;
        }
        else
        {
            results[0] = one + 1;
            results[1] = two + 1;
        }

        return results;
    }
}
