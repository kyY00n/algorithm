package leetcode;

// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/?envType=daily-question&envId=2024-05-23
public class Leetcode_2597 {
    private int[] nums;
    private int[] cnt = new int[1010];
    private int ans = -1;
    private int k;

    public int beautifulSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= nums.length) {
            ++ans; // 하나의 부분 집합을 찾았으므로 카운트를 증가시킴
            return;
        }
        dfs(i + 1); // 현재 숫자를 부분 집합에 포함시키지 않고 다음 숫자로 진행

        // nums[i] + k가 배열의 길이를 벗어나거나 해당 값이 부분 집합에 포함되지 않은 경우
        boolean ok1 = nums[i] + k >= cnt.length || cnt[nums[i] + k] == 0;
        // nums[i] - k가 0보다 작거나 해당 값이 부분 집합에 포함되지 않은 경우
        boolean ok2 = nums[i] - k < 0 || cnt[nums[i] - k] == 0;

        if (ok1 && ok2) {
            ++cnt[nums[i]]; // 현재 숫자를 부분 집합에 포함시킴
            dfs(i + 1); // 다음 숫자로 진행
            --cnt[nums[i]]; // 재귀 호출 후 상태 복원
        }
    }
}

