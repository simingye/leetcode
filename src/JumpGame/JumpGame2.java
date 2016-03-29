package JumpGame;

/**
 * Created by SimingYe on 2/3/16.
 */
public class JumpGame2
{
    public boolean canJump(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return false;

        int global = nums[0];
        int index = 0;
        int range = nums[0];

        while (index <= global && index < nums.length)
        {
            if (index == nums.length - 1)
            {
                return true;
            }

            range = index + nums[index];
            global = Math.max(global, range);
            index++;
        }

        return false;
    }
}
