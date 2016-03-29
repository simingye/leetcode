package PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 6/14/15.
 */
public class PascalTriangle2
{
    public List<Integer> getRow (int rowIndex)
    {
        List<Integer> result = new ArrayList<>();
        List<Integer> previous = new ArrayList<>();
        previous.add(1);
        previous.add(1);

        List<Integer> first = new ArrayList<Integer>();
        first.add(1);

        if (rowIndex < 0)
        {
            return  result;
        }

        if (rowIndex == 0)
        {
            return  first;
        }

        if (rowIndex == 1)
        {
            return  previous;
        }

        for (int i = 2; i <= rowIndex; i++)
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
            previous = current;
        }

        result = previous;

        return result;
    }
}
