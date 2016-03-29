package UberInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 9/18/15.
 */
public class One
{
    public List<List<String>> getPairs(ArrayList<String> input)
    {
        String subStr1 = "";
        String subStr2 = "";

        List<String> temp;
        List<List<String>> result = new ArrayList<>();

        if (input.isEmpty() || input == null || input.size() == 1)
            return result;

        for (String element : input)
        {
            String tmp = new StringBuilder(element).reverse().toString();
            subStr1 = tmp;
            subStr2 = tmp.substring(1);

            temp = new ArrayList<>();

            if (input.contains(subStr1))
            {
                temp.add(element);
                temp.add(subStr1);

                if (result.contains(temp))
                {
                    temp.remove(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                }
            }

            if (input.contains(subStr2))
            {
                temp.add(element);
                temp.add(subStr2);

                if (result.contains(temp))
                {
                    temp.remove(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                }
            }

            if (!temp.isEmpty())
            {
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        One test = new One();
        ArrayList<String> list = new ArrayList<>();
        list.add("gab");
        list.add("cat");
        list.add("bag");
        list.add("alpha");
        list.add("race");
        list.add("car");
        list.add("gab");
        list.add("cat");
        list.add("b");

        test.getPairs(list);
    }
}
