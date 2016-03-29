package BasicCalculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by SimingYe on 1/14/16.
 */
public class BasicCalculator
{
    public int calculate(String s)
    {
        s = s.replaceAll(" ", "");

        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == ' ')
                continue;;

            if (array[i] >= '0' && array[i] <= '9')
            {
                sb.append(array[i]);

                if (i == array.length - 1)
                {
                    stack.push(sb.toString());
                }
            }
            else
            {
                if (sb.length() > 0)
                {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }

                if (array[i] != ')')
                {
                    stack.push(String.valueOf(array[i]));
                }
                else
                {
                    ArrayList<String> t = new ArrayList<>();
                    while (!stack.isEmpty())
                    {
                        String top = stack.pop();
                        if (top.equals("("))
                        {
                            break;
                        }
                        else
                        {
                            t.add(0, top);
                        }
                    }

                    int temp = 0;
                    if (t.size() == 1)
                    {
                        temp = Integer.valueOf(t.get(0));
                    }
                    else
                    {
                        for (int j = t.size() - 1; j > 0; j = j - 2)
                        {
                            if (t.get(j - 1).equals("-"))
                            {
                                temp += 0 - Integer.valueOf(t.get(j));
                            }
                            else
                            {
                                temp += Integer.valueOf(t.get(j));
                            }
                        }
                        temp += Integer.valueOf(t.get(0));
                    }
                    stack.push(String.valueOf(temp));
                }
            }
        }

        ArrayList<String> t = new ArrayList<>();
        while (!stack.isEmpty())
        {
            String element = stack.pop();
            t.add(0, element);
        }

        int temp = 0;
        for (int j = t.size() - 1; j > 0; j = j - 2)
        {
            if (t.get(j - 1).equals("-"))
            {
                temp += 0 - Integer.valueOf(t.get(j));
            }
            else
            {
                temp += Integer.valueOf(t.get(j));
            }
        }
        temp += Integer.valueOf(t.get(0));

        return temp;
    }
}
