package GasStation;

/**
 * Created by Siming on 10/23/15.
 */
public class GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int length = gas.length;

        int i = 0;
        int j = 0;
        int sum = 0;
        int total = 0;

        while (j < length)
        {
            int diff = gas[j] - cost[j];

            if (sum + diff < 0)
            {
                i = j + 1;
                sum = 0;
            }
            else
            {
                sum += diff;
            }

            j++;
            total += diff;
        }

        return total >= 0 ? i : -1;
    }

    public static void main(String[] args) {
        GasStation test = new GasStation();
        int[] gas = {1,2};
        int[] cost = {2,1};
        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
