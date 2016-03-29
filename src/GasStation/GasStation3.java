package GasStation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SimingYe on 3/26/16.
 */
public class GasStation3
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0)
            return -1;

        int pos = 0;
        int tank = 0;
        int i = 0;

        while (i < gas.length)
        {
            pos = i;
            tank = 0;
            while (tank >= 0)
            {
                if (pos - i >= gas.length)
                {
                    return i;
                }

                tank += gas[pos % gas.length] - cost[pos % gas.length];
                pos++;
            }
            i = pos;
        }

        return -1;
    }

    public static void main(String[] args) {
        GasStation3 test = new GasStation3();
        int[] gas = {4};
        int[] cost = {5};
        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
