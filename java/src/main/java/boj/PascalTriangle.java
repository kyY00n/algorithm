package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/15489
public class PascalTriangle {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int W = Integer.parseInt(s[2]);

        int[][] triangle = new int[R+W][R+W];
        for(int i = 0; i < R + W; i++) {
            triangle[i][0] = 1;
            triangle[i][i] = 1;
        }

        for(int i = 1; i < R+W; i++) {
            for(int j = 1; j < i+1; j++) {
                triangle[i][j] = triangle[i-1][j - 1] + triangle[i-1][j];
            }
        }

        int answer = 0;
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < i+1; j++) {
                answer += triangle[i + R - 1][j + C - 1];
            }
        }

        System.out.println(answer);
    }
}
