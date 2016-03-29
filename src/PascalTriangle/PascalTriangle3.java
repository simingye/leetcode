package PascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/22/16.
 */
public class PascalTriangle3
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0)
            return result;

        for (int i = 1; i <= numRows; i++)
        {
            List<Integer> list = new ArrayList<>();

            for (int j = 1; j <= i; j++)
            {
                if (j == 1 || j == i)
                {
                    list.add(1);
                }
                else
                {
                    int num = result.get(result.size() - 1).get(j - 2) + result.get(result.size() - 1).get(j - 1);
                    list.add(num);
                }
            }

            result.add(list);
        }

        return result;
    }
}
