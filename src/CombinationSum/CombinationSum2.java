package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SimingYe on 2/1/16.
 */
public class CombinationSum2
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return  result;

        Arrays.sort(candidates);
        List<Integer> element = new ArrayList<>();

        dfs(result, element, candidates, target, 0, 0);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int[] candidates, int target, int temp, int index)
    {
        if (temp == target)
        {
            List<Integer> list = new ArrayList<>(element);
            result.add(list);
            return;
        }

        if (temp > target)
            return;

        for (int i = index; i < candidates.length; i++)
        {
            element.add(candidates[i]);
            dfs(result, element, candidates, target, temp + candidates[i], i);
            element.remove(element.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 test = new CombinationSum2();
        int[] nums = {2,3,6,7};
        test.combinationSum(nums, 7);
    }
}
