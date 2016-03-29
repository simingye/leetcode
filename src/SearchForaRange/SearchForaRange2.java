package SearchForaRange;

/**
 * Created by SimingYe on 1/29/16.
 */
public class SearchForaRange2
{
    public int[] searchRange(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
            return null;

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int begin = 0;
        int end = nums.length - 1;

        int first = 0;
        int last = 0;

        while (begin <= end)
        {
            int mid = (begin + end) / 2;

            if (nums[mid] == target)
            {
                first = mid;
                last = mid;

                while (first >= 0 && nums[first] == nums[mid])
                {
                    first--;
                }

                while (last < nums.length && nums[last] == nums[mid])
                {
                    last++;
                }

                result[0] = first + 1;
                result[1] = last - 1;

                return result;
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

        return result;
    }

    public static void main(String[] args) {
        SearchForaRange2 test = new SearchForaRange2();
        int[] nums = {1};
        System.out.println(test.searchRange(nums, 1));
    }
}
