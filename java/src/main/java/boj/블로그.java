package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitPerDay = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            visitPerDay[i] = Integer.parseInt(st.nextToken());
        }

        int maxVisitCount = 0;
        int count = 1;
        for(int i = 0; i < X; i++) {
            maxVisitCount += visitPerDay[i];
        }

        int temp = maxVisitCount;
        for(int i = X; i < N; i++) {
            temp = temp - visitPerDay[i-X] + visitPerDay[i];
            if (temp == maxVisitCount) {
                count++;
            }
            if (temp > maxVisitCount) {
                count = 1;
                maxVisitCount = temp;
            }
        }

        if (maxVisitCount == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(maxVisitCount);
        System.out.println(count);
    }

}
