package Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 2/18/16.
 */
public class WinsowSum
{
    public List<Integer> windowSum(List<Integer> arr, int k)
    {
        List<Integer> result = new ArrayList<>();

        if (arr.size() < k || arr == null || k <= 0)
            return result;

        for (int i = 0; i < arr.size() - k + 1; i++)
        {
            int sum = 0;
            for (int j = i; j < i + k; j++)
            {
                sum += arr.get(j);
            }

            result.add(sum);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(73);
        arr.add(11);
        arr.add(-5);

        WinsowSum test = new WinsowSum();
        test.windowSum(arr, 2);
    }
}
