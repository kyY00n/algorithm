package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) { // if heights of two elements are same
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]); // prioritize taller person
        });

        List<int[]> answer = new ArrayList<>();
        for (int[] person : people) {
            answer.add(person[1], person);
        }
        return answer.toArray(new int[people.length][2]);
    }

}
