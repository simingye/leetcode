package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by SimingYe on 2/16/16.
 */
public class SortArray
{
    public int[] sortArray(int[] arr)
    {
        int len = arr.length;
        int small, pos, i, j, temp;

        for (i = 0; i <= len - 1; i++)
        {
            for (j = i; j < len; j++)
            {
                temp = 0;
                if (arr[i] < arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public int[] sortArray2(int[] arr)
    {
        int i, max, location, j, temp, len = arr.length;
        Deque<String> deque = new ArrayDeque<>();

        for (i = 0; i < len; i++)
        {
            max = arr[i];
            location = i;

            for (j = i; j < len; j++)
            {
                if (max < arr[j])
                {
                    max = arr[j];
                    location = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,8,9,1};
        SortArray test = new SortArray();
        test.sortArray2(arr);
    }
}
