package leetcode;

public class Leetcode_55 {
    public boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        int enoughStep = 1;
        while(destination > 0) {
            if (destination < enoughStep) {
                return false;
            }
            if (nums[destination - enoughStep] < enoughStep) {
                enoughStep++;
                continue;
            }
            destination--;
            enoughStep = 1;
        }
        return true;
    }
}
