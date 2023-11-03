public class EmoticonSale {
    // https://school.programmers.co.kr/learn/courses/30/lessons/150368

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] answer = solution.solution(users, emoticons);
        System.out.println(answer[0] + " " + answer[1]);
    }

}

class Solution {
    static int[] percentages = {10, 20, 30, 40};
    static int maxSubscribe = 0;
    static int maxProfit = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] percents = new int[emoticons.length];
        dfs(0, users, emoticons, percents);
        int[] answer = {maxSubscribe, maxProfit};
        return answer;
    }

    public static void dfs(int index, int[][] users, int[] emoticons, int[] percents) {
        if (index == emoticons.length) {
            int subscribeCnt = 0;
            int totalPrice = 0;
            for(int[] user: users) {
                int userDiscountRate = user[0];
                int userLimitPrice = user[1];
                int price = 0;
                boolean subscribe = false;
                for(int i = 0; i < emoticons.length; i++) {
                    if (userDiscountRate <= percents[i]) {
                        price += emoticons[i] * (100 - percents[i]) / 100; // price 제대로 계산 안함.
                    }
                    if (price >= userLimitPrice) {
                        subscribe = true;
                        subscribeCnt += 1;
                        break;
                    }
                }
                if (!subscribe) {
                    totalPrice += price;
                }
            }
            if (subscribeCnt > maxSubscribe) {
                maxSubscribe = subscribeCnt;
                maxProfit = totalPrice; // 이거 놓침
            }
            if (subscribeCnt == maxSubscribe) {
                if (totalPrice > maxProfit) {
                    maxProfit = totalPrice;
                }
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            percents[index] = percentages[i];
            dfs(index+1, users, emoticons, percents);
        }
    }
}
