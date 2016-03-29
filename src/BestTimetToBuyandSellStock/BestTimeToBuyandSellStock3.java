package BestTimetToBuyandSellStock;

/**
 * Created by SimingYe on 3/23/16.
 */
public class BestTimeToBuyandSellStock3
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int localMin = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < localMin)
            {
                localMin = prices[i];
            }

            globalMax = Math.max(globalMax, prices[i] - localMin);
        }

        return globalMax;
    }
}
