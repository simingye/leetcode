package SimplifyPath;

import java.util.Stack;

/**
 * Created by Siming on 9/19/15.
 */
public class SimplifyPath
{
    public String simplifyPath(String path)
    {
        String[] inputs = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder("/");
        Stack<String> temp = new Stack<>();

        if (path == null || path.length() == 0)
            return result.toString();

        for (int i = 0; i < inputs.length; i++)
        {
            if (inputs[i].equalsIgnoreCase("") || inputs[i].equalsIgnoreCase("."))
            {
                continue;
            }

            if (inputs[i].equalsIgnoreCase(".."))
            {
                if (stack.isEmpty())
                {
                    continue;
                }
                else
                {
                    stack.pop();
                    continue;
                }
            }

            stack.push(inputs[i]);
        }

        while (!stack.isEmpty())
        {
            temp.push(stack.pop());
        }

        while (!temp.empty())
        {
            if (temp.size() > 1)
            {
                result.append(temp.pop() + "/");
            }
            else
            {
                result.append(temp.pop());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath test = new SimplifyPath();
        System.out.println(test.simplifyPath("/abc/..."));
    }
}
