package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderToCount = new HashMap<>();
        remainderToCount.put(0, 1);

        long sum = 0;
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = (int)(sum % k);

            // 자바의 나머지 연산은 음수를 반환할 수 있다. (파이썬과 다름)
            if (remainder < 0) {
                remainder += k;
            }

            if (remainderToCount.containsKey(remainder)) {
                int old = remainderToCount.get(remainder);
                remainderToCount.put(remainder, old + 1);
                answer += old;
                continue;
            }
            remainderToCount.put(remainder, 1);
        }

        return answer;
    }
}
