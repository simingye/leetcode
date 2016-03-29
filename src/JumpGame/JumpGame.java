package JumpGame;

/**
 * Created by Siming on 9/11/15.
 */
public class JumpGame
{
    public boolean canJump(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return false;

        if (range(nums, nums.length) >= nums.length - 1)
            return true;
        else
            return false;
    }

    public int range(int[] nums, int n)
    {
        int max = 0;

        for (int i = 0; i < n; i++)
        {
            if (max < i || max >= n - 1)
                break;

            max = Math.max(max, i + nums[i]);
        }

        return max;
    }

//    public int range(int[] nums, int position)
//    {
//        if (position >= nums.length)
//            return 0;
//
//        int localRange = nums[position];
//
//        int global = localRange;
//
//        for (int i = 0; i < localRange; i++)
//        {
//            global = Math.max(global, range(nums, position+1));
//        }
//
//        return global;
//    }

    public static void main(String[] args) {
        JumpGame test = new JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.println(test.canJump(nums));
    }
}
