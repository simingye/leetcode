package LongestConsecutiveSequece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 2/25/16.
 */
public class LongestConsecutiveSequence2
{
    public int longestConsecutive(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int i : nums)
        {
            set.add(i);
        }

        int result = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (set.contains(nums[i]))
            {
                int count = 1;
                int num = nums[i];
                while (set.contains(num))
                {
                    count++;
                    set.remove(num);
                    num--;
                }

                num = nums[i] + 1;
                while (set.contains(num))
                {
                    count++;
                    set.remove(num);
                    num++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
