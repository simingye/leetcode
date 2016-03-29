package SingleNumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Siming on 10/23/15.
 */
public class SingleNumber
{
    public int singleNumber(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int result = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            result ^= nums[i];
        }

        return result;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int result = 0;
//
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (map.containsKey(nums[i]))
//            {
//                map.put(nums[i], 2);
//            }
//            else
//            {
//                map.put(nums[i], 1);
//            }
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet())
//        {
//            if (entry.getValue() == 1)
//            {
//                result = entry.getKey();
//            }
//        }

//        return result;
    }

    public static void main(String[] args) {
        SingleNumber test = new SingleNumber();
        int[] nums = {2,2,1};
        System.out.println(test.singleNumber(nums));
    }
}
