package BestTimetToBuyandSellStockTwo;

/**
 * Created by SimingYe on 3/23/16.
 */
public class BestTimetToBuyandSellStockTwo3
{
    public int maxProfit(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < prices.length - 1; i++)
        {
            if (prices[i] < prices[i+1])
            {
                result += prices[i+1] - prices[i];
            }
        }

        return result;
    }
}
