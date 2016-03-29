package ReverseWordsInAString;

/**
 * Created by Siming on 10/28/15.
 */
public class ReverseWordsInAString
{
    public String reverseWords(String s)
    {
        if (s == null || s.length() == 0)
            return s;

        String[] array = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--)
        {
            if (!array[i].equals(""))
            {
                sb.append(array[i] + " ");
            }
        }

        if (sb.toString().equals(""))
        {
            return sb.toString();
        }
        else
        {
            return sb.substring(0, sb.length() - 1).toString();
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString test = new ReverseWordsInAString();
        System.out.println(test.reverseWords(" "));
    }
}

