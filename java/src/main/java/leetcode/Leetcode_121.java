package leetcode;

public class Leetcode_121 {

    public int maxProfit_first(int[] prices) {
        int answer = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                answer = Math.max(answer, prices[i] - min);
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return answer;
    }

    public int maxProfit_enhanced(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }
}
