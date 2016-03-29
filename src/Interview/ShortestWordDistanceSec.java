package Interview;

/**
 * Created by Siming on 11/15/15.
 */
public class ShortestWordDistanceSec
{
    public int shortestWordDistance(String[] words, String word1, String word2)
    {
        if (words == null || words.length == 0)
            return 0;

        int pos1 = -1;
        int pos2 = -2;
        int length = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].equals(word1))
            {
                pos1 = i;
            }

            if (words[i].equals(word2))
            {
                pos2 = i;
            }

            if (pos1 != -1 && pos2 != -1 && pos1 != pos2)
            {
                if (Math.abs(pos1 - pos2) < length)
                {
                    left = Math.min(pos1, pos2);
                    right = Math.max(pos1, pos2);
                }

                length = Math.min(length, Math.abs(pos1 - pos2));
            }
        }

        return length;
    }
}
