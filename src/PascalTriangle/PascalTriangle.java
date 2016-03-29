package PascalTriangle;

/**
 * Created by Siming on 6/13/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle
{
    public List<List<Integer>> generate (int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
        previous.add(1);

        List<Integer> first = new ArrayList<Integer>();
        first.add(1);

        if (numRows < 0)
        {
            return  result;
        }

        if (numRows == 0)
        {
            return  result;
        }

        if (numRows == 1)
        {
            result.add(first);
            return  result;
        }

        if (numRows == 2)
        {
            result.add(first);
            result.add(previous);
            return  result;
        }

        result.add(first);
        result.add(previous);

        for (int i = 2; i < numRows; i++)
        {
            List<Integer> current = new ArrayList<Integer>();
            int nums = i + 1;
            for (int j = 0; j < nums; j++)
            {
                if (j == 0)
                {
                    current.add(1);
                }
                else if (j == nums - 1)
                {
                    current.add(1);
                }
                else
                {
                    current.add(previous.get(j) + previous.get(j - 1));
                }
            }
            result.add(current);
            previous = current;
        }

        return result;
    }
}
