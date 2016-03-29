package FractionToRecurringDecimal;

/**
 * Created by Siming on 10/30/15.
 */
public class FractionToRecurringDecimal
{
    public String fractionToDecimal(int numerator, int denominator)
    {
        boolean isNegative = false;
        int left = numerator / denominator;
        int remainder = numerator % denominator;
        boolean flag = false;
        int count = 1;
        int temp;
        String right = "";

        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
        {
            isNegative = true;
        }

        if (remainder == 0)
        {
            return String.valueOf(left);
        }
        else
        {
            while (remainder != 0)
            {
                temp = remainder;
                remainder = (remainder * 10) % denominator;

                if (remainder == temp)
                {
                    right += "(" + String.valueOf((temp * 10) / denominator) + ")";
                    break;
                }
                else
                {
                    right += String.valueOf((temp * 10) / denominator);
                }
            }
        }

        String result =  String.valueOf(left) + "." + right;

        if (!isNegative)
        {
            return result;
        }
        else
        {
            return "-" + result;
        }
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal test = new FractionToRecurringDecimal();
        System.out.println(test.fractionToDecimal(1, 3));
    }
}
