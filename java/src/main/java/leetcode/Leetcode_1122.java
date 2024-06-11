package leetcode;

import java.util.Arrays;

public class Leetcode_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] idx = new int[1000 + 1];
        Arrays.fill(idx, 10000);
        for (int i = 0; i < arr2.length; i++) {
            idx[arr2[i]] = i;
        }
        int[] boxArr1 = Arrays.stream(arr1)
                .boxed()
                .sorted((a, b) -> {
                    if (idx[a] == idx[b]) {
                        return (idx[a] + a) - (idx[b] + b);
                    }
                    return idx[a] - idx[b];
                })
                .mapToInt(i -> i)
                .toArray();

        return boxArr1;
    }

}
