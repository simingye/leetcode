package IsomorphicStrings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Siming on 6/30/15.
 */
public class IsomorphicStrings
{
    public boolean isIsomorphic (String s, String t)
    {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        HashMap<Character, ArrayList<Integer>> map2 = new HashMap<Character, ArrayList<Integer>>();


        for (int i = 0; i < s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)) == false)
            {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(i);
                map.put(s.charAt(i), tempList);
            }
            else
            {
                ArrayList<Integer> tempList = map.get(s.charAt(i));
                tempList.add(i);
                map.put(s.charAt(i), tempList);
            }
        }

        for (int i = 0; i < t.length(); i++)
        {
            if (map2.containsKey(t.charAt(i)) == false)
            {
                ArrayList<Integer> tempList2 = new ArrayList<Integer>();
                tempList2.add(i);
                map2.put(t.charAt(i), tempList2);
            }
            else
            {
                ArrayList<Integer> tempList2 = map2.get(t.charAt(i));
                tempList2.add(i);
                map2.put(t.charAt(i), tempList2);
            }
        }

        for (char c : map.keySet())
        {
            if (!map2.containsValue(map.get(c)))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        IsomorphicStrings test = new IsomorphicStrings();
        System.out.println(test.isIsomorphic(s, t));
    }
}
