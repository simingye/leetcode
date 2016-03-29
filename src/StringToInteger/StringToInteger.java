package StringToInteger;

/**
 * Created by SimingYe on 1/26/16.
 */
public class StringToInteger
{
    public int myAtoi(String str)
    {
        if (str == null || str.length() == 0)
            return 0;

        str = str.trim();

        char[] array = str.toCharArray();
        int result = 0;
        int start = 0;
        boolean flag = false;
        if (array[0] == '+' || array[0] == '-')
        {
            flag = true;
            start = 1;
        }

        for (int i = start; i < array.length; i++)
        {
            if (array[i] < '0' || array[i] > '9')
            {
                break;
            }

            result = result * 10 + (array[i] - '0');
        }

        if (array[0] == '-')
        {
            result = -result;
        }

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return result;
    }

    public static void main(String[] args) {
        StringToInteger test = new StringToInteger();
        System.out.println(test.myAtoi("-2147483648"));
    }
}
