package PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/25/16.
 */
public class PascalTriangle22
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0)
            return result;

        result.add(1);

       for (int i = 1; i <= rowIndex; i++)
        {
            for (int j = result.size() - 1; j >= 1; j--)
            {
                result.set(j, result.get(j)+result.get(j-1));
            }
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle22 test = new PascalTriangle22();
        test.getRow(3);
    }
}
