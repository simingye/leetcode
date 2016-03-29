package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 3/26/16.
 */
public class WordBreak2
{
    boolean result = false;

    public boolean wordBreak(String s, Set<String> wordDict)
    {
        if (wordDict == null || wordDict.isEmpty())
            return false;

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                if (wordDict.contains(s.substring(i, j + 1)))
                {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j < s.length(); j++)
            {
                for (int k = i; k < j; k++)
                {
                    if (!dp[i][j])
                    {
                        dp[i][j] = dp[i][k] && dp[k+1][j];
                    }
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        WordBreak2 test = new WordBreak2();
        Set<String> wordDict = new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");
//        wordDict.add("cracker");

        System.out.println(test.wordBreak("leetcode", wordDict));
    }
}
