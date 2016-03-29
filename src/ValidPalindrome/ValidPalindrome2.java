package ValidPalindrome;

/**
 * Created by SimingYe on 2/25/16.
 */
public class ValidPalindrome2
{
    public boolean isPalindrome(String s)
    {
        if (s == null)
            return false;

        if (s.length() <= 1)
            return true;

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            if (s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
                continue;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome2 test = new ValidPalindrome2();
        System.out.println(test.isPalindrome("9a"));
    }
}
