package HouseRobber;

/**
 * Created by Siming on 6/17/15.
 */

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each
 * of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber
{
    public int rob (int[] nums)
    {
        if (nums.length == 0 || nums == null)
            return 0;

        int[] opt = new int[nums.length + 1];

        opt[0] = 0;
        opt[1] = nums[0];

        for (int i = 2; i < nums.length + 1; i++)
        {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + nums[i - 1]);
        }

        return opt[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        int[] nums = {1, 2};
        System.out.println(test.rob(nums));
    }
}
