package AddBinary;

/**
 * Created by SimingYe on 2/8/16.
 */
public class AddBinary
{
    public String addBinray(String a, String b)
    {
        if (a == null && b == null)
            return null;

        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        int aLen = a.length();
        int bLen = b.length();

        int carry = 0;
        String result = "";

        while (aLen > 0 && bLen > 0)
        {
            int aNum = array1[aLen-1] - '0';
            int bNum = array2[bLen-1] - '0';

            result = String.valueOf((aNum + bNum + carry) % 2) + result;
            carry = (aNum + bNum + carry) / 2;

            aLen--;
            bLen--;
        }

        if (aLen == 0)
        {
            while (bLen > 0)
            {
                int bNum = array2[bLen-1] - '0';
                result = String.valueOf((bNum + carry) % 2) + result;
                carry = (bNum + carry) / 2;

                bLen--;
            }
        }

        if (bLen == 0)
        {
            while (aLen > 0)
            {
                int aNum = array1[aLen-1] - '0';

                result = String.valueOf((aNum + carry) % 2) + result;
                carry = (aNum + carry) / 2;

                aLen--;
            }
        }

        if (carry > 0)
        {
            result = String.valueOf(carry) + result;
        }

        return result;
    }

    public static void main(String[] args) {
        AddBinary test = new AddBinary();
        System.out.println(test.addBinray("1010", "1011"));
    }
}
