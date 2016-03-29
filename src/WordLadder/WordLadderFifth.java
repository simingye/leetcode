package WordLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Siming on 11/11/15.
 */
public class WordLadderFifth
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        if (wordList.size() == 0)
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int length = 1;

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
                        String newWord = new String(array);

                        if (newWord.equals(endWord))
                        {
                            return length + 1;
                        }

                        if (wordList.contains(newWord))
                        {
                            tempQueue.add(newWord);
                            wordList.remove(newWord);
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
