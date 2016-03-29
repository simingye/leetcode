package HappyNumber;

/**
 * Created by Siming on 6/19/15.
 */

import java.util.ArrayList;

/**
 *
 */
public class HappyNumber
{
    public boolean isHappy (int n)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(n);
        int sum = 0;

        while (true)
        {
            while (n != 0)
            {
                sum = sum + (int) Math.pow(n % 10, 2);
                n = n / 10;
            }

            if (sum == 1)
                return true;

            if (arrayList.contains(sum))
                return false;

            arrayList.add(sum);
            n = sum;
            sum = 0;
        }
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        System.out.println(test.isHappy(1));
    }
}
