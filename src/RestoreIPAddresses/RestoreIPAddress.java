package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/1/15.
 */
public class RestoreIPAddress
{
    public List<String> restoreIpAddresses(String s)
    {
        List<List<String>> result = new ArrayList<>();
        List<String> finalResult = new ArrayList<>();
        List<String> item = new ArrayList<>();

        if (s == null || s.length() > 12 || s.length() < 4)
            return finalResult;

        dfs(result, s, 0, item);

        for (List<String> l : result)
        {
            StringBuilder sb = new StringBuilder();
            for (String str : l)
            {
                sb.append(str + ".");
            }
            sb.setLength(sb.length()-1);
            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    public void dfs(List<List<String>> result, String s, int start, List<String> item)
    {
        if (item.size() >= 4 && start != s.length())
        {
            return;
        }

        if ((item.size()+s.length()-start+1) < 4)
        {
            return;
        }

        if (item.size() == 4 && s.length() == start)
        {
            List<String> temp = new ArrayList<>(item);
            result.add(temp);
            return;
        }

        for (int i = 1; i <= 3; i++)
        {
            if ((start + i) > s.length())
            {
                break;
            }

            String sub = s.substring(start, start+i);
            if (i > 1 && s.charAt(start) == '0')
            {
                break;
            }

            if (Integer.valueOf(sub) > 255)
                break;

            item.add(sub);
            dfs(result, s, start+i, item);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress test = new RestoreIPAddress();
        System.out.println(test.restoreIpAddresses("25525511135"));
//        System.out.println("1234".substring(3, 4));
    }
}
