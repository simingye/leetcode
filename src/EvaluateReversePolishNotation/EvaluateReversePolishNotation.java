package EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by Siming on 10/28/15.
 */
public class EvaluateReversePolishNotation
{
    public int evalRPN(String[] tokens)
    {
        if (tokens == null || tokens.length == 0)
            return 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {
            if (tokens[i].equals("+"))
            {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a + b));
            }
            else if (tokens[i].equals("-"))
            {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b - a));
            }
            else if (tokens[i].equals("*"))
            {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a * b));
            }
            else if (tokens[i].equals("/"))
            {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b / a));
            }
            else
            {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
