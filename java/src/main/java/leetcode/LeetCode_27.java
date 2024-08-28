package leetcode;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int k = 0; // pointer for the next position to place a non-val element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
