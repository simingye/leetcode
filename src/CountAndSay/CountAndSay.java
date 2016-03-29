package CountAndSay;

/**
 * Created by Siming on 5/30/15.
 */
public class CountAndSay
{
    public String countAndSay (int n)
    {
        if (n <= 0)
            return null;

        String temp = "1";
        String result = temp;

        for (int i = 1; i < n; i++)
        {
            result = getNext(temp);
            temp = result;
        }

        return result;
    }

    public String getNext (String currentStr)
    {
        int pointer = 1;
        int amount = 1;
        int number = Integer.parseInt(String.valueOf(currentStr.charAt(0)));
        StringBuilder result = new StringBuilder("");

        while (pointer < currentStr.length())
        {
            if (currentStr.charAt(pointer) != currentStr.charAt(pointer - 1))
            {
                result.append(String.valueOf(amount) + String.valueOf(number));
                number = Integer.parseInt(String.valueOf(currentStr.charAt(pointer)));
                amount = 1;
                pointer++;
            }
            else
            {
                amount++;
                pointer++;
            }
        }

        result.append(String.valueOf(amount) + String.valueOf(number));

        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay test = new CountAndSay();
//        System.out.println(test.countAndSay(25));
        System.out.println(test.getNext("111221"));
    }
}
