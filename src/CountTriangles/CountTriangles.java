package CountTriangles;

import java.util.Arrays;

/**
 * Created by SimingYe on 2/21/16.
 */
public class CountTriangles
{
    public int triangleCount(int S[])
    {
        if (S == null || S.length < 3)
            return 0;

        Arrays.sort(S);
        int result = 0;

        for (int i = S.length - 1; i >= 2; i--)
        {
            int last = i;
            int begin = 0;
            int end = i - 1;

            while (begin < end)
            {
                if (S[end] + S[begin] > S[last])
                {
                    result += end - begin;
                    end--;
                }
                else
                {
                    begin++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountTriangles test = new CountTriangles();
        int[] nums = {4,4,4,4};
        System.out.println(test.triangleCount(nums));
    }
}
