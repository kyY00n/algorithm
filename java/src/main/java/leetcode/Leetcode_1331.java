package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] ranks = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ranks);

        Map<Integer, Integer> numToRanks = new HashMap<>();

        int rank = 1;
        for(int i = 1; i <= arr.length; i++) {
            if (numToRanks.get(ranks[i-1]) != null) {
                continue;
            }
            numToRanks.put(ranks[i-1], rank++);
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = numToRanks.get(arr[i]);
        }
        return arr;
    }

}
