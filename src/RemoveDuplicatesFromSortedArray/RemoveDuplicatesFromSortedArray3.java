package RemoveDuplicatesFromSortedArray;

/**
 * Created by SimingYe on 2/16/16.
 */
public class RemoveDuplicatesFromSortedArray3
{
    public int removeDuplicates(int[] nums)
    {
        if (nums == null)
            return 0;

        if (nums.length < 2)
            return nums.length;

        int length = nums.length;
        int slow = 0;
        int fast = 1;

        while (fast < length)
        {
            if (nums[fast] == nums[fast - 1])
            {
                while (fast < length && nums[fast] == nums[fast - 1])
                {
                    fast++;
                }
            }
            else
            {
                nums[slow+1] = nums[fast];
                slow++;
                fast++;
            }
        }

        return slow+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray3 test = new RemoveDuplicatesFromSortedArray3();
        int[] nums = {1,1,3};
        test.removeDuplicates(nums);
    }
}
