package MergeSortedArray;

/**
 * Created by SimingYe on 2/10/16.
 */
public class MergeSortedArray2
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        if (nums2 == null || nums2.length == 0)
            return;

        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0)
        {
            if (nums1[i] >= nums2[j])
            {
                nums1[index] = nums1[i];
                index--;
                i--;
            }
            else
            {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }

        if (j >= 0)
        {
            while (j >= 0)
            {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        MergeSortedArray2 test = new MergeSortedArray2();
        int[] nums1 = {1,3,5,7,0,0,0,0,0};
        int[] nums2 = {2,4,6,8};
        test.merge(nums1, 4, nums2, 4);
    }
}
