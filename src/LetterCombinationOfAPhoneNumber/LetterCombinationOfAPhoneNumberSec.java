package LetterCombinationOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Siming on 10/16/15.
 */
public class LetterCombinationOfAPhoneNumberSec
{
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();
        List<String> item = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return  result;

        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        dfs(digits, 0, result, item, map);

        return result;
    }

    public void dfs(String digits, int start, List<String> result, List<String> item, HashMap<String, String> map)
    {
        if (start > digits.length())
            return;

        if (start == digits.length())
        {
            List<String> temp = new ArrayList<>(item);
            result.add(temp.toString());
            return;
        }

        if (map.containsKey(digits.substring(start, start+1)))
        {
            for (int i = 0; i < map.get(digits.substring(start, start+1)).length(); i++)
            {
                item.add(map.get(digits.substring(start, start+1)).substring(i, i+1));
                dfs(digits, start+1, result, item, map);
                item.remove(item.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumberSec test = new LetterCombinationOfAPhoneNumberSec();
        System.out.println(test.letterCombinations("23"));
    }
}
