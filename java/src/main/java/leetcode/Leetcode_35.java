package leetcode;

public class Leetcode_35 {

    public int searchInsert(int[] nums, int target) {
        int i;
        for(i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                break;
            }
        }
        return i;
    }
}
