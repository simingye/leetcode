package TrappingRainWater;

/**
 * Created by SimingYe on 3/6/16.
 */
public class TrappingRainWater
{
    public int trapRainWater(int[] heights)
    {
        if (heights == null || heights.length == 0)
            return 0;

        int left = 0;
        int right = heights.length - 1;
        int result = 0;
        int smaller;

        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                smaller = heights[left];
                while (left < right && heights[left] <= smaller)
                {
                    result += smaller - heights[left];
                    left++;
                }
            }
            else
            {
                smaller = heights[right];
                while (left < right && heights[right] <= smaller)
                {
                    result += smaller - heights[right];
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test.trapRainWater(heights));
    }
}
