package LongestConsecutiveSequece;

import java.util.HashSet;

/**
 * Created by Siming on 10/13/15.
 */
public class LongestConsecutiveSequence
{
    public int longestConsecitive(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums)
        {
            set.add(i);
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (set.contains(nums[i]))
            {
                int count = 1;
                int next = nums[i] - 1;

                while (set.contains(next))
                {
                    set.remove(next);
                    count++;
                    next--;
                }

                next = nums[i] + 1;
                while (set.contains(next))
                {
                    set.remove(next);
                    count++;
                    next++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,200,300,400};
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        System.out.println(test.longestConsecitive(nums));
    }
}
