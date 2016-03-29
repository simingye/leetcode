package RangeSumQuery;

/**
 * Created by SimingYe on 1/13/16.
 */
public class RangeSumQuery
{
    int[] array;

    public RangeSumQuery(int[] nums)
    {
        array = nums;
    }

    public int sumRange(int i, int j)
    {
        int result = 0;
        for (int m = i; m <= j; m++)
        {
            result += array[m];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        RangeSumQuery test = new RangeSumQuery(nums);
        System.out.println(test.sumRange(0,2));
    }
}
