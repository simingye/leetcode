package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by SimingYe on 2/19/16.
 */
public class MinimumSlidingWindow
{
    public int[] minSlidingWindow(int[] nums, int k)
    {
        if (nums == null || nums.length < k || nums.length == 0)
            return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++)
        {
            if (!deque.isEmpty() && deque.peek() == i - k)
            {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] > nums[i])
            {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i-k+1 >= 0)
            {
                result[i-k+1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumSlidingWindow test = new MinimumSlidingWindow();
        int[] nums = {4,2,12,11,-5,2,7,9};
        test.minSlidingWindow(nums, 2);
    }
}
