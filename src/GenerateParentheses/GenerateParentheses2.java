package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 1/27/16.
 */
public class GenerateParentheses2
{
    public List<String> generateParenthesis(int n)
    {
        List<String> result = new ArrayList<>();

        if (n <= 0)
            return result;

        int left = 0;
        int right = 0;
        List<String> temp = new ArrayList<>();

        dfs(result, left, right, temp, n);

        return result;
    }

    public void dfs(List<String> result, int left, int right, List<String> temp, int n)
    {
        if (right > left || right > n || left > n)
        {
            return;
        }
        else
        {
            if (temp.size() == 2 * n && left == n && right == n)
            {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < temp.size(); i++)
                {
                    sb.append(temp.get(i));
                }

                result.add(sb.toString());
                return;
            }

            temp.add("(");
            dfs(result, left + 1, right, temp, n);
            temp.remove(temp.size() -1);

            temp.add(")");
            dfs(result, left, right + 1, temp, n);
            temp.remove(temp.size() -1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses2 test = new GenerateParentheses2();
        test.generateParenthesis(1);
    }
}
