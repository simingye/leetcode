package CountAndSay;

/**
 * Created by SimingYe on 1/29/16.
 */
public class CountAndSay2
{
    public String countAndSay(int n)
    {
        if (n <= 0)
            return "";

        String str = "1";

        for (int i = 1; i < n; i++)
        {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            int counter = 1;
            while (index < str.length())
            {
                if (index < str.length() - 1 && str.charAt(index) == str.charAt(index+1))
                {
                    counter++;
                }
                else
                {
                    sb.append(String.valueOf(counter) + str.charAt(index));
                    counter = 1;
                }

                index++;
            }

            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        CountAndSay2 test = new CountAndSay2();
        System.out.println(test.countAndSay(4));
    }
}
