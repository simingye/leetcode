package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/26/16.
 */
public class PalindromePartitioning3
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();

        if (s == null || s.length() == 0)
            return result;

        List<String> now = new ArrayList<>();

        dfs(result, now, s, 0);

        return result;
    }

    public void dfs(List<List<String>> result, List<String> now, String s, int start)
    {
        if (start == s.length())
        {
            List<String> temp = new ArrayList<>(now);
            result.add(temp);
            return;
        }

        for (int i = start; i < s.length(); i++)
        {
            if (isValid(s, start, i))
            {
                now.add(s.substring(start, i+1));
                dfs(result, now, s, i+1);
                now.remove(now.size() - 1);
            }
        }
    }

    public boolean isValid(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning3 test = new PalindromePartitioning3();
        System.out.println(test.partition("aab"));
    }
}
