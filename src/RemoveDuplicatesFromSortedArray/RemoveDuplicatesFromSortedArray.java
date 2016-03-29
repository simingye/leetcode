package RemoveDuplicatesFromSortedArray;

/**
 * Created by Siming on 5/28/15.
 */

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
   Given input array nums = [1,1,2],
   Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
   It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray
{
    public int removeDuplicates (int[] nums)
    {
        int pointer1 = 1;
        int pointer2 = 1;

        if (nums.length <= 1)
            return nums.length;

        int tempNum = nums[0];

        while (pointer1 < nums.length)
        {
            if (tempNum == nums[pointer1])
            {
                pointer1++;
            }
            else
            {
                tempNum = nums[pointer1];
                nums[pointer2] = tempNum;
                pointer1++;
                pointer2++;
            }
        }

        return pointer2;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,1,2,3,4,5,6};
        System.out.println(test.removeDuplicates(nums));
    }
}
