package ExcelSheetColumnTitle;

import java.util.ArrayList;

/**
 * Created by Siming on 6/15/15.
 */
public class ExcelSheetColumnTitle
{
    public String conterToTitle (int n)
    {
        StringBuilder result = new StringBuilder("");

        if (n <= 0)
        {
            throw new IllegalArgumentException("Invalid input");
        }

        while (n > 0)
        {
            n--;
            char ch = (char) (n % 26 + 'A');
            n = n / 26;
            result.append(ch);
        }

        result.reverse();
        return result.toString();
    }



    public static void main(String[] args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        System.out.println(test.conterToTitle(52));
    }
}
