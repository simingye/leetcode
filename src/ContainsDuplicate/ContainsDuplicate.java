package ContainsDuplicate;

import java.util.HashMap;

/**
 * Created by Siming on 6/19/15.
 */
public class ContainsDuplicate
{
    public boolean containsDuplicate (int[] nums)
    {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }

        if (map.size() != nums.length)
            return true;
        else
            return false;
    }
}
