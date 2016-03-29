package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by SimingYe on 2/18/16.
 */
public class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || nums.length < k)
            return null;

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++)
        {
            if (!deque.isEmpty() && deque.peek() == i - k)
            {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
            {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i -k + 1 >= 0)
            {
                result[i-k+1] = nums[deque.peek()];
            }
        }

        return result;
    }
}
