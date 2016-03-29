package TwoSum;

import java.util.HashMap;

/**
 * Created by SimingYe on 1/25/16.
 */
public class TwoSum5
{
    public int[] twoSum(int[] nums, int target)
    {
        if (nums == null || nums.length <= 2)
            return null;

        int[] result = new int[2];
        int index1 = 0;
        int index2 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                index1 = map.get(nums[i]);
                index2 = i;
                break;
            }
            else
            {
                map.put(target - nums[i], i);
            }
        }

        if (index1 < index2)
        {
            result[0] = index1 + 1;
            result[1] = index2 + 1;
        }
        else
        {
            result[0] = index2 + 1;
            result[1] = index1 + 1;
        }

        return result;
    }
}
