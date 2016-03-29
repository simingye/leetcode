package WordLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by SimingYe on 3/26/16.
 */
public class WordLadder4
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0)
            return 0;

        int length = 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty())
        {
            Queue<String> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                String word = queue.poll();

                for (int i = 0; i < word.length(); i++)
                {
                    char[] array = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        array[i] = c;
                        String str = String.valueOf(array);

                        if (str.equals(endWord))
                        {
                            return length + 1;
                        }

                        if (wordList.contains(str))
                        {
                            tempQueue.add(str);
                            wordList.remove(str);
                        }
                    }
                }
            }

            queue = tempQueue;
            length++;
        }

        return 0;
    }
}
