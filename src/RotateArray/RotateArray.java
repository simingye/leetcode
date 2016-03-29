package RotateArray;

/**
 * Created by Siming on 6/16/15.
 */
public class RotateArray
{
    public void rotate (int[] nums, int k)
    {
        int newPosition = 0;

        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            newPosition = (i + k) % nums.length;
            temp[newPosition] = nums[i];
        }

        for (int i = 0; i < temp.length; i++)
        {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] nums = {1,2};
        test.rotate(nums, 1);
    }
}
