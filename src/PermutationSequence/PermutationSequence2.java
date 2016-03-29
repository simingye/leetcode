package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/4/16.
 */
public class PermutationSequence2
{
    public String getPermutation(int n, int k)
    {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            numberList.add(i);
        }

        // change k to be index
        k--;

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++)
        {
            mod = mod * i;
        }

        String result = "";

        //find sequence
        for (int i = 0; i < n; i++)
        {
            mod = mod / (n - i);

            int curIndex = k / mod;

            k = k % mod;

            result += numberList.get(curIndex);
            numberList.remove(curIndex);
        }

        return result.toString();
    }
}
