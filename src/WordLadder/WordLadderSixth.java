package WordLadder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Siming on 11/11/15.
 */
public class WordLadderSixth
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add(beginWord);
        set2.add(endWord);

        return helper(wordList, set1, set2, 1);
    }

    //set1 is the smaller one
    public int helper(Set<String> wordList, Set<String> set1, Set<String> set2, int length)
    {
        if (set1.isEmpty())
            return 0;

        if (set1.size() > set2.size())
            return helper(wordList, set2, set1, length);

        wordList.removeAll(set1);
        wordList.removeAll(set2);

        Set<String> set = new HashSet<>();
        for (String str : set1)
        {
            for (int i = 0; i < str.length(); i++)
            {
                char[] array = str.toCharArray();

                for (char c = 'a'; c <= 'z'; c++)
                {
                    array[i] = c;
                    String newWord = new String(array);

                    if (set2.contains(newWord))
                    {
                        return length + 1;
                    }

                    if (wordList.contains(newWord))
                    {
                        set.add(newWord);
                    }
                }
            }
        }

        return helper(wordList, set2, set, length + 1);
    }
}
