package PermutationsTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Siming on 9/9/15.
 */
public class PermutationsTwo
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();

        if (nums == null || nums.length == 0)
            return result;

        getPermute(result, nums, 0, map);

        return result;
    }

    public void getPermute(List<List<Integer>> result, int[] nums, int start, HashMap<List<Integer>, Integer> map)
    {
        List<Integer> list = convertToList(nums);

        if (start >= nums.length)
        {
            result.add(list);
            map.put(list, 1);
            return;
        }

        for (int i = start; i < nums.length; i++)
        {
            int tmp;
            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;

            if (map.containsKey(convertToList(nums)))
            {
                tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
                continue;
            }

            getPermute(result, nums, start+1, map);

            tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;

        }
    }

    public List<Integer> convertToList(int[] nums)
    {
        List<Integer> list = new ArrayList<>();

        for (int num : nums)
        {
            list.add(num);
        }

        return list;
    }

    public static void main(String[] args)
    {
        PermutationsTwo test = new PermutationsTwo();
        int[] nums = {1,1,2};
        System.out.println(test.permuteUnique(nums));
    }
}
