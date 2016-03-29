package ValidParentheses;

/**
 * Created by Siming on 5/27/15.
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses
{
    public boolean isValid (String s)
    {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        if (s.length() <= 1 || s == null)
            return false;

        for (int i = 0; i < s.length(); i++)
        {
            // ( [ { situation
            if (map.keySet().contains(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }
            else if (stack.empty() == false && map.values().contains(s.charAt(i)))
            {
                if (map.get(stack.peek()) == s.charAt(i))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        if (stack.empty() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        System.out.println(test.isValid("()]"));
    }
}
