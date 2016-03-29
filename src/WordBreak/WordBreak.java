package WordBreak;

import AddTwoNumbers.AddTwoNumbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Siming on 10/23/15.
 */
public class WordBreak
{
    public boolean wordBreak(String s, Set<String> wordDict)
    {
        boolean[] opt = new boolean[s.length()+1];
        opt[0] = true;

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; j >= 0; j--)
            {
                if (opt[j] && wordDict.contains(s.substring(j, i+1)))
                {
                    opt[i+1] = true;
                    break;
                }
            }
        }
        return  opt[s.length()];
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        Set<String> wordDict = new HashSet<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        wordDict.add("b");
        wordDict.add("cd");
        System.out.println(test.wordBreak("aaaaaaa", wordDict));
    }
}
