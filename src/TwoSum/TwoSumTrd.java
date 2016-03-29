package TwoSum;

import java.util.HashMap;

/**
 * Created by Siming on 10/13/15.
 */
public class TwoSumTrd
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];

        if (nums == null || nums.length < 2)
            return result;

        HashMap<Integer, Integer> map = new HashMap<>();
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                num1 = map.get(nums[i]);
                num2 = i;
                break;
            }
            else
            {
                map.put(target - nums[i], i);
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

    public static void main(String[] args) {
        TwoSumTrd test = new TwoSumTrd();
        int[] nums = {3,2,4};
        System.out.println(test.twoSum(nums, 6));
    }
}
