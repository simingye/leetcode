package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/11/15.
 */
public class SummaryRangesSec
{
    public List<String> summaryRanges(int[] nums)
    {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        int start = 0;
        int end = 0;

        while (end < nums.length)
        {
            if (end < nums.length - 1 && ((nums[end] == nums[end+1] - 1) || nums[end] == nums[end+1]))
            {
                end++;
                continue;
            }

            if (end != start)
            {
                String temp = String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
                result.add(temp);
                end++;
                start = end;
            }
            else
            {
                String temp = String.valueOf(nums[end]);
                result.add(temp);
                end++;
                start = end;

            }
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRangesSec test = new SummaryRangesSec();
        int[] nums = {1,1,2};
        System.out.println(test.summaryRanges(nums));
    }
}
