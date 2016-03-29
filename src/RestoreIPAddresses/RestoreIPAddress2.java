package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/12/16.
 */
public class RestoreIPAddress2
{
    public List<String> restoreIpAddresses(String s)
    {
        List<List<String>> result = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();
        List<String> item = new ArrayList<>();

        if (s == null || s.length() == 0)
            return finalResult;

        dfs(result, item, s, 0);

        for (List<String> list : result)
        {
            StringBuilder sb = new StringBuilder();
            for (String str : list)
            {
                sb.append(str + ".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    public void dfs(List<List<String>> result, List<String> item, String s, int start)
    {
        if (item.size() >= 4 && start != s.length())
            return;

        if ((item.size() + s.length() - start + 1) < 4)
            return;

        if (item.size() == 4 && start == s.length())
        {
            List<String> temp = new ArrayList<>(item);
            result.add(temp);
            return;
        }

        for (int i = 1; i <= 3; i++)
        {
            if (start + i > s.length())
                break;

            String sub = s.substring(start, start+i);

            if (i > 1 && s.charAt(start) == '0')
                break;

            if (Integer.valueOf(sub) > 255)
                break;

            item.add(sub);
            dfs(result, item, s, start+i);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress2 test = new RestoreIPAddress2();
        test.restoreIpAddresses("0000");
    }
}
