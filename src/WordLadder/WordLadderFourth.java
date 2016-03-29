package WordLadder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Siming on 10/27/15.
 */
public class WordLadderFourth
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);

        return helper(wordList, set1, set2, 1);
    }

    public int helper(Set<String> wordList, Set<String> set1, Set<String> set2, int length)
    {
        if (set1.isEmpty())
            return 0;

        if (set1.size() > set2.size())
            return helper(wordList, set2, set1, length);

        for (String word: set1)
        {
            wordList.remove(word);
        }

        for (String word: set2)
        {
            wordList.remove(word);
        }

        Set<String> set = new HashSet<>();

        for (String str : set1)
        {
            for (int i = 0; i < str.length(); i++)
            {
                char[] array = str.toCharArray();

                for (char c = 'a'; c <= 'z'; c++)
                {
                    array[i] = c;
                    String word = new String(array);

                    if (set2.contains(word))
                    {
                        return length + 1;
                    }

                    if (wordList.contains(word))
                    {
                        set.add(word);
                    }
                }
            }
        }

        return helper(wordList, set2, set, length + 1);
    }
}
