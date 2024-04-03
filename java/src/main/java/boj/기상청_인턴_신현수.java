package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기상청_인턴_신현수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] temperature = new int[N];
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            answer += temperature[i];
        }

        int temp = answer;
        for (int i = K; i < N; i++) {
            temp = temp - temperature[i-K] + temperature[i];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }

}
