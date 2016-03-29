package HIndex;

import java.util.Arrays;

/**
 * Created by SimingYe on 1/21/16.
 */
public class HIndex
{
    public int hIndex(int[] citations)
    {
        if (citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations);
        int result = 0;

        for (int i = citations.length - 1; i >= 0; i--)
        {
            if (citations[i] >= result)
            {
                result++;
            }
            else
            {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(test.hIndex(citations));
    }
}
