package RemoveElement;

/**
 * Created by Siming on 5/28/15.
 */

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement
{
    public int removeElement (int[] nums, int val)
    {
        if (nums.length == 0)
            return 0;

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < nums.length)
        {
            if (val == nums[pointer1])
            {
                pointer1++;
            }
            else
            {
                nums[pointer2] = nums[pointer1];
                pointer1++;
                pointer2++;
            }
        }
        return pointer2;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] nums = {2};
        System.out.println(test.removeElement(nums, 3));
    }
}
