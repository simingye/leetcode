package LongestConsecutiveSequece;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 3/23/16.
 */
public class LongestConsecutiveSequence3
{
    public int longestConsecutive(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++)
        {
            int count = 0;
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

        return result;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence3 test = new LongestConsecutiveSequence3();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(test.longestConsecutive(nums));
    }
}
