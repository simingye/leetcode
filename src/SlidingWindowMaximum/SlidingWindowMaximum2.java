package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by SimingYe on 3/7/16.
 */
public class SlidingWindowMaximum2
{
    public List<Integer> maxSlidingWindow(int[] nums, int k)
    {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0 || k > nums.length)
            return result;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++)
        {
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
            {
                deque.pollLast();
            }

            deque.add(nums[i]);

            if (i > k-1 && deque.peekFirst() == nums[i-k])
            {
                deque.pollFirst();
            }

            if (i >= k-1)
            {
                result.add(deque.peekFirst());
            }
        }

        return result;
    }
}
