package MnimumWindowSubstring;

/**
 * Created by SimingYe on 3/12/16.
 */
public class MinimumWinsowSubstring
{
    public String minWindow(String source, String target)
    {
        int ans = Integer.MAX_VALUE;
        String result = "";

        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];

        initTargetHash(targetHash, target);

        int j = 0;
        for (int i = 0; i < source.length(); i++)
        {
            sourceHash[source.charAt(i)]++;

            while (isValid(targetHash, sourceHash) && j <= i)
            {
                if (ans > i - j)
                {
                    ans = Math.min(ans, i - j);
                    result = source.substring(j, i+1);
                }
                sourceHash[source.charAt(j)]--;
                j++;
            }
        }

        return result;
    }

    public void initTargetHash(int[] targetHash, String target)
    {
        for (char c : target.toCharArray())
        {
            targetHash[c]++;
        }
    }

    boolean isValid(int[] targetHash, int[] sourceHash)
    {
        for (int i = 0; i < 256; i++)
        {
            if (sourceHash[i] < targetHash[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        MinimumWinsowSubstring test = new MinimumWinsowSubstring();
        System.out.println(test.minWindow("abc", "a"));
    }
}
