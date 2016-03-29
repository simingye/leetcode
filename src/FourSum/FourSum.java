package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by SimingYe on 1/27/16.
 */
public class FourSum
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hashset = new HashSet<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                int first = j + 1;
                int last = nums.length - 1;

                while (first < last)
                {
                    int sum = nums[i] + nums[j] + nums[first] + nums[last];

                    if (sum == target)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[first]);
                        temp.add(nums[last]);

                        if (!hashset.contains(temp))
                        {
                            result.add(temp);
                            hashset.add(temp);
                        }

                        first++;
                        last--;
                    }
                    else if (sum < target)
                    {
                        first++;
                    }
                    else
                    {
                        last--;
                    }
                }
            }
        }

        return result;
    }
}
