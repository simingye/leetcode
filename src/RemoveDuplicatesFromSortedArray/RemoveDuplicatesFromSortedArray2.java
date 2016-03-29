package RemoveDuplicatesFromSortedArray;

/**
 * Created by SimingYe on 1/28/16.
 */
public class RemoveDuplicatesFromSortedArray2
{
    public int removeDuplicates(int[] nums)
    {
        if (nums == null)
            return 0;

        if (nums.length < 2)
            return nums.length;

        int i = 0;
        int j = 1;

        while (j < nums.length)
        {
            if (nums[j] == nums[j - 1])
            {
                j++;
            }
            else
            {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 test = new RemoveDuplicatesFromSortedArray2();
        int[] nums = {1,1,1,2,3,4};
        System.out.println(test.removeDuplicates(nums));
    }
}
