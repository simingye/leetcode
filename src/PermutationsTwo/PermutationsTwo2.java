package PermutationsTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SimingYe on 2/2/16.
 */
public class PermutationsTwo2
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        List<Integer> element = new ArrayList<>();
        boolean[] array = new boolean[nums.length];
        dfs(result, element, nums, array);

        return result;
    }

    public void dfs(List<List<Integer>> tempResult, List<Integer> element, int[] nums, boolean[] array)
    {
        if (element.size() == nums.length)
        {
            List<Integer> temp = new ArrayList<>(element);
            tempResult.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1] && array[i] == false)
                continue;

            if (array[i] == false)
            {
                element.add(nums[i]);
                array[i] = true;
                dfs(tempResult, element, nums, array);
                element.remove(element.size() - 1);
                array[i] = false;
            }
        }
    }
}
