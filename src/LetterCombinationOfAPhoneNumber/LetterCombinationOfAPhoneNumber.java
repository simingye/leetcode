package LetterCombinationOfAPhoneNumber;

import IntegerToRoman.IntegerToRoman;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Siming on 7/10/15.
 */
public class LetterCombinationOfAPhoneNumber
{
    public List<String> letterCombinations (String digits)
    {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        List<String> result = new ArrayList<String>();

        if (digits.length() == 0 || digits == null)
            return result;

        ArrayList<Character> temp = new ArrayList<Character>();

        getString(result, temp, digits, map);

        return result;
    }

    public void getString(List<String> result, ArrayList<Character> temp, String digits, HashMap<Integer, String> map)
    {
        if (digits.equalsIgnoreCase(""))
        {
            String res = "";
            for (int i = 0; i < temp.size(); i++)
            {
                res += String.valueOf(temp.get(i));
            }

            result.add(res);
            return;
        }

        Integer digit = Integer.parseInt(digits.substring(0, 1));
        String str = map.get(digit);

        for (int i = 0; i < str.length(); i++)
        {
            temp.add(str.charAt(i));
            getString(result, temp, digits.substring(1), map);
            temp.remove(temp.size()-1);
        }
    }



    public static void main(String[] args) {
        LetterCombinationOfAPhoneNumber test = new LetterCombinationOfAPhoneNumber();
        System.out.println(test.letterCombinations("23"));
    }
}
