package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(T.length() != S.length()) {
            if (T.endsWith("A")) {
                T = T.substring(0, T.length() - 1);
                continue;
            }
            T = T.substring(0, T.length() - 1);
            T = new StringBuffer(T).reverse().toString();
        }

        if (T.equals(S)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
