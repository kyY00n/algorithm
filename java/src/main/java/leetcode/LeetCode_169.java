package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_169 {
    public int majorityElement(int[] nums) { // runtime: 12ms, memory: 49.4MB
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToCount.put(nums[i], numToCount.getOrDefault(nums[i], 0) + 1);
        }
        int threshold = nums.length / 2;

        for (int key : numToCount.keySet()) {
            if (numToCount.get(key) > threshold) {
                return key;
            }
        }
        return 0;
    }
}

class MooreMajorityVoting {
    public int majorityElement(int[] nums) { // runtime: 1ms, memory: 53.4MB
        int count = 0;
        int candidate = 0;
        for(int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
                continue;
            }
            if (nums[i] != candidate) {
                count--;
                continue;
            }
            count++;
        }
        return candidate;
    }
}

class First {
    public int majorityElement(int[] nums) { // runtime: 16ms, memory: 49.6MB
        Map<Integer, Integer> numToCount = new HashMap<>();
        int answer = 0;
        int maximum = 0;
        for(int i = 0; i < nums.length; i++) {
            int newValue = 1;
            if (numToCount.containsKey(nums[i])) {
                newValue = numToCount.get(nums[i]) + 1;
            }
            numToCount.put(nums[i], newValue);
            if (maximum < newValue) {
                maximum = newValue;
                answer = nums[i];
            }
        }
        return answer;
    }
}
