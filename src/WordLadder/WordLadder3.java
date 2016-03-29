package WordLadder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SimingYe on 3/23/16.
 */
public class WordLadder3
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0)
            return 0;

        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);

        Set<String> set2 = new HashSet<>();
        set2.add(endWord);

        return helper(set1, set2, wordList, 1);
    }

    public int helper(Set<String> set1, Set<String> set2, Set<String> wordList, int length)
    {
        Set<String> set = new HashSet<>();

        if (set1.size() > set2.size())
        {
            return helper(set2, set1, wordList, length);
        }

        if (set1.isEmpty())
            return 0;

        wordList.removeAll(set1);
        wordList.removeAll(set2);

        for (String word : set1)
        {
            for (int i = 0; i < word.length(); i++)
            {
                char[] array = word.toCharArray();

                for (char tempChar = 'a'; tempChar <= 'z'; tempChar++)
                {
                    array[i] = tempChar;
                    String str = String.valueOf(array);

                    if (set2.contains(str))
                    {
                        return length + 1;
                    }

                    if (wordList.contains(str))
                    {
                        set.add(str);
                    }
                }
            }
        }

        return helper(set, set2, wordList, length + 1);
    }

    public static void main(String[] args) {
        WordLadder3 test = new WordLadder3();
        Set<String> list = new HashSet<>();
        list.add("hot");
        list.add("dog");
        list.add("dot");
        System.out.println(test.ladderLength("hot", "dog", list));
    }
}
