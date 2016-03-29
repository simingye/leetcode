package Interview;

import IntegerToRoman.IntegerToRoman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Siming on 11/18/15.
 */
public class combination
{
    public List<List<Integer>> com(Queue<Integer> nums)
    {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        dfs(results, item, 0, nums);

        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> item, int start, Queue<Integer> nums)
    {
        if (item.size() == 10 && nums.isEmpty())
        {
            List<Integer> temp = new ArrayList<>(item);
            if (!results.contains(temp))
            {
                results.add(temp);
                return;
            }
        }

        for (int i = start; i < 10; i++)
        {
            int temp = nums.poll();
            item.add(temp);
            dfs(results, item, start + 1, nums);
            item.remove(item.size() - 1);
            nums.add(temp);
        }
    }

    public static void main(String[] args) {
        combination test = new combination();
        Queue<Integer> nums = new LinkedList<>();
        nums.add(0);
        nums.add(0);
        nums.add(0);
        nums.add(0);
        nums.add(0);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(1);
        nums.add(1);

        test.com(nums);
    }
}
