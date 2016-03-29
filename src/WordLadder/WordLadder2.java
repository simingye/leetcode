package WordLadder;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 2/25/16.
 */
public class WordLadder2
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        if (beginWord == null || endWord == null)
            return 0;

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);

        return helper(set1, set2, wordList, 1);
    }

    public int helper(Set<String> set1, Set<String> set2, Set<String> wordList, int length)
    {
        if (set1.isEmpty())
            return 0;

        if (set1.size() > set2.size())
            return helper(set2, set1, wordList, length);

        wordList.removeAll(set1);
        wordList.removeAll(set2);

        Set<String> set = new HashSet<>();

        for (String s : set1)
        {
            for (int i = 0; i < s.length(); i++)
            {
                char[] array = s.toCharArray();

                for (char c = 'a'; c <= 'z'; c++)
                {
                    array[i] = c;
                    String word = String.valueOf(array);

                    if (set2.contains(word))
                    {
                        return length+1;
                    }

                    if (wordList.contains(word))
                    {
                        set.add(word);
                    }
                }
            }
        }

        return helper(set, set2, wordList, length+1);
    }
}
