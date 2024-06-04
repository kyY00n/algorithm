package leetcode;

public class Leetcode_409 {

    public int longestPalindrome(String s) {
        char[] sArray = s.toCharArray();

        int[] alphabet = new int[26 * 2];
        for (char ch : sArray) {
            if (Character.isLowerCase(ch)) {
                alphabet[ch - 'a']++;
                continue;
            }
            alphabet[ch - 'A' + 26]++;
        }

        boolean oddExists = false;
        int answer = 0;
        for (int i = 0; i < 26 * 2; i++) {
            if (alphabet[i] % 2 != 0) {
                oddExists = true;
                answer += alphabet[i] - 1;
                continue;
            }
            answer += alphabet[i];
        }
        if (oddExists) {
            answer++;
        }

        return answer;
    }

}
