package SearchForaRange;

/**
 * Created by Siming on 9/3/15.
 */
public class SearchForaRange
{
    public int[] searchRange(int[] nums, int target)
    {
        int lastTarget = 0;
        int firstTarget = findTarget(nums, 0, nums.length-1, target);

        if (firstTarget == -1)
        {
            int[] result = new int[2];
            result[0] = -1;
            result[1] = -1;

            return result;
        }

        for (int i = firstTarget; i < nums.length; i++)
        {
            if (nums[i] != target)
            {
                lastTarget = i - 1;
                break;
            }

            if (i == nums.length - 1 && nums[i] == target)
            {
                lastTarget = i;
                break;
            }
        }

        int[] result = new int[2];
        result[0] = firstTarget;
        result[1] = lastTarget;

        return result;
    }

    public int findTarget(int[] nums, int left, int right, int target)
    {
        if (left == right && nums[left] == target)
            return right;

        if (left == right && nums[left] != target)
            return -1;

        if (nums[((left + right) / 2)] < target && left < right)
        {
            left = ((left + right) / 2) + 1;
            return findTarget(nums, left, right, target);
        }
        else if (nums[((left + right) / 2)] > target && left < right)
        {
            right = ((left + right) / 2) - 1;
            return  findTarget(nums, left, right, target);
        }
        else if (nums[((left + right) / 2)] == target && left < right)
        {
            right = ((left + right) / 2);
            return findTarget(nums, left, right, target);
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchForaRange test = new SearchForaRange();
        int[] nums = {1,4};
        int[] result;
        result = test.searchRange(nums, 4);
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }
}
