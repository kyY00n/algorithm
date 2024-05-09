package leetcode;

import java.util.Arrays;

public class Leetcode_3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        for(int i = 0; i < k; i++) {
            int curr = happiness[happiness.length - 1 - i];
            if (curr - i > 0) {
                sum += (curr - i);
            }
        }

        return sum;
    }

}
