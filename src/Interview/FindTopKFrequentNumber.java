package Interview;

import java.util.*;

/**
 * Created by Siming on 11/10/15.
 */
public class FindTopKFrequentNumber
{
//    public String[] findTopKFrequentWord(String[] words, int k)
//    {
//        String[] result = new String[k];
//
//        if (words == null || words.length == 0)
//            return result;
//
//        Map<String, Integer> map = new HashMap<>();
//
//        for (String str : words)
//        {
//            if (map.containsKey(str))
//            {
//                map.put(str, map.get(str) + 1);
//            }
//            else
//            {
//                map.put(str, 1);
//            }
//        }
//
//        Comparator<Integer> c = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        };
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, c);
//
//        for (Map.Entry<String, Integer> entry : map.entrySet())
//        {
//            if (minHeap.size() < k)
//            {
//                minHeap.add(entry.getValue());
//            }
//            else
//            {
//                if (entry.getValue() > minHeap.peek())
//                {
//                    minHeap.poll();
//                    minHeap.add(entry.getValue());
//                }
//            }
//        }
//    }

    public int[] findTopKFrequentNumber(int[] nums, int k)
    {
        int[] results = new int[k];

        if (nums == null || nums.length == 0)
            return results;

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, c);

        for (int i = 0; i < nums.length; i++)
        {
            if (i < k)
            {
                minHeap.add(nums[i]);
            }
            else
            {
                if (nums[i] > minHeap.peek())
                {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        for (int i = 0; i < k; i++)
        {
            results[i] = minHeap.poll();
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4,4,6,6,7,8,8,8,8,9,9};
        FindTopKFrequentNumber test = new FindTopKFrequentNumber();
        System.out.println(test.findTopKFrequentNumber(nums, 3));
    }
}
