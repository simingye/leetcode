package DataStreamMedian;

import AddBinary.AddBinary;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by SimingYe on 3/8/16.
 */
public class DataStreamMedian
{
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public int[] medianII(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return nums;

        int length = nums.length;

        maxHeap = new PriorityQueue<>(length, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>(length);

        int[] result = new int[length];
        for (int i = 0; i < nums.length; i++)
        {
            addNumber(nums[i]);
            result[i] = maxHeap.peek();
        }

        return result;
    }

    public void addNumber(int value)
    {
        if (maxHeap.isEmpty() || value < maxHeap.peek())
        {
            maxHeap.add(value);
        }
        else
        {
            minHeap.add(value);
        }

        if (minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }

        if (maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.add(maxHeap.poll());
        }
    }
}
