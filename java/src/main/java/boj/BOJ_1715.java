package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        Long answer = 0L;
        while(pq.size() > 1) { // !pq.isEmpty() 로 하는 경우, 마지막에 원소 1개 일때 예외 발생
            Long temp = pq.poll() + pq.poll(); // 가장 작은 두 숫자의 합을 저장하기
            answer += temp;
            pq.add(temp);
        }

        System.out.println(answer);
    }
}
