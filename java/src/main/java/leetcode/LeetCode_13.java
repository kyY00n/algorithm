package leetcode;

import java.util.Map;

public class LeetCode_13 {

    private Map<Character, Integer> charToValue = Map.of('I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && charToValue.get(chars[i]) < charToValue.get(chars[i + 1])) {
                answer -= charToValue.get(chars[i]);
                continue;
            }
            answer += charToValue.get(chars[i]);
        }
        return answer;
    }

}
