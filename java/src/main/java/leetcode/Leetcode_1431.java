package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = 0;
        for(int i = 0; i < candies.length; i++) {
            maxValue = Math.max(maxValue, candies[i]);
        }

        List<Boolean> answer = new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                answer.add(true);
                continue;
            }
            answer.add(false);
        }

        return answer;
    }
}
