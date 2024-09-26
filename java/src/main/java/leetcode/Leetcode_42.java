package leetcode;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Leetcode_42 {

    public int trap(int[] height) {
        int boundary = 0;
        int[] water = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            boundary = Math.max(boundary, height[i]);
            water[i] = boundary;
        }
        boundary = 0;
        for(int i = height.length - 1; i > 0; i--) {
            boundary = Math.max(boundary, height[i]);
            water[i] = Math.min(water[i], boundary);
        }

        int answer = 0;
        for(int i = 0; i < height.length; i++) {
            answer += water[i] - height[i];
        }
        return answer;
    }

}
