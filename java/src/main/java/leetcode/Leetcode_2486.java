package leetcode;

public class Leetcode_2486 {
    public int appendCharacters(String s, String t) { // 3ms
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int sPointer = 0;
        int answer = tArray.length;
        for(int i = 0; i < tArray.length; i++) {
            boolean exists = false;
            for(int j = sPointer; j < sArray.length; j++) {
                if (sArray[j] == tArray[i]) {
                    answer--;
                    sPointer = j + 1;
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                break;
            }
        }
        return answer;
    }

    public int improvedAppendCharacters(String s, String t) { // charAt 쓰면 5ms, char 배열 인덱스 접근은 3ms
        int m = s.length();
        int n = t.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (sArray[i] == tArray[j]) j++;
            i++;
        }

        return n - j;
    }
}
