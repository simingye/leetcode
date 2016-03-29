package SortColors;

/**
 * Created by SimingYe on 2/9/16.
 */
public class SortColors2
{
    public void sortColors(int[] nums)
    {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return;

        int first = 0;
        int last = nums.length - 1;
        int index = 0;

        int temp;

        while (index <= last)
        {
            if (nums[index] == 0)
            {
                temp = nums[index];
                nums[index] = nums[first];
                nums[first] = temp;

                index++;
                first++;
                continue;
            }

            if (nums[index] == 2)
            {
                temp = nums[index];
                nums[index] = nums[last];
                nums[last] = temp;

                last--;
                continue;
            }

            index++;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SortColors2 test = new SortColors2();
        int[] nums = {2,1,1,0,0,2,1,0};
        test.sortColors(nums);
    }
}
