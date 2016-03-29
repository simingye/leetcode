package ShortestWordDistanceThree;

/**
 * Created by Siming on 11/9/15.
 */
public class ShortestWordDistanceThree
{
    public int shortestWordDistance(String[] words, String word1, String word2)
    {
        if (words ==  null || words.length < 2)
            return 0;

        int pos1 = -1;
        int pos2 = -1;
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++)
        {
            if (words[i].equals(word1))
            {
                pos1 = i;
            }

            if (pos1 != -1 && pos2 != -1 && pos1 != pos2)
            {
                if (Math.abs(pos1 - pos2) <= distance )
                {
                    index1 = pos1;
                    index2 = pos2;
                }

                distance = Math.min(distance, Math.abs(pos1 - pos2));
            }

            if (words[i].equals(word2))
            {
                pos2 = i;
            }

            if (pos1 != -1 && pos2 != -1 && pos1 != pos2)
            {
                if (Math.abs(pos1 - pos2) <= distance )
                {
                    index1 = pos1;
                    index2 = pos2;
                }

                distance = Math.min(distance, Math.abs(pos1 - pos2));
            }
        }

        return distance;
    }

    public static void main(String[] args)
    {
        ShortestWordDistanceThree test = new ShortestWordDistanceThree();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(test.shortestWordDistance(words, "coding", "makes"));
    }
}
