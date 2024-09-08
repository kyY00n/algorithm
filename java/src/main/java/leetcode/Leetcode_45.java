package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode_45 {
    public int jump(int[] nums) { // time complexity: O(|V|+|E|) = O(N^2).. because we can jump to any of right positions.
        int[] steps = new int[nums.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int index = queue.poll();
            if (index == nums.length - 1) {
                break;
            }
            for(int i = 1; i <= nums[index]; i++) {
                int canStepTo = index + i;
                if (canStepTo > nums.length - 1) {
                    break;
                }
                if (steps[canStepTo] == 0) { // 방문한 적이 없다면
                    steps[canStepTo] = steps[index] + 1;
                    queue.add(canStepTo);
                }
            }
        }

        for(int i = 0; i < steps.length; i++) {
            System.out.println(steps[i]);
        }
        return steps[nums.length - 1];
    }

}
