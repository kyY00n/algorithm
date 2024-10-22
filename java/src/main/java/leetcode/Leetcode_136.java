package leetcode;

public class Leetcode_136 {

    /**
     * https://leetcode.com/problems/single-number/description/
     *
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int sol = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sol ^= nums[i];
        }
        return sol;
    }
}
