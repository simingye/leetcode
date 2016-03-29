package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 7/1/15.
 */
public class SummaryRanges
{
    public List<String> summaryRanges (int[] nums)
    {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        int head = nums[0];
        int last = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            int temp = nums[i];

            if (last + 1 != temp)
            {
                result.add(helper(head, last));
                head = nums[i];
                last = nums[i];
            }
            else
            {
                last = temp;
            }
        }

        result.add(helper(head, last));

        return result;
    }

    public String helper (int a, int b)
    {
        if (a == b)
            return a + "";
        else
            return a + "->" + b;
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] nums = {1,1,1,1,1,1};
        System.out.println(test.summaryRanges(nums));
    }
}
