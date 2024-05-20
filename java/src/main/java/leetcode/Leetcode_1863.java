package leetcode;

public class Leetcode_1863 {
    private int[] nums;
    private int answer = 0;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        calculateSubsetXOR(0, 0);
        return answer;
    }

    private void calculateSubsetXOR(int index, int currentXOR) {
        if (index == nums.length) {
            answer += currentXOR;
            return;
        }
        // 넣거나
        calculateSubsetXOR(index + 1, currentXOR ^ nums[index]);
        // 안 넣거나
        calculateSubsetXOR(index + 1, currentXOR);
    }
}

