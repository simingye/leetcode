package SlidingWindowMedian;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by SimingYe on 3/7/16.
 */
public class SlidingWindowMedian
{
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k)
    {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0 || k > nums.length)
            return result;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.length; i++)
        {
            if (maxHeap.isEmpty() || nums[i] < maxHeap.peek())
            {
                maxHeap.add(nums[i]);
            }
            else
            {
                minHeap.add(nums[i]);
            }

            if (minHeap.size() > maxHeap.size())
            {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size() + 1)
            {
                minHeap.add(maxHeap.poll());
            }

            if (i >= k-1)
            {
                result.add(maxHeap.peek());

                int toRemove = nums[i-k+1];
                if (toRemove <= maxHeap.peek())
                {
                    maxHeap.remove(toRemove);
                }
                else
                {
                    minHeap.remove(toRemove);
                }

                if (minHeap.size() > maxHeap.size())
                {
                    maxHeap.add(minHeap.poll());
                }

                if (maxHeap.size() > minHeap.size()+1)
                {
                    minHeap.add(maxHeap.poll());
                }
            }
        }

        return result;
    }
}
