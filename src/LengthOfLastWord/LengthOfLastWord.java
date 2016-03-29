package LengthOfLastWord;

/**
 * Created by Siming on 5/31/15.
 */

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 */
public class LengthOfLastWord
{
    public int lengthOfLastWord (String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        boolean flag = false;
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--)
        {
            char c = s.charAt(i);

            if ((c>='a' && c<='z') || (c>='A' && c<='Z'))
            {
                flag = true;
                result++;
            }
            else
            {
                if (flag == true)
                    return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLastWord test = new LengthOfLastWord();
        System.out.println(test.lengthOfLastWord("*a    "));
    }
}
