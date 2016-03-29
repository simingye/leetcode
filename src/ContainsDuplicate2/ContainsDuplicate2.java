package ContainsDuplicate2;

import java.util.HashMap;

/**
 * Created by Siming on 6/19/15.
 */
public class ContainsDuplicate2
{
    public boolean containsNearbyDuplicate (int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return false;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                int diff = map.get(nums[i]) - i;

                if (Math.abs(diff) <= k)
                    return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 test = new ContainsDuplicate2();
        int[] nums = {1,0,1,1};
        System.out.println(test.containsNearbyDuplicate(nums, 1));
    }
}
