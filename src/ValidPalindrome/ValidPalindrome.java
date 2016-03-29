package ValidPalindrome;

/**
 * Created by Siming on 10/22/15.
 */
public class ValidPalindrome
{
    public boolean isPalindrome(String s)
    {
        if (s == null)
            return false;

        if (s.length() == 0 || s.length() == 1)
            return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end)
        {
            while (start < end && !isValid(s.substring(start, start + 1)))
            {
                start++;
            }

            while (start < end && !isValid(s.substring(end, end + 1)))
            {
                end--;
            }

            if (s.substring(start, start + 1).equalsIgnoreCase(s.substring(end, end + 1)))
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    public boolean isValid(String s)
    {
        if ((s.charAt(0) <= '9' && s.charAt(0) >= '0') || (s.charAt(0) <= 'z' && s.charAt(0) >= 'a') || (s.charAt(0) <= 'Z' && s.charAt(0) >= 'A'))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ValidPalindrome test = new ValidPalindrome();
        System.out.println(test.isPalindrome(".a"));
    }
}
