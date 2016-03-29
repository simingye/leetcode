package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SimingYe on 2/9/16.
 */
public class Subsets2
{
    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++)
        {
            List<Integer> element = new ArrayList<>();
            dfs(result, element, nums, i, 0);
        }

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int[] nums, int size, int start)
    {
        if (element.size() >= size)
        {
            List<Integer> temp = new ArrayList<>(element);
            result.add(temp);
            return;
        }

        for (int i = start; i < nums.length; i++)
        {
            element.add(nums[i]);
            dfs(result, element, nums, size, i+1);
            element.remove(element.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets2 test = new Subsets2();
        int[] nums = {1,2,3};
        test.subsets(nums);
    }
}
