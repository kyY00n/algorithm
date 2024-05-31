package leetcode;

import java.util.Arrays;

public class LeetCode_260 {
    public int[] improvedSingleNumber(int[] nums) { // 1ms 버전
        int bitwise = 0;
        for(int num: nums) { // bitwise에 모든 숫자를 모두 XOR 연산 하면, 우리가 찾는 숫자들만 XOR 한 값이 된다.
            bitwise ^= num;
        }
        bitwise &= -bitwise; // 두 숫자 중 다른 비트 하나를 찾는 것임! 0100 -> 두 번째 비트가 다른 거임.

        int[] answer = new int[2];
        for(int num: nums) { // nums 를 두 그룹으로 나눠 하나만 있는 숫자를 각각 찾는 것임
            if ((bitwise & num) == 0) {
                answer[0] ^= num; // 어차피 같은 숫자끼리 두 번 XOR 하면 0이기 때문에
                continue;
            }
            answer[1] ^= num;
        }
        // for loop 이 끝나면 자동으로 answer 배열에 답이 저장된다.

        return answer;
    }
    public int[] singleNumber(int[] nums) { // 처음 푼 버전, sort 사용
        Arrays.sort(nums);
        int[] answer = new int[2];
        int hi = 0;
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                i++;
                continue;
            }
            answer[hi++] = nums[i];
        }
        if (hi < 2) {
            answer[hi] = nums[nums.length-1];
        }
        return answer;
    }
}
