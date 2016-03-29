package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by SimingYe on 3/28/16.
 */
public class EvaluateReversePolishNotation2
{
    public int evalRPN(String[] tokens)
    {
        if (tokens == null || tokens.length == 0)
            return 0;

        int result = 0;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (isNumber(tokens[i]))
            {
                stack.push(tokens[i]);
            }
            else
            {
                Character c = tokens[i].charAt(0);
                String s2 = stack.pop();
                String s1 = stack.pop();

                stack.push(compute(s1, s2, c));
            }
        }

        return Integer.valueOf(stack.peek());
    }

    public String compute(String s1, String s2, Character operator)
    {
        switch (operator)
        {
            case '+' :
                return String.valueOf(Integer.valueOf(s1) + Integer.valueOf(s2));
            case '-' :
                return String.valueOf(Integer.valueOf(s1) - Integer.valueOf(s2));
            case '*' :
                return String.valueOf(Integer.valueOf(s1) * Integer.valueOf(s2));
            case '/' :
                return String.valueOf(Integer.valueOf(s1) / Integer.valueOf(s2));
            default:
                return null;
        }
    }

    public boolean isNumber(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation2 test = new EvaluateReversePolishNotation2();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(test.evalRPN(tokens));

    }
}
