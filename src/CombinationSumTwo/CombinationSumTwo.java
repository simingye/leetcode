package CombinationSumTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siming on 9/9/15.
 */
public class CombinationSumTwo
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
        {
            return result;
        }

        Arrays.sort(candidates);

        opt(result, temp, 0, target, candidates);

        return result;
    }

    public void opt(List<List<Integer>> result, List<Integer> temp, int j, int target, int[] candidates)
    {
        if (target == 0)
        {
            List<Integer> list = new ArrayList<>(temp);
            if (result.contains(list))
            {
                return;
            }
            else
            {
                result.add(list);
                return;
            }
        }

        for (int i = j; i < candidates.length; i++)
        {
            if (target < candidates[i])
            {
                return;
            }

            temp.add(candidates[i]);
            opt(result, temp, i + 1, target - candidates[i], candidates);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumTwo test = new CombinationSumTwo();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(test.combinationSum2(candidates, 8));
    }
}
