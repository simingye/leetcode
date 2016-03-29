package LongestPalindromicSubstring;

import java.util.HashMap;

/**
 * Created by Siming on 7/3/15.
 */
public class LongestPalindromicSubstring
{
//    public  String longestPalidrome (String s)
//    {
//        HashMap<Integer, String> map = new HashMap<>();
//        int result = 0;
//
//        for (int i = 0; i < s.length(); i++)
//        {
//            for (int j = i+1; j <= s.length(); j++)
//            {
//                if (isPalidrome(s.substring(i, j)))
//                {
//                    map.put(s.substring(i, j).length(), s.substring(i, j));
//                }
//            }
//        }
//
//        for (int element : map.keySet())
//        {
//            if (result <= element)
//                result = element;
//        }
//
//        return map.get(result);
//    }

    public  String longestPalidrome (String s)
    {
        if (s.isEmpty())
            return null;

        if (s == null)
            return null;

        String result = "";

        for (int i = 0; i < s.length(); i++)
        {
            if (result.length() <= getPalidrome(s, i, i).length())
            {
                result = getPalidrome(s, i, i);
            }

            if (result.length() <= getPalidrome(s, i, i+1).length())
            {
                result = getPalidrome(s, i, i+1);
            }
        }

        return result;
    }

    public String getPalidrome (String str, int head, int last)
    {
        while (head >= 0 && last < str.length() && str.charAt(head) == str.charAt(last))
        {
            head--;
            last++;
        }

        return str.substring(head+1, last);
    }

//    public boolean isPalidrome (String str)
//    {
//        StringBuilder sb = new StringBuilder(str);
//        StringBuilder temp = new StringBuilder(str);
//
//        if (sb.reverse().toString().equals(temp.toString()))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }

    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalidrome("abcdcbadgfdgdf"));
    }
}
