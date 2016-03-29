package SubsetsTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siming on 9/30/15.
 */
public class SubsetsTwo
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        for (int i = 1; i <= nums.length; i++)
        {
            dfs(nums, result, item, 0, i);
        }

        result.add(new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> item, int start, int length)
    {
        if (item.size() == length)
        {
            List<Integer> temp = new ArrayList<>(item);
            result.add(temp);
        }

        for (int i = start; i < nums.length; i++)
        {
            if (i > start && nums[i] == nums[i-1])
                continue;

            item.add(nums[i]);
            dfs(nums, result, item, i + 1, length);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetsTwo test = new SubsetsTwo();
        int[] nums = {1,2,2};
        System.out.println(test.subsetsWithDup(nums));
    }
}
