package leetcode;

import java.util.Arrays;

import static java.util.Comparator.comparingInt;

public class Leetcode_826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, comparingInt(a -> a.difficulty));
        Arrays.sort(worker);

        int maxProfit = 0;
        int jobIndex = 0;
        int currentMaxProfit = 0;
        for (int w : worker) {
            while (jobIndex < n && jobs[jobIndex].difficulty <= w) {
                currentMaxProfit = Math.max(currentMaxProfit, jobs[jobIndex].profit);
                jobIndex++;
            }
            maxProfit += currentMaxProfit;
        }

        return maxProfit;
    }
}

class Job {
    public int difficulty;
    public int profit;

    public Job(int d, int p) {
        this.difficulty = d;
        this.profit = p;
    }
}
