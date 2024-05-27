package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int Z = Y * 100 / X;

        if (Z == 100) {
            System.out.println(-1);
            return;
        }

        // 최대가 몇인지를 모르겠음
        int s = 1, e = X;
        int middle;
        int res = -1;
        while(s <= e) {
            middle = (s + e) / 2;
            int newZ = (Y + middle) * 100 / (X + middle) ;
            if (newZ > Z) {
                res = middle;
                e = middle - 1;
                continue;
            }
            s = middle + 1;
        }

        System.out.println(res);

    }

}
