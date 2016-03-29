package NumberOfOneBits;

/**
 * Created by Siming on 6/16/15.
 */
public class NumberOfOneBits
{
    public int hammingWeight (int n)
    {
        int count = 0;

        for (int i = 1; i < 33; i++)
        {
            if (isOneBit(n, i) == true)
            {
                count++;
            }
        }

        return count;
    }

    public boolean isOneBit(int num, int position)
    {
        if ((num & (1 << position)) == 1)
        {
            return true;
        }
        else
            return false;
    }
}
