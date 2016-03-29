package SearchInsertPosition;

/**
 * Created by Siming on 9/7/15.
 */
public class SearchInsertPosition
{
    public int searchInsert(int[] nums, int target)
    {
        if (nums == null)
            return 0;

        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 1)
        {
            if (target <= nums[0])
                return 0;
            else
                return 1;
        }

        int result = findPosition(nums, target, left, right);

        return result;
    }

    public int findPosition(int[] nums, int target, int left, int right)
    {
        if (left == right - 1)
        {
            if (target > nums[left] && target <= nums[right])
                return right;
            else if (target <= nums[left])
                return left;
            else if (target > nums[right])
                return right + 1;
        }

        if (left < right)
        {
            if (nums[(left + right) / 2] > target)
            {
                right = (left + right) / 2;
                return findPosition(nums, target, left, right);
            }
            else if (nums[(left + right) / 2] < target)
            {
                left = (left + right) / 2;
                return findPosition(nums, target, left, right);
            }
            else if (nums[(left + right) / 2] == target)
            {
                return (left + right) / 2;
            }
        }
        else
        {
//            result = (left + right) / 2;
            return nums[(left + right) / 2];
        }

        return 0;
    }

    public static void main(String[] args) {
        SearchInsertPosition test = new SearchInsertPosition();
        int[] nums = {1};
        System.out.println(test.searchInsert(nums, 2));
    }
}
