package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Fourth {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        for(int i = 0; i < 10; i ++) {
            int newScore = Integer.parseInt(br.readLine());
            int beforeAbs = Math.abs(score - 100);
            int afterAbs = Math.abs(score + newScore - 100);
            if (beforeAbs < afterAbs) {
                break;
            }
            score += newScore;
            if (score > 100) {
                break;
            }
        }
        System.out.println(score);
    }
}
