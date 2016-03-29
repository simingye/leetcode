package Amazon;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by SimingYe on 2/18/16.
 */
public class ValidParentheses
{
    public boolean isValid(String s)
    {
        if (s == null || s.length() == 0)
            return true;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                stack.push(map.get(s.charAt(i)));
            }
            else
            {
                if (stack.isEmpty() || s.charAt(i) != stack.peek())
                {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
