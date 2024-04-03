package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 과제안내신분 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> hi = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            hi.add(i+1);
        }
        for(int i = 0; i < 28; i++) {
            int exist = Integer.parseInt(br.readLine());
            hi.removeIf(hey -> hey == exist);
        }
        Collections.sort(hi);
        hi.stream().forEach(i -> System.out.println(i));
    }

}
