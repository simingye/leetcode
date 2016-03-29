package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 9/28/15.
 */
public class Combinations
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        if (n <= 0 || k <= 0)
            return result;

        dfs(n, k, 1, result, item);

        return result;
    }

    public void dfs(int n, int k, int start, List<List<Integer>> result, List<Integer> item)
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
            dfs(n, k, i+1, result, item);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(4, 2));
    }
}
