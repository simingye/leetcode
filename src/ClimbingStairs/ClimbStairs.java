package ClimbingStairs;

/**
 * Created by Siming on 5/31/15.
 */
public class ClimbStairs
{
//    public int climbStairs (int n)
//    {
//        if (n == 0 || n == 1 || n == 2)
//            return n;
//
//        int[] ways = new int[n + 1];
//
//        ways[0] = 0;
//        ways[1] = 1;
//        ways[2] = 2;
//
//        for (int i = 3; i <= n; i++)
//        {
//            ways[i] = ways[i - 1] + ways[i - 2];
//        }
//
//        return ways[n];
//    }

    public int climbStairs(int n)
    {
        if (n == 0 || n == 1 || n == 2)
            return n;

        int one = 1;
        int two = 2;
        int result = 0;

        for (int i = 3; i <= n; i++)
        {
            result = one + two;
            one = two;
            two = result;
        }

        return result;
    }

//    public int climbStairs (int n)
//    {
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        if (n == 0)
//            return 0;
//
//        return climbStairs(n-1) + climbStairs(n-2);
//    }

    public static void main(String[] args) {
        ClimbStairs test = new ClimbStairs();
        System.out.println(test.climbStairs(10));
    }
}
