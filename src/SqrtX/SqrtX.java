package SqrtX;

/**
 * Created by Siming on 9/18/15.
 */
public class SqrtX
{
    public int mySqrt(int x)
    {
        if (x < 0)
            return 0;

        if (x == 0 || x == 1)
            return x;

        int result = getSqrt(x, 1, x);

        return result;
    }

    public int getSqrt(int x, long left, long right)
    {
        long result = (left + right) / 2;

        if (left == right - 1)
        {
            result = left;
            return (int)result;
        }

        if (result * result == x && left < right)
        {
            return (int)result;
        }

        if (result * result > x && left < right)
        {
            right = (int)result;
            return getSqrt(x, left, right);
        }

        if (result * result < x && left < right)
        {
            left = (int)result;
            return getSqrt(x, left, right);
        }

        return (int)result;
    }

    public static void main(String[] args) {
        SqrtX test = new SqrtX();
        System.out.println(test.mySqrt(2147483647));
    }
}
