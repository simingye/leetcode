package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 3/27/16.
 */
public class WordBreak3
{
    public boolean wordBreak(String s, Set<String> dict)
    {
        if (dict.isEmpty() && s.isEmpty())
            return true;

        if (dict == null || dict.isEmpty())
            return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && dict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak3 test = new WordBreak3();
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("code");
        dict.add("abc");
        System.out.println(test.wordBreak("acode", dict));
    }
}
