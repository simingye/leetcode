package BitwiseAndofNumbersRange;

/**
 * Created by Siming on 11/2/15.
 */
public class BitwiseAndofNumbersRange
{
    public int rangeBitwiseAnd(int m, int n)
    {
        int i = 0;
        while (m != n)
        {
            m =  m >> 1;
            n = n >> 1;
            i++;
        }

        return m << i;
    }
}
