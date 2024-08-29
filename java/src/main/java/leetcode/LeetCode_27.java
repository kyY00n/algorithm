package leetcode;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int index = 0; // initialize to 0 which represents the position of next non-target element
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != val) { // if `nums[i]` is not equal to `val`
                nums[index] = nums[i]; // then overwrite nums[index] with nums[i];
                index++; // increase `index` by 1
            }
        }
        return index; // length of the modified array
    }
}
