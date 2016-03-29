package MergeSortedArray;

/**
 * Created by Siming on 6/1/15.
 */

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
//        nums1 = sss(nums1, m, nums2, n);
        while (m > 0 && n > 0)
        {
            if (nums1[m] >= nums2[n])
            {
                nums1[m + n - 1] = nums1[m];
                m--;
            }
            else
            {
                nums1[m + n - 1] = nums2[n];
                n--;
            }
        }

        while (n > 0)
        {
            nums1[m + n - 1] = nums2[n];
            n--;
        }
    }

//    public int[] sss(int[] nums1, int m, int[] nums2, int n)
//    {
//        int[] result = new int[m + n];
//        int pointer1 = 0;
//        int pointer2 = 0;
//        int temp = 0;
//
//        if (m == 0)
//        {
//            result = nums2;
//            nums1 = result;
//        }
//        else if (n == 0)
//        {
//            result = nums1;
//            nums1 = result;
//        }
//        else
//        {
//            while (pointer1 < m && pointer2 < n)
//            {
//                if (nums1[pointer1] <= nums2[pointer2])
//                {
//                    result[temp] = nums1[pointer1];
//                    temp++;
//                    pointer1++;
//                }
//                else
//                {
//                    result[temp] = nums2[pointer2];
//                    temp++;
//                    pointer2++;
//                }
//            }
//
//            if (pointer1 == m)
//            {
//                while (pointer2 < n)
//                {
//                    result[pointer2] = nums2[pointer2];
//                    pointer2++;
//                }
//            }
//
//            if (pointer2 == n)
//            {
//                while (pointer1 < m)
//                {
//                    result[pointer1] = nums1[pointer1];
//                    pointer1++;
//                }
//            }
//            nums1 = result;
//        }
//        return nums1;
//    }

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        int[] nums1 = new int[9];
        int[] nums2 = new int[1];
        nums2[0] = 1;
        test.merge(nums1, 0, nums2, 1);

        for (int i = 0; i < nums1.length; i++)
        {
            System.out.println(nums1[i]);
        }
    }
}
