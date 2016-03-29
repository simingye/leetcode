package ContainerWithMostWater;

/**
 * Created by SimingYe on 1/26/16.
 */
public class ContainerWithMostWater2
{
    public int maxArea(int[] height)
    {
        if (height == null || height.length == 0)
            return 0;

        int result = 0;
        int head = 0;
        int end = height.length - 1;

        while (head < end)
        {
            result = Math.max(result, (end - head) * Math.min(height[head], height[end]));

            if (height[head] < height[end])
            {
                head++;
            }
            else
            {
                end--;
            }
        }

        return result;
    }
}
