package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_2501 {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Arrays.sort(nums);

        int answer = 1;
        for(int i = 0; i < nums.length; i++) {
            int temp = 1;
            long curr = (long) nums[i] * nums[i];
            while (curr <= 100_000 && set.contains((int)curr)) {
                curr *= curr;
                temp += 1;
            }
            answer = Math.max(answer, temp);
        }
        if (answer == 1) {
            return -1;
        }
        return answer;
    }

}
