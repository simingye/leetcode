package MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siming on 6/15/15.
 */
public class MajorityElement
{
    public int majorityElement (int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
        {
            if (!map.containsKey(nums[i]))
            {
                map.put(nums[i], 1);
            }
            else
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (int key : map.keySet())
        {
            if (map.get(key) > nums.length / 2)
            {
                return key;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] a = {2,2};
        System.out.println(test.majorityElement(a));
    }
}
