package SimplifyPath;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by SimingYe on 2/8/16.
 */
public class SimplifyPath2
{
    public String simplifyPath(String path)
    {
        if (path == null || path.length() == 0)
            return "";

        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        String result = "";

        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals(".") || array[i].equals(""))
            {
                continue;
            }
            else if (array[i].equals(".."))
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(array[i]);
            }
        }

        while (!stack.isEmpty())
        {
            result = "/" + stack.pop() + result;
        }

        if (result == "" || result.charAt(0) != '/')
        {
            result += "/" + result;
        }

        return result;
    }

    public static void main(String[] args) {
        SimplifyPath2 test = new SimplifyPath2();
        System.out.println(test.simplifyPath("/"));
    }
}
