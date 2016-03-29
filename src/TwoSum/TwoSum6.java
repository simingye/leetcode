package TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SimingYe on 3/10/16.
 */
public class TwoSum6
{
    public int[] twoSum(int[] numbers, int target)
    {
        int[] result = new int[2];

        if (numbers == null || numbers.length == 0)
            return result;

        Map<Integer, Integer> map = new HashMap<>();

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if (!map.containsKey(numbers[i]))
            {
                map.put(target-numbers[i], i);
            }
            else
            {
                index1 = map.get(numbers[i]);
                index2 = i;
            }
        }

        if (index1 <= index2)
        {
            result[0] = index1+1;
            result[1] = index2+1;
        }
        else
        {
            result[0] = index2+1;
            result[1] = index1+1;
        }

        return result;
    }
}
