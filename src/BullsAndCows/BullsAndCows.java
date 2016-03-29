package BullsAndCows;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SimingYe on 1/13/16.
 */
public class BullsAndCows
{
    public String getHint(String secret, String guess)
    {
        String result;

        HashMap<Integer, Character> map1 = new HashMap<>();
        HashMap<Integer, Character> map2 = new HashMap<>();

        int length = secret.length();
        for (int i = 0; i < length; i++)
        {
            map1.put(i, secret.charAt(i));
            map2.put(i, guess.charAt(i));
        }

        int bulls = 0;
        for (int i = 0; i < length; i++)
        {
            if (map1.get(i).equals(map2.get(i)))
            {
                bulls++;
                map1.remove(i);
                map2.remove(i);
            }
        }

        int cows = 0;
        for (Map.Entry<Integer, Character> entry : map1.entrySet())
        {
            if (map2.containsValue(entry.getValue()))
            {
                cows++;
                for (Map.Entry<Integer, Character> e : map2.entrySet())
                {
                    if (e.getValue().equals(entry.getValue()))
                    {
                        map2.remove(e.getKey());
                        break;
                    }
                }
            }
        }

        result = bulls + "A" + cows + "B";
        return result;
    }

    public static void main(String[] args) {
        BullsAndCows test = new BullsAndCows();
        System.out.println(test.getHint("0765860239", "5736153483"));
    }
}
