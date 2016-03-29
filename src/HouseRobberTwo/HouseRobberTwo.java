package HouseRobberTwo;

/**
 * Created by SimingYe on 1/14/16.
 */
public class HouseRobberTwo
{
    public int rob(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int[] opt = new int[nums.length];

        opt[0] = 0;
        opt[1] = nums[0];

        for (int i = 2; i < nums.length; i++)
        {
            opt[i] = Math.max(opt[i - 1], opt[i - 2] + nums[i - 1]);
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(opt[nums.length - 1], dp[nums.length - 1]);
    }

    public static void main(String[] args) {
        HouseRobberTwo test = new HouseRobberTwo();
        int[] nums = {1,1,1};
        System.out.println(test.rob(nums));
    }
}
