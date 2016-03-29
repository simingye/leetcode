package Interview;

/**
 * Created by Siming on 11/11/15.
 */
public class ShortestWordDistance
{
    public int shortestWordDistance(String[] wordList, String word1, String word2)
    {
        if (wordList == null || wordList.length < 2)
            return -1;

        int pos1 = -1;
        int pos2 = -1;
        int length = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;

        for (int i = 0; i < wordList.length; i++)
        {
            if (wordList[i].equals(word1))
            {
                pos1 = i;
            }

            if (wordList[i].equals(word2))
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

        if (length == Integer.MAX_VALUE)
            return -1;
        else
            return length;
    }

    public static void main(String[] args) {
        ShortestWordDistance test = new ShortestWordDistance();
        String[] wordList = {"practice", "makes", "perfect", "i", "am", "a", "perfect", "makes"};
        System.out.println(test.shortestWordDistance(wordList, "perfect", "a"));
    }
}
