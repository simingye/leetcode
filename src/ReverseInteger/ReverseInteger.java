package ReverseInteger;

/**
 * Created by SimingYe on 1/26/16.
 */
public class ReverseInteger
{
    public int reverse(int x)
    {
        boolean flag = true;
        if (x < 0)
        {
            flag = false;
            x = Math.abs(x);
        }

        int result = 0;

        while (x != 0)
        {
            if (result > (Integer.MAX_VALUE - x % 10) / 10)
            {
                return 0;
            }

            result = 10 * result + x % 10;
            x = x / 10;
        }

        if (flag == false)
        {
            if (-result < Integer.MIN_VALUE)
                return 0;

            result = -result;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(1534236469));
    }
}
