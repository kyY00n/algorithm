package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;

        Set<Long> set = new HashSet<>();
        long sum = 0;
        long previousR = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long remainder = sum % k;

            if (set.contains(remainder)) {
                return true;
            }

            set.add(previousR);
            previousR = remainder;
        }

        return false;
    }
}
