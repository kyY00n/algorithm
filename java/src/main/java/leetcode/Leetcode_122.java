package leetcode;

public class Leetcode_122 {
    public int maxProfit_first(int[] prices) {
        int hold = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (hold > prices[i]) {
                hold = prices[i];
                continue;
            }
            if (hold < prices[i]) {
                profit += prices[i] - hold;
                hold = prices[i];
            }
        }
        return profit;
    }

}
