package DifferentWaysToAddParenteses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 1/19/16.
 */
public class DifferentWaysToAddParenteses
{
    public List<Integer> diffWaysToCompute(String input)
    {
        List<Integer> result = new ArrayList<>();

        if (input == null || input.length() == 0)
            return result;

        for (int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);

            if (!isOperator(c))
            {
                continue;
            }

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));

            for (int num1 : left)
            {
                for (int num2 : right)
                {
                    int val = calculate(num1, num2, c);
                    result.add(val);
                }
            }
        }

        if (result.isEmpty())
        {
            result.add(Integer.valueOf(input));
        }

        return result;
    }

    public int calculate(int num1, int num2, char c)
    {
        int res = 0;

        switch (c)
        {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
        }

        return res;
    }

    public boolean isOperator(char c)
    {
        return (c == '+') || (c == '-') || (c == '*');
    }
}
