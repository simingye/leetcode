package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SimingYe on 1/26/16.
 */
public class ThreeSum2
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i == 0 || nums[i] > nums[i - 1])
            {
                int negate = -nums[i];
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end)
                {
                    if (nums[start] + nums[end] == negate)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);

                        result.add(temp);
                        start++;
                        end--;

                        while (start < end && nums[start] == nums[start - 1])
                        {
                            start++;
                        }

                        while (start < end && nums[end] == nums[end + 1])
                        {
                            end--;
                        }
                    }
                    else if (nums[start] + nums[end] < negate)
                    {
                        start++;
                    }
                    else if (nums[start] + nums[end] > negate)
                    {
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
