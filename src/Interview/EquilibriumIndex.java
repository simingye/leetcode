package Interview;

/**
 * Created by Siming on 10/7/15.
 */
public class EquilibriumIndex
{
    public int solution(int[] A)
    {
        if (A == null || A.length == 0)
            return -1;

        int length = A.length;
        int[] array1 = new int[length];
        int[] array2 = new int[length];

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < length - 1; i++)
        {
            sum1 += A[i];
            array1[i] = sum1;

            sum2 += A[length - i - 1];
            array2[length - i - 1] = sum2;
        }

        if (array1[length-2] == 0)
            return length-1;

        if (array2[1] == 0)
            return 0;

        for (int i = 1; i < length - 1; i++)
        {
            if (array1[i - 1] == array2[i + 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        EquilibriumIndex test = new EquilibriumIndex();
        int[] A = {1,2,1};
        System.out.println(test.solution(A));
    }
}
