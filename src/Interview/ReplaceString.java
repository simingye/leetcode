package Interview;

/**
 * Created by Siming on 10/13/15.
 */
public class ReplaceString
{
    public String replaceString(String s, String keyword)
    {
        String result = "";

        if (s == null || s.length() == 0)
            return result;

        if (keyword == null || keyword.length() == 0)
            return s;

        int current = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == keyword.charAt(current))
            {
                for (int j = i; j < s.length(); j++)
                {
                    if (s.charAt(j) == keyword.charAt(current))
                    {
                        if (current == keyword.length() - 1)
                        {
                            result += "." + keyword + ".";
                            current = 0;
                            i = j;
                            break;
                        }
                        else
                        {
                            current++;
                        }
                    }
                    else
                    {
                        result += String.valueOf(s.charAt(i));
                        current = 0;
                        break;
                    }
                }
            }
            else
            {
                result += String.valueOf(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ReplaceString test = new ReplaceString();
        System.out.println(test.replaceString("i am a student, and i live in usa", "and"));
    }
}
