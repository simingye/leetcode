package Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by SimingYe on 2/2/16.
 */
public class Permutations2
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        List<Integer> element = new ArrayList<>();
        boolean[] array = new boolean[nums.length];

        dfs(result, element, nums, array);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int[] nums, boolean[] array)
    {
        if (element.size() == nums.length)
        {
            List<Integer> temp = new ArrayList<>(element);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (array[i] == false)
            {
                element.add(nums[i]);
                array[i] = true;
                dfs(result, element, nums, array);
                element.remove(element.size() - 1);
                array[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations2 test = new Permutations2();
        int[] nums = {1,2,3};
        test.permute(nums);
    }
}
