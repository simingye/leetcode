package WordLadderTwo;

import java.util.*;

/**
 * Created by Siming on 11/11/15.
 */
public class WordLadderTwo
{
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList)
    {
        List<List<String>> result = new ArrayList<>();

        if (wordList == null || wordList.size() == 0)
            return result;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);


        while (!queue.isEmpty())
        {
            Queue<String> tempQueue = new LinkedList<>();
            List<String> path = new ArrayList<>();

            while (!queue.isEmpty())
            {
                String word = queue.poll();
                path.add(word);

                for (int i = 0; i < word.length(); i++)
                {
                    char[] array = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        array[i] = c;

                        String newWord = new String(array);

                        if (newWord.equals(endWord))
                        {
                            path.add(newWord);
                            result.add(path);
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
        }

        return result;
    }
}
