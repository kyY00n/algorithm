package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Arrays.sort(split, Comparator.reverseOrder());
        System.out.println(String.join("", split));
    }
}
