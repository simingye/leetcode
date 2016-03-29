package ContainsDuplicateThree;

import java.util.TreeSet;

/**
 * Created by Siming on 11/8/15.
 */
public class ContainsDuplicateThree
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (nums == null || nums.length == 0 || k < 1 || t < 0)
            return false;

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];

            if ((treeSet.floor(num) != null && num <= treeSet.floor(num) + t)
                    || (treeSet.ceiling(num) != null && num >= treeSet.ceiling(num) - t))
            {
                return true;
            }

            treeSet.add(num);

            if (i >= k)
            {
                treeSet.remove(nums[i - k]);
            }
        }

        return false;
    }
}
