package programmers;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        if (K == 0) {
            return 0;
        }
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (true) {
            if (pq.peek() >= K) {
                break;
            }
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            if (second == 0) {
                return -1;
            }
            answer++;
            int newValue = first + second * 2;
            pq.add(newValue);
        }

        return answer;
    }

}
