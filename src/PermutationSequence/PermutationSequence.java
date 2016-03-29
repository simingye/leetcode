package PermutationSequence;

import java.util.ArrayList;

/**
 * Created by Siming on 9/11/15.
 */
public class PermutationSequence
{
    public String getPermutation(int n, int k)
    {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            numberList.add(i);
        }

        k--;

        int mod = 1;
        for (int i = 1; i <= n; i++)
        {
            mod *= i;
        }

        String result = "";

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

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(3, 6));
    }
}
