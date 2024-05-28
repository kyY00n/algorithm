package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        PriorityQueue<Timeslot> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.end == t2.end) {
                return t1.start - t2.start;
            }
            return t1.end - t2.end;
        });

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Timeslot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int nextStart = 0;

        int answer = 0;
        while(!pq.isEmpty()) {
            Timeslot polled = pq.poll();
            if (polled.start >= nextStart) {
                answer++;
                nextStart = polled.end;
            }
        }

        System.out.println(answer);

    }
}

class Timeslot {
    public int start;
    public int end;

    public Timeslot(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

}
