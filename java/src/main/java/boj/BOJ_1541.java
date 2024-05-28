package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.stream;

public class BOJ_1541 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] group = br.readLine().split("-");

        int answer = stream(group[0].split("\\+"))
                .mapToInt(Integer::parseInt)
                .sum();

        for (int i = 1; i < group.length; i++) {
            answer -= stream(group[i].split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        System.out.println(answer);
    }

}
