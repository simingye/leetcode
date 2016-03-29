package BestTimetToBuyandSellStock;

/**
 * Created by SimingYe on 2/25/16.
 */
public class BestTimeToBuyandSellStock2
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int min = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < prices[min])
            {
                min = i;
            }

            result = Math.max(result, prices[i] - prices[min]);
        }

        return result;
    }
}
