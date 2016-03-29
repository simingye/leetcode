package Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/19/15.
 */
public class Triangle
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int[] opt = new int[triangle.size()];

        for (int i = 0; i < triangle.size(); i++)
        {
            opt[i] = triangle.get(triangle.size()-1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--)
        {
            for (int j = 0; j < triangle.get(i).size(); j++)
            {
                opt[j] = Math.min(opt[j], opt[j+1]) + triangle.get(i).get(j);
            }
        }

        return opt[0];
    }

    public static void main(String[] args) {
        List<Integer> one = new ArrayList<>();
        one.add(2);

        List<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);

        List<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);

        List<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);

        Triangle test = new Triangle();
        System.out.println(test.minimumTotal(triangle));
    }
}
