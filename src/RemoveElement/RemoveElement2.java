package RemoveElement;

import java.util.Arrays;

/**
 * Created by SimingYe on 1/28/16.
 */
public class RemoveElement2
{
    public int removeElement(int[] nums, int val)
    {
//        if (nums == null || nums.length == 0)
//            return 0;
//
//        int index = nums.length - 1;
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (nums[i] == val)
//            {
//                nums[i] = nums[index];
//                index--;
//            }
//        }
//
//        return index + 1;

        if (nums == null || nums.length == 0)
            return 0;

        int p1 = 0;
        int p2 = 0;

        while (p1 < nums.length)
        {
            if (val == nums[p1])
            {
                p1++;
            }
            else
            {
                nums[p2] = nums[p1];
                p1++;
                p2++;
            }
        }

        return p2 + 1;
    }

    public static void main(String[] args) {
        RemoveElement2 test = new RemoveElement2();
        int[] nums = {1,1,1,2,3,4};
        System.out.println(test.removeElement(nums, 1));
    }
}
