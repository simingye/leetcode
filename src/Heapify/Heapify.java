package Heapify;

/**
 * Created by SimingYe on 3/6/16.
 */
public class Heapify
{
    public void heapify(int[] A)
    {
        for (int i = A.length / 2; i >= 0; i--)
        {
            siftdown(A, i);
        }
    }

    public void siftdown(int[] A, int k)
    {
        while (k < A.length)
        {
            int smallest = k;
            if (k*2+1 < A.length && A[k*2+1] < A[smallest])
            {
                smallest = k*2+1;
            }

            if (k*2+2 < A.length && A[k*2+2] < A[smallest])
            {
                smallest = k*2+2;
            }

            if (smallest == k)
            {
                return;
            }

            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;
        }
    }
}
