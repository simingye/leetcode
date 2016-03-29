package ContainerWithMostWater;

/**
 * Created by SimingYe on 3/11/16.
 */
public class ContainerWithMostWater3
{
    public int maxArea(int[] heights)
    {
        if (heights == null || heights.length <=1)
            return 0;

        int left = 0;
        int right = heights.length - 1;
        int result = 0;

        while (left < right)
        {
            while (left < right && heights[left] <= heights[right])
            {
                int area = (right - left) * heights[left];
                result = Math.max(result, area);
                left++;
            }

            while (left < right && heights[left] > heights[right])
            {
                int area = (right - left) * heights[right];
                result = Math.max(result, area);
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater3 test = new ContainerWithMostWater3();
        int[] heights = {1,3,2};
        System.out.println(test.maxArea(heights));
    }
}
