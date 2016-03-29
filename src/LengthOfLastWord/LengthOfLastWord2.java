package LengthOfLastWord;

/**
 * Created by SimingYe on 2/3/16.
 */
public class LengthOfLastWord2
{
    public int lengthOfLastWord(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        String[] array = s.split(" ");

        if (array.length == 0)
        {
            return 0;
        }
        else
        {
            return array[array.length - 1].length();
        }
    }

    public static void main(String[] args) {
        LengthOfLastWord2 test = new LengthOfLastWord2();
        System.out.println(test.lengthOfLastWord("hello  world"));
    }
}
