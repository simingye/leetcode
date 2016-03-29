package MoveZeroes;

/**
 * Created by Siming on 10/1/15.
 */
public class MoveZeroes
{
    public void moveZeroes(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return;
        }

        int i = 0;
        int count = 1;
        while (i < nums.length && count <= nums.length)
        {
            if (nums[i] == 0)
            {
                for (int j = i+1; j < nums.length; j++)
                {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
            else
            {
                i++;
            }

            count++;
        }

        System.out.println(nums);
    }

    public static void main(String[] args) {
        MoveZeroes test = new MoveZeroes();
        int[] nums = {0,0,1};
        test.moveZeroes(nums);
    }
}
