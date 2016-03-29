package PlusOne;

/**
 * Created by Siming on 6/1/15.
 */
public class PlusOne
{
    public int[] plusOne (int[] digits)
    {
        int a = 1;
        int newDigit = 0;

        for (int i = digits.length - 1; i >= 0; i--)
        {
            newDigit = (digits[i] + a) % 10;
            a = (digits[i] + a) / 10;
            digits[i] = newDigit;
        }

        if (a > 0)
        {
            int[] result = new int[digits.length+1];
            result[0] = a;

            for (int i = 0; i < digits.length; i++)
            {
                result[i + 1] = digits[i];
            }

            return  result;
        }
        else
            return digits;

    }
}
