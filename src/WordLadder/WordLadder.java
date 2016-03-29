package WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Siming on 10/21/15.
 */
public class WordLadder
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

                        String newWord = new String(array);
                        if (wordList.contains(newWord))
                        {
                            tmpQueue.add(newWord);
                            wordList.remove(newWord);
                        }

                        if (newWord.equals(endWord))
                            return length + 1;

                        array[i] = temp;
                    }
                }
            }
            queue = tmpQueue;
            length++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder test = new WordLadder();
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(test.ladderLength("hit", "cog", wordList));
    }
}
