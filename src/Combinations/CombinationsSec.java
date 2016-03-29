package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/22/15.
 */
public class CombinationsSec
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        if (n <= 0 || k <= 0)
            return result;

        dfs(result, item, n, k, 1);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int n, int k, int start)
    {
        if (item.size() == k)
        {
            List<Integer> temp = new ArrayList<>(item);
            result.add(temp);
            return;
        }



        for (int i = start; i <= n; i++)
        {
            item.add(i);
            dfs(result, item, n, k, i+1);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationsSec test = new CombinationsSec();
        System.out.println(test.combine(4,2));
    }
}
