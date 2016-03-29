package NutsAndBolts;

/**
 * Created by SimingYe on 3/11/16.
 */
public class NutsAndBolts
{
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare)
    {
        if (nuts == null || bolts == null)
            return;

        if (nuts.length != bolts.length)
            return;

        quickSort(nuts, bolts, compare, 0, nuts.length-1);
    }

    public void quickSort(String[] nuts, String[] bolts, NBCompare compare, int left, int right)
    {
        if (left >= right)
            return;

        int index = partition(nuts, bolts[left], compare, left, right);

        partition(bolts, nuts[index], compare, left, right);

        quickSort(nuts, bolts, compare, left, index-1);
        quickSort(nuts, bolts, compare, index+1, right);
    }

    public int partition(String[] strs, String pivot, NBCompare compare, int left, int right)
    {
        for (int i = left; i <= right; i++)
        {
            if (compare.cmp(strs[i], pivot) == 0 || compare.cmp(pivot, strs[i]) == 0)
            {
                swap(strs, i, left);
                break;
            }
        }

        String now = strs[left];
        int l = left;
        int r = right;

        while (l < r)
        {
            while (l < r && ((compare.cmp(pivot, strs[r]) == 1) || compare.cmp(strs[r], pivot) == -1))
            {
                r--;
            }
            strs[l] = strs[r];

            while (l < r && ((compare.cmp(pivot, strs[l]) == -1) || compare.cmp(strs[l], pivot) == 1))
            {
                l++;
            }
            strs[r] = strs[l];
        }
        strs[l] = now;

        return l;
    }

    public void swap(String[] strs, int left, int right)
    {
        String temp = strs[left];
        strs[left] = strs[right];
        strs[right] = temp;
    }
}
