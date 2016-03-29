package CombinationSumTwo;

import com.sun.deploy.net.CanceledDownloadException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by SimingYe on 2/1/16.
 */
public class CombinationSumTwo2
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);
        List<Integer> element = new ArrayList<>();

        dfs(result, element, 0, candidates, target, 0);

        HashSet<List<Integer>> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int index, int[] candidates, int target, int temp)
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
            dfs(result, element, i + 1, candidates, target, temp + candidates[i]);
            element.remove(element.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumTwo2 test = new CombinationSumTwo2();
        int[] nums = {10,1,2,7,6,1,5};
        test.combinationSum2(nums, 8);
    }
}
