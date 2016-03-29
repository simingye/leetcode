package CompareVersionNumbers;

/**
 * Created by Siming on 6/14/15.
 */
public class CompareVersionNumbers
{
    public int compareVersion (String version1, String version2)
    {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        if (version1 == version2)
            return 0;

        int i = 0;

        while (i <= array1.length - 1 && i <= array2.length - 1)
        {
            if (Integer.parseInt(array1[i]) > Integer.parseInt(array2[i]))
                return 1;

            if (Integer.parseInt(array1[i]) < Integer.parseInt(array2[i]))
                return -1;

            if (Integer.parseInt(array1[i]) == Integer.parseInt(array2[i]))
            {
                i++;
            }
        }

        if (i > array1.length - 1 && i <= array2.length - 1)
        {
            if (Integer.parseInt(array2[i]) != 0)
            {
                return -1;
            }
        }

        if (i > array2.length - 1 && i <= array1.length - 1)
        {
            if (Integer.parseInt(array1[i]) != 0)
            {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("01"));
        CompareVersionNumbers test = new CompareVersionNumbers();
        System.out.println(test.compareVersion("1.0", "1"));
    }
}
