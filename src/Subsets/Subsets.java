package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Siming on 9/28/15.
 */
public class Subsets
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        for (int i = 1; i <= nums.length; i++)
        {
            List<Integer> item = new ArrayList<>();
            dfs(nums, 0, i, result, item);
        }

        result.add(new ArrayList<Integer>());

        return result;
    }

    public void dfs(int[] nums, int start, int length, List<List<Integer>> result, List<Integer> item)
    {
        if (item.size() == length)
        {
            List<Integer> temp = new ArrayList<>(item);
//            Collections.sort(temp);
            result.add(temp);
            return;
        }

        for (int i = start; i < nums.length; i++)
        {
            item.add(nums[i]);
            dfs(nums, i+1, length, result, item);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(test.subsets(nums));
    }
}
