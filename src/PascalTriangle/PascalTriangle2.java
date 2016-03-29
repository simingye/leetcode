package PascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/24/16.
 */
public class PascalTriangle2
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0)
            return result;

        for (int i = 1; i <= numRows; i++)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            if (i >= 2)
            {
                for (int j = 1; j < i; j++)
                {
                    if (j == i - 1)
                    {
                        temp.add(1);
                    }
                    else
                    {
                        temp.add(result.get(result.size()-1).get(j) + result.get(result.size()-1).get(j-1));
                    }
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle2 test = new PascalTriangle2();
        test.generate(5);
    }
}
