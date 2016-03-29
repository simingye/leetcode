package atoi;

/**
 * Created by Siming on 5/24/15.
 */
public class atoi
{
    public int myAtoi(String str)
    {
        char c;
        int num = 0;
        int flag = 1;

        if (str == null || str.length() < 1)
            return 0;

        if (str.charAt(0) == '-')
        {
            flag = -1;
        } else
        {
            flag = 1;
        }

        for (int i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            if (c >= '0' && c <= '9')
            {
                num = 10 * num + (c - '0');
            }
        }

        num = num * flag;

        if (num > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        if (num < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }

        return num;
    }

    public static void main(String[] args) {
        atoi test = new atoi();
        System.out.println(test.myAtoi("-1999999"));
    }
}
