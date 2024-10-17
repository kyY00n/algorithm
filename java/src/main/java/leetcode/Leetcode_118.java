package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_118 {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(List.of(1));
        }
        if (numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        }

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(List.of(1));
        answer.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) { // iterate j from 1 to i (closed)
                list.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
            }
            list.add(1);
            answer.add(list);
        }
        return answer;
    }

    public List<List<Integer>> generate_recursive(int numRows) {
//        if (numRows == 1) { // if we use List.of, get UnsupportedOperationException
//            return List.of(List.of(1));
//        }

        if (numRows == 1) {
            List<List<Integer>> answer = new ArrayList<>();
            answer.add(Arrays.asList(1));
            return answer;
        }

        List<List<Integer>> answerWithoutCurrent = generate_recursive(numRows - 1);

        List<Integer> current = new ArrayList<>();
        current.add(1);

        List<Integer> prev = answerWithoutCurrent.get(answerWithoutCurrent.size() - 1);
        for (int i = 1; i < numRows - 1; i++) {
            current.add(prev.get(i - 1) + prev.get(i));
        }
        current.add(1);

        answerWithoutCurrent.add(current);
        return answerWithoutCurrent;
    }

}
