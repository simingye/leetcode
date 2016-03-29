package WordLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Siming on 10/26/15.
 */
public class WordLadderSec
{
    public int ladderLength(String beginWord, String endWord, Set<String> wordList)
    {
        int length = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty())
        {
            Queue<String> tmpQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                String word = queue.poll();

                char[] array = word.toCharArray();
                for (int i = 0; i < array.length; i++)
                {
                    for (char c = 'a'; c < 'z'; c++)
                    {
                        char temp = array[i];
                        if (array[i] != c)
                        {
                            array[i] = c;
                        }

                        String newWord = String.valueOf(array);
                        if (newWord.equals(endWord))
                        {
                            return length++;
                        }

                        if (wordList.contains(newWord))
                        {
                            wordList.remove(newWord);
                            tmpQueue.add(newWord);
                        }

                        array[i] = temp;
                    }
                }
            }
            length++;
            queue = tmpQueue;
        }

        return 0;
    }
}
