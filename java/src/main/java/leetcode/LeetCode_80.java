package leetcode;

public class LeetCode_80 {
    public int removeDuplicates(int[] nums) {
        // don't need to check first, seconde elements
        int index = 2; // index for last fixed element
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // don't need to check last fixed element
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

class FirstSubmission {
    public int removeDuplicates(int[] nums) {
        int index = 1;

        // check from third element because we don't need to check first two elements
        for(int i = 2; i < nums.length; i++) {
            if (canOverwrite(nums, index, i)) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

    private boolean canOverwrite(int[] nums, int index, int i) {
        if (nums[i] != nums[index]) {
            return true;
        }
        if (nums[i] != nums[index - 1]) {
            return true;
        }
        return false;
    }
}
