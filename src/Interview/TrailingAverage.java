package Interview;

/**
 * Created by Siming on 11/14/15.
 */
public class TrailingAverage
{
    public int[] averageSlidingWindow(int[]nums, int k)
    {
        int[] results = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        int average = 0;

        for (int i = left; i <= right; i++)
        {
            average += nums[i];
        }

        average /= k;
        results[0] = average;
        left++;
        right++;

        for (int i = 1; i <= nums.length - k; i++)
        {
            average = (average * k - nums[left - 1] + nums[right]) / k;
            results[i] = average;
            left++;
            right++;
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        TrailingAverage test = new TrailingAverage();
        System.out.println(test.averageSlidingWindow(nums, 3));
    }
}
