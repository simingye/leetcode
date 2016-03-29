package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/9/16.
 */
public class Combinations2
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || k <= 0)
            return result;

        List<Integer> list = new ArrayList<>();

        dfs(result, list, n, k, 1);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int n, int k, int start)
    {
        if (list.size() >= k)
        {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = start; i <= n; i++)
        {
            list.add(i);
            dfs(result, list, n, k, i+1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations2 test = new Combinations2();
        test.combine(4, 2);
    }
}
