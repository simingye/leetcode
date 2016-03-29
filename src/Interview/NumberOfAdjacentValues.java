package Interview;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * Created by Siming on 10/8/15.
 */
public class NumberOfAdjacentValues
{
    public int solution(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        Arrays.sort(A);

        int end = 0;
        int count = 1;
        int result = 0;

        for (int i = 0; i < A.length; i++)
        {
            end = i + 1;
            while (end < A.length)
            {
                if (count >= 2)
                {
                    while (end < A.length - 1 && A[end] == A[end + 1])
                        end++;

                    result += (end - i);
                    count = 1;
                    break;
                }

                if (A[i] != A[end])
                {
                    count++;
                }
                else
                {
                    end++;
                }
            }
        }

        if (result > 100000000)
            return -1;

        return result;
    }

    public static void main(String[] args) {
        NumberOfAdjacentValues test = new NumberOfAdjacentValues();
//        int a[] = {0,1,3,3,3,5,7,11};
        int a[] = {0,1,2,3,4,5,6,7};
        System.out.println(test.solution(a));
    }
}
