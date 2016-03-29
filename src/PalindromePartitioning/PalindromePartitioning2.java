package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/1/16.
 */
public class PalindromePartitioning2
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;

        List<String> list = new ArrayList<>();
        dfs(result, list, s, 0);

        return result;
    }

    public void dfs(List<List<String>> result, List<String> list, String s, int index)
    {
        if (index >= s.length())
        {
            List<String> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }

        for (int i = index+1; i <= s.length(); i++)
        {
            if (isPalindrome(s.substring(index, i)))
            {
                list.add(s.substring(index, i));
                dfs(result, list, s, i);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 test = new PalindromePartitioning2();
        test.partition("aab");
    }
}
