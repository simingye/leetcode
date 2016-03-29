package FirstBadVersion;

/**
 * Created by SimingYe on 1/12/16.
 */
public class FirstBadVersion
{
    public int firstBadVersion(int n)
    {
        if (n <= 1)
            return 1;

        int first = 1;
        int last = n;
        while (first < last)
        {
            int mid = first + (last - first) / 2;

            if (isBadVersion(mid))
            {
                last = mid;
            }
            else
            {
                first = mid + 1;
            }
        }

        return last;
    }

    public boolean isBadVersion(int n)
    {
        return false;
    }
}
