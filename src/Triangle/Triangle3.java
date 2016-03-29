package Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/23/16.
 */
public class Triangle3
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle == null)
            return 0;

        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;

        for (int i = 0; i < triangle.get(l).size(); i++)
        {
            total[i] = triangle.get(l).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--)
        {
            for (int j = 0; j < triangle.get(i+1).size() - 1; j++)
            {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
            }
        }

        return total[0];
    }

    public static void main(String[] args) {
        Triangle3 test = new Triangle3();
        List<Integer> list = new ArrayList<>();
        list.add(-10);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list);

        System.out.println(test.minimumTotal(triangle));
    }
}
