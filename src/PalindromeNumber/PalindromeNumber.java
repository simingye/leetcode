package PalindromeNumber;

import java.util.LinkedList;

/**
 * Created by Siming on 5/24/15.
 */
public class PalindromeNumber
{
    public boolean isPalindrome (int x)
    {
        if (x < 0)
            return false;

        int div = 1;
        while (x / div >= 10)
        {
            div *= 10;
        }

        while (x != 0)
        {
            int left = x / div;
            int right = x % 10;

            if (left != right)
                return false;

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(-2147447412));
    }
}
