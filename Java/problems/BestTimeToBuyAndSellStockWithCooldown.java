package problems;

public class BestTimeToBuyAndSellStockWithCooldown {

	public int maxProfit(int[] prices) {
		int rest = 0;
		int sell = 0;
		int buy = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			int tmp = sell;
			sell = buy + prices[i];
			buy = Math.max(buy, rest - prices[i]);
			rest = Math.max(rest, tmp);
		}
		return Math.max(sell, rest);
	}

}
