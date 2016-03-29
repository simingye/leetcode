package IntergerToEnglish;

/**
 * Created by SimingYe on 1/21/16.
 */
public class IntegerToEnglish
{
    String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num)
    {
        if (num == 0)
        {
            return "Zero";
        }

        String result = "";
        int i = 0;

        while (num > 0)
        {
            if (num % 1000 != 0)
            {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }

            num /= 1000;
            i++;
        }

        return result.trim();
    }

    public String helper(int num)
    {
        if (num == 0)
        {
            return "";
        }
        else if (num < 20)
        {
            return lessThan20[num] + " ";
        }
        else if (num < 100)
        {
            return tens[num / 10] + " " + helper(num % 10);
        }
        else
        {
            return lessThan20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
