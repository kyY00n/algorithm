package leetcode._1456;

import java.util.Set;

public class Leetcode_1456 {

    private Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int temp = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (vowels.contains(sArray[i])) {
                temp++;
            }
        }

        int max = temp;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(sArray[i - k])) {
                temp--;
            }
            if (vowels.contains(sArray[i])) {
                temp++;
            }
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

}
