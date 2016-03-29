package PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/22/16.
 */
public class PascalTriangle23
{
    public List<Integer> getRow (int rowIndex)
    {
        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0)
            return result;

        result.add(1);

        for (int i = 1; i <= rowIndex; i++)
        {
            for (int j = i; j >= 1; j--)
            {
                if (j == i)
                {
                    result.add(1);
                }
                else
                {
                    result.set(j, result.get(j-1) + result.get(j));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle23 test = new PascalTriangle23();
        test.getRow(3);
    }
}
