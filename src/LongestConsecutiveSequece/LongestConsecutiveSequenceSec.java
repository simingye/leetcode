package LongestConsecutiveSequece;

import java.util.HashSet;

/**
 * Created by Siming on 10/13/15.
 */
public class LongestConsecutiveSequenceSec
{
    public int longestConsecutive(int[] nums)
    {
        int result = 0;

        if (nums == null || nums.length == 0)
        {
            return result;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i : nums)
        {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (set.contains(nums[i]))
            {
                int count = 0;
                int next = nums[i] - 1;
                while (set.contains(next))
                {
                    set.remove(next);
                    next--;
                    count++;
                }

                next = nums[i] + 1;
                while (set.contains(next))
                {
                    set.remove(next);
                    next++;
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }
}
