package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Siming on 11/13/15.
 */
public class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int[] results = new int[nums.length - k + 1];

        if (nums == null || nums.length == 0 || k > nums.length)
            return results;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++)
        {
            int now = nums[i];

            while (!deque.isEmpty() && now > deque.peekLast())
            {
                deque.pollLast();
            }

            deque.add(now);

            if (i > k-1 && deque.peekFirst() == nums[i-k])
            {
                deque.pollFirst();
            }

            if (i >= k-1)
            {
                results[i-k+1] = deque.peekFirst();
            }
        }

        return results;
    }
}
