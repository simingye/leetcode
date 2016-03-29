package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Siming on 10/13/15.
 */
public class ValidParenthesesSec
{
    public boolean isValid(String s)
    {
        if (s == null || s.length() == 0 || s.length() == 1)
            return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }
            else if (map.containsValue(s.charAt(i)))
            {
                if (!stack.empty() && map.get(stack.peek()) == s.charAt(i))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("["));
    }
}
