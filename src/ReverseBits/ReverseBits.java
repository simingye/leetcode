package ReverseBits;

/**
 * Created by Siming on 10/31/15.
 */
public class ReverseBits
{
    public int reverseBits(int n)
    {
        for (int i = 0; i < 16; i++)
        {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public int swapBits(int n, int i, int j)
    {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        //0011
        //1001
        if ((a ^ b) != 0)
        {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }
}
