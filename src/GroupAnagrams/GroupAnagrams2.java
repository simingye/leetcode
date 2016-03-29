package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SimingYe on 2/2/16.
 */
public class GroupAnagrams2
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0)
            return result;

        HashMap<String, List<String>> map = new HashMap<>();
        Arrays.sort(strs);

        for (int i = 0; i < strs.length; i++)
        {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String temp = String.valueOf(array);

            if (!map.containsKey(temp))
            {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(temp, list);
            }
            else
            {
                map.get(temp).add(strs[i]);
            }
        }

        for (List<String> list : map.values())
        {
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams2 test = new GroupAnagrams2();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        test.groupAnagrams(strs);
    }
}
