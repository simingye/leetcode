package ConbinationSumThree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 11/8/15.
 */
public class CombinationSumThree
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        dfs(result, item, k, n, 1, 0);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int k, int n, int start, int sum)
    {
        if (sum > n || item.size() > k)
            return;

        if (item.size() == k && sum == n)
        {
            List<Integer> temp = new ArrayList<>(item);
            result.add(temp);
            return;
        }

        for (int i = start; i <= 9; i++)
        {
            item.add(i);
            dfs(result, item, k, n, i + 1, sum+i);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumThree test = new CombinationSumThree();
        System.out.println(test.combinationSum3(3, 9));
    }
}
