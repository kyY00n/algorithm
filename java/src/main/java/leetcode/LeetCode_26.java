package leetcode;

public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {
        int length = 0; // represents current index of unique value
        for (int i = 0; i < nums.length; i++) { // iterate the array `nums` using the pointer `i`
            if (nums[i] != nums[length]) {
                length++;
                nums[length] = nums[i];
            }
        }
        return length + 1;
    }
}
