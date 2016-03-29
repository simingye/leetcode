package MajorityElementTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 11/9/15.
 */
public class MajorityElementTwo
{
    public List<Integer> majorityElement(int[] nums)
    {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Integer num1 = null;
        Integer num2 = null;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (num1 != null && nums[i] == num1.intValue())
            {
                count1++;
            }
            else if (num2 != null && nums[i] == num2.intValue())
            {
                count2++;
            }
            else if (count1 == 0)
            {
                num1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0)
            {
                num2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i : nums)
        {
            if (i == num1.intValue())
            {
                count1++;
            }
            else if (i == num2.intValue())
            {
                count2++;
            }
        }

        if (count1 > nums.length / 3)
        {
            result.add(num1);
        }

        if (count2 > nums.length / 3)
        {
            result.add(num2);
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElementTwo test = new MajorityElementTwo();
        int[] nums = {1,3};
        System.out.println(test.majorityElement(nums));
    }
}
