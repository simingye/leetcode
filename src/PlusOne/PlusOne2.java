package PlusOne;

/**
 * Created by SimingYe on 2/8/16.
 */
public class PlusOne2
{
    public int[] plusOne(int[] digits)
    {
        if (digits == null || digits.length == 0)
            return null;

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--)
        {
            int temp = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (temp + carry) / 10;
        }

        if (carry > 0)
        {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 0; i < digits.length; i++)
            {
                result[i+1] = digits[i];
            }

            return result;
        }
        else
        {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne2 test = new PlusOne2();
        int[] digits = {9};
        test.plusOne(digits);
    }
}
