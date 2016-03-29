package SearchInsertPosition;

/**
 * Created by SimingYe on 1/29/16.
 */
public class SearchInsertPosition2
{
    public int searchInsert(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int begin = 0;
        int end = nums.length - 1;

        while (begin < end)
        {
            int mid = (begin + end) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                begin = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }

        if (target > nums[begin])
            return begin + 1;
        else
            return begin;
    }

    public static void main(String[] args) {
        SearchInsertPosition2 test = new SearchInsertPosition2();
        int[] nums = {1};
        System.out.println(test.searchInsert(nums, 1));
    }
}
