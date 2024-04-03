package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Third {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String lowerWord = word.toLowerCase();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        int maxIndex = -1;
        int max = 0;
        for(int i = 0; i < lowerWord.length(); i++) {
            int idx = (int) lowerWord.charAt(i) - (int) 'a';
            count[idx]++;
            if (count[idx] == max) {
                maxIndex = -1;
            }
            if (count[idx] > max) {
                maxIndex = idx;
                max = count[idx];
            }
        }
        if (maxIndex == -1) {
            System.out.println("?");
            return;
        }
        System.out.println((char) ((int)'A' + maxIndex));
    }
}
