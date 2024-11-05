package programmers.hashing;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Set<Integer> kind = new HashSet<>();
        for (int num : nums) {
            kind.add(num);
        }
        return Math.min(nums.length / 2, kind.size());
    }

}
