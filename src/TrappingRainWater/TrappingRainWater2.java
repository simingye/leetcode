package TrappingRainWater;

/**
 * Created by SimingYe on 3/10/16.
 */
public class TrappingRainWater2
{
    public int trapRainWater(int[] heights)
    {
        if (heights == null || heights.length == 0)
            return 0;

        int result = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                int smaller = heights[left];
                while (left < right && heights[left] <= smaller)
                {
                    result += smaller - heights[left];
                    left++;
                }
            }
            else
            {
                int smaller = heights[right];
                while (left < right && heights[right] <= smaller)
                {
                    result += smaller - heights[right];
                    right--;
                }
            }
        }

        return result;
    }
}
