package leetcode;

public class LeetCode_2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowelCount = new int[words.length];
        if (isVowelString(words[0])) {
            vowelCount[0] = 1;
        }
        for(int i = 1; i < words.length; i++) {
            vowelCount[i] = vowelCount[i-1];
            if (isVowelString(words[i])) {
                vowelCount[i]++;
            }
        }

        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) {
                ans[i] = vowelCount[end];
                continue;
            }
            ans[i] = vowelCount[end] - vowelCount[start - 1];
        }
        return ans;
    }

    private boolean isVowelString(String str) {
        return isVowel(str.charAt(0)) && isVowel(str.charAt(str.length() - 1));
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

}
