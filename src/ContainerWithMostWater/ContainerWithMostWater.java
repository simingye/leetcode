package ContainerWithMostWater;

/**
 * Created by Siming on 7/3/15.
 */
public class ContainerWithMostWater
{
    public int maxArea (int[] height)
    {
        int max = 0;
        int head = 0;
        int last = height.length - 1;

        while (head < last)
        {
            max = Math.max(max, (last - head) * Math.min(height[head], height[last]));

            if (height[head] < height[last])
            {
                head++;
            }
            else
            {
                last--;
            }
        }

        return max;
    }
}
