package ExcelSheetColumnNumber;

/**
 * Created by Siming on 6/16/15.
 */
public class ExcelSheetColumnNumber
{
    public int titleToNumber (String s)
    {
        int result = 0;

        for (int i = 0; i < s.length(); i++)
        {
            result = result + ((int) Math.pow(26, s.length() - i - 1)) * (s.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
