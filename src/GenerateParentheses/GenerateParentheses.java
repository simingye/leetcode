package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 8/27/15.
 */
public class GenerateParentheses
{
    public List<String> generateParenthesis(int n)
    {
        if (n <= 0)
            return null;

        List<String> result = new ArrayList<String>();

        dfs(result, "", n, n);

        return result;
    }

    public void dfs(List<String> result, String temp, int left, int right)
    {
        //(()))
        if (left > right)
        {
            return;
        }
        else if (left == right && left == 0)
        {
            result.add(temp);
            return;
        }

        if (left > 0)
        {
            dfs(result, temp + "(", left - 1, right);
        }

        if (right > 0)
        {
            dfs(result, temp + ")", left, right - 1);
        }
    }

//    public void dfs(List<String> result, String s, int left, int right)
//    {
//        if (left == 0 && right == 0)
//        {
//            result.add(s);
//            return;
//        }
//
//        if (left > right)
//            return;
//
//        if (left > 0)
//        {
//            dfs(result, s+"(", left - 1, right);
//        }
//
//        if (right > 0)
//        {
//            dfs(result, s+")", left, right - 1);
//        }
//    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParenthesis(3));
    }
}
