package LetterCombinationOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SimingYe on 1/26/16.
 */
public class LetterCombinationOfAPhoneNumber3
{
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        HashMap<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");

        List<Character> temp = new ArrayList<>();

        dfs(result, digits, 0, temp, map);
        return result;
    }

    public void dfs(List<String> result, String digits, int index, List<Character> temp, HashMap<Character, String> map)
    {
        if (digits.length() == index)
        {
            char[] c = new char[temp.size()];
            for (int i = 0; i < temp.size(); i++)
            {
                c[i] = temp.get(i);
            }
            result.add(String.valueOf(c));
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++)
        {
            temp.add(letters.charAt(i));
            dfs(result, digits, index + 1, temp, map);
            temp.remove(temp.size() - 1);
        }
    }
}
