package leetcode;

public class LeetCode_3110 {
    public int scoreOfString(String s) {
        char[] sArray = s.toCharArray();

        int answer = 0;
        for(int i = 0; i < sArray.length - 1; i++) {
            answer += getAbsoluteDiff(sArray[i], sArray[i+1]);
        }

        return answer;
    }

    private int getAbsoluteDiff(char a, char b) {
        return Math.abs((int)a - (int)b);
    }
}
