package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=daily-question&envId=2024-03-25
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int prevSize = set.size();
            set.add(curr);
            if (prevSize == set.size()) {
                answer.add(curr);
            }
        }
        return answer;
    }

    // 모범 답안
    public List<Integer> niceAnswer(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) { // 1 <= nums[i] <= n 조건을 이용하기
            int idx = Math.abs(nums[i]); // 인덱스로 활용하기 (음수가 됐을 수도 있어서 절댓값으로)
            if (nums[idx-1] < 0) { // 이 인덱스가 나온적이 있는 것이다.
                answer.add(idx);
            }
            nums[idx-1] *= -1; // -1 곱해주기
        }
        return answer;
    }
}
