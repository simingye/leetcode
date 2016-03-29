package Amazon;

import java.util.HashMap;

/**
 * Created by SimingYe on 2/17/16.
 */
public class TwoSum
{
    public int twoSum(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(target-nums[i], nums[i]);
            }
            else
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {2,3,4};
        System.out.println(test.twoSum(nums, 6));
    }
}
