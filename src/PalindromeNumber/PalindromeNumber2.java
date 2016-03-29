package PalindromeNumber;

/**
 * Created by SimingYe on 1/26/16.
 */
public class PalindromeNumber2
{
    public boolean isPalindrome(int x)
    {
        if (x < 0)
            return false;

        int first = 0;
        int last = 0;
        int length = 0;
        int num = x;

        while (num >= 10)
        {
            num = num / 10;
            length++;
        }

        while (x != 0)
        {
            first = x / (int) Math.pow(10, length);
            last = x % 10;

            if (first != last)
            {
                return false;
            }

            x = x % (int) Math.pow(10, length);
            x = x / 10;
            length -= 2;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber2 test = new PalindromeNumber2();
        System.out.println(test.isPalindrome(1));
    }
}
