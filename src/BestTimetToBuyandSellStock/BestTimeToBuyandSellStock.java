package BestTimetToBuyandSellStock;

/**
 * Created by Siming on 10/20/15.
 */
public class BestTimeToBuyandSellStock
{
    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int diff = 0;

        for (int i = 0; i < prices.length; i++)
        {
            if (prices[i] < min)
            {
                min = prices[i];
            }

            diff = prices[i] - min;

            if (diff > max)
            {
                max = diff;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyandSellStock test = new BestTimeToBuyandSellStock();
        int[] prices = {1, 2};
        System.out.println(test.maxProfit(prices));
    }
}
