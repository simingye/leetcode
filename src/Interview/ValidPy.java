package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Siming on 11/15/15.
 */
public class ValidPy
{
    public boolean isValid(String[] str)
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int indent = 0;
        int shouldIndent = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        stack1.push(0);
        int startRow = 0;


        for (int i = 0; i < str.length; i++)
        {
            if (str[i].length() == 1 && str[i].charAt(0) == '\n')
            {
                startRow++;
                continue;
            }
            else
            {
                break;
            }
        }

        return helper(str, startRow, stack1, stack2, indent, shouldIndent, map, 0);
    }

    public boolean helper(String[] str, int start, Stack<Integer> stack1, Stack<Character> stack2, int indent, int shouldIndent, Map<Character, Character> map, int preCol)
    {
        int col = 0;
        for (int i = 0; i < str[start].length(); i++)
        {
            if (str[start].charAt(i) == ' ')
            {
                col++;
            }
            else
            {
                break;
            }
        }

        if (col > stack1.peek())
        {
            indent++;
            stack1.push(col);
        }

        if (shouldIndent > 0 && col <= preCol)
        {
            return false;
        }
        else if (shouldIndent > 0 && col > preCol)
        {
            shouldIndent = 0;
        }
        else if (shouldIndent == 0 && col > preCol)
        {
            return false;
        }

        while (indent > 0 && col < stack1.peek())
        {
            indent--;
            stack1.pop();
        }

        if (col != stack1.peek())
        {
            return false;
        }

        for (int i = 0; i < str[start].length(); i++)
        {
            if (map.containsKey(str[start].charAt(i)))
            {
                stack2.push(str[start].charAt(i));
            }
            else if (map.containsValue(str[start].charAt(i)))
            {
                if (!stack2.isEmpty() && map.get(stack2.peek()) == str[start].charAt(i))
                {
                    stack2.pop();
                }
                else
                {
                    return false;
                }
            }

            if (str[start].charAt(i) == ':')
            {
                shouldIndent++;
            }
        }

        if (start == str.length - 1)
        {
            if (!stack2.isEmpty())
                return false;
            else
                return true;
        }
        else
        {
            return helper(str, start + 1, stack1, stack2, indent, shouldIndent, map, col);
        }
    }

    public static void main(String[] args) {
        String line1 = "def func():\n";
        String line2 = "    a = 1\n";
        String line3 = "    print(a)\n";
        String[] strings = new String[3];
        strings[0] = line1;
        strings[1] = line2;
        strings[2] = line3;

        ValidPy test = new ValidPy();
        System.out.println(test.isValid(strings));
    }
}
