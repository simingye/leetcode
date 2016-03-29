package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 9/9/15.
 */
public class Permutations
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            list.add(nums[i]);
        }

        if (nums == null || nums.length == 0)
        {
            return result;
        }

//        result.add(list);

        permute(result, 0, nums);

        return result;
    }

    public void permute(List<List<Integer>> result, int start, int[] nums)
    {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            list.add(nums[i]);
        }

        if (start >= nums.length)
        {
            result.add(list);
        }

        for (int i = start; i < nums.length; i++)
        {
            List<Integer> temp = new ArrayList<>(list);

            int tmp;
            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;

            System.out.println("before i=" + i + " start=" + start);
            permute(result, start + 1, nums);

            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
            System.out.println("after i=" + i + " start=" + start);
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(test.permute(nums));
    }
}
