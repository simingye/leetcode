package IntegerToRoman;

/**
 * Created by Siming on 7/6/15.
 */
public class IntegerToRoman
{
    public String intToRoman (int num)
    {
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder roman = new StringBuilder("");
        int scale = 1000;

        for (int i = 6; i >= 0; i = i - 2)
        {
            int digit = num / scale;

            if (digit <= 3)
            {
                for (int j = 0; j < digit; j++)
                {
                    roman.append(symbol[i]);
                }
            }
            else if (digit == 4)
            {
                roman.append(symbol[i]);
                roman.append(symbol[i+1]);
            }
            else if (digit == 5)
            {
                roman.append(symbol[i+1]);
            }
            else if (digit >= 6 && digit <= 8)
            {
                roman.append(symbol[i+1]);

                for (int j = 0; j < digit-5; j++)
                {
                    roman.append(symbol[i]);
                }
            }
            else if (digit == 9)
            {
                roman.append(symbol[i]);
                roman.append(symbol[i+2]);
            }

            num = num % scale;
            scale = scale / 10;
        }

        return roman.toString();
    }
}
