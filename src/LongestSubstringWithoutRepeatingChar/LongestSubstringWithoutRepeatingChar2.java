package LongestSubstringWithoutRepeatingChar;

/**
 * Created by SimingYe on 1/25/16.
 */
public class LongestSubstringWithoutRepeatingChar2
{
    public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++)
        {
            char current = array[i];

            if (flag[current])
            {
                result = Math.max(result, i - start);
                for (int k = start; k < i; k++)
                {
                    if (array[k] == current)
                    {
                        start = k + 1;
                        break;
                    }
                    flag[array[k]] = false;
                }
            }
            else
            {
                flag[current] = true;
            }
        }

        result = Math.max(result, array.length - start);

        return result;
    }
}
