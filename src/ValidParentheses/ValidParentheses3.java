package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by SimingYe on 1/27/16.
 */
public class ValidParentheses3
{
    public boolean isValid(String s)
    {
        if (s == null || s.length() == 0)
            return true;

        s = s.trim();

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                stack.push(map.get(s.charAt(i)));
            }
            else
            {
                if (stack.isEmpty() || s.charAt(i) != stack.pop())
                {
                    return false;
                }
            }
        }

        if (!stack.isEmpty())
        {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParentheses3 test = new ValidParentheses3();
        System.out.println(test.isValid("({)}[]"));
    }
}
