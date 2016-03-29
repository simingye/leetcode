package MergeSortedArray;

/**
 * Created by Siming on 11/15/15.
 */
public class MergeSortedArraySec
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return;

        while (m > 0 && n > 0)
        {
            if (nums1[m - 1] > nums2[n - 1])
            {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
            else
            {
                nums1[m + n - 1] = nums1[n - 1];
                n--;
            }
        }

        while (n > 0)
        {
            nums1[m + n - 1] = nums1[n - 1];
            n--;
        }
    }
}
