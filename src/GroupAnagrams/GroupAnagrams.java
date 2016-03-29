package GroupAnagrams;

import java.util.*;

/**
 * Created by Siming on 9/9/15.
 */
public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0)
            return result;

        Arrays.sort(strs);

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++)
        {
            if (map.containsKey(getAnagram(strs[i])))
            {
                map.put(getAnagram(strs[i]), map.get(getAnagram(strs[i])) + "/" + String.valueOf(i));
            }
            else
            {
                map.put(getAnagram(strs[i]), String.valueOf(i));
            }
        }

        for (String element : map.values())
        {
            String[] tempArray = element.split("/");
            List<String> res = new ArrayList<>();
            for (String ele : tempArray)
            {
                res.add(strs[Integer.parseInt(ele)]);
            }
            result.add(res);
        }

        return result;
    }

    public String getAnagram(String str)
    {
        char[] array = str.toCharArray();

        Arrays.sort(array);

        return String.valueOf(array);
    }

    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(test.groupAnagrams(strs));
    }
}
