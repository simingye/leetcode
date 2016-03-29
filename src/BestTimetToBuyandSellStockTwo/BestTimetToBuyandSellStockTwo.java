package BestTimetToBuyandSellStockTwo;

/**
 * Created by Siming on 10/20/15.
 */
public class BestTimetToBuyandSellStockTwo
{
    public int maxProduct(int[] prices)
    {
        if (prices == null || prices.length == 0)
            return 0;

        int diff = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++)
        {
            diff = prices[i] - prices[i-1];

            if (diff > 0)
            {
                max += diff;
            }
        }

        return max;
    }
}
