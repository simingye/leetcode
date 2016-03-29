package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Siming on 9/8/15.
 */
public class CombinationSum implements test
{


    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);

        opt(result, temp, 0, candidates, target);

        return result;
    }

    public void opt(List<List<Integer>> result, List<Integer> temp, int j, int[] candidates, int target)
    {
       if (target == 0)
       {
           List<Integer> list = new ArrayList<Integer>(temp);
           result.add(list);
           return;
       }

        for (int i = j; i < candidates.length; i++)
        {
            if (target < candidates[i])
            {
                return;
            }

            temp.add(candidates[i]);
            opt(result, temp, i, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args)
    {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(test.combinationSum(candidates, 7));
    }

    @Override
    public int sum(int x, int y)
    {
        return x+y;
    }
}
