package leetcode;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/subsets/description/?envType=daily-question&envId=2024-05-21
public class Leetcode_78 {
    private int[] N;
    private List<List<Integer>> answer;

    public List<List<Integer>> subsets(int[] nums) {
        N = nums;
        answer = new ArrayList<>();
        add(0, new ArrayList<>());
        return answer;
    }

    private void add(int currIdx, List<Integer> pre) {
        if (currIdx == N.length) { // 끝까지 돈 경우 리스트를 답에 추가하기
            answer.add(pre);
            return;
        }
        List<Integer> copied = new ArrayList<>(List.copyOf(pre)); // List.copyOf는 불변이라 add 연산이 불가능, ArrayList로 감싸기
        copied.add(N[currIdx]);
        add(currIdx+1, pre);
        add(currIdx+1, copied);
    }
}
