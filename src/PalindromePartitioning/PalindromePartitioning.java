package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/22/15.
 */
public class PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        List<String> item = new ArrayList<>();

        if (s == null || s.length() == 0)
            return result;

        dfs(s, result, item, 0);

        return result;
    }

    public void dfs(String s, List<List<String>> result, List<String> item, int start)
    {
        if (start == s.length())
        {
            List<String> temp = new ArrayList<>(item);
            result.add(temp);
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (isPalindrome(s, start, i))
            {
                item.add(s.substring(start, i + 1));
                dfs(s, result, item, i+1);
                item.remove(item.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        return true;
    }
}
