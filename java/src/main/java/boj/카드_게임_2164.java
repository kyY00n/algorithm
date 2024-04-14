package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드_게임_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            deque.add(i);
        }
        int answer = getAnswer_solution(deque);
        System.out.println(answer);
    }

    private static int getAnswer(final Deque<Integer> deque) {
        while (!deque.isEmpty()) {
            Integer top = deque.pop();
            Integer polled = deque.poll();
            if (polled == null) {
                return top;
            }
            deque.offer(polled);
        }
        throw new IllegalArgumentException("답이 없어요");
    }

    private static int getAnswer_solution(final Deque<Integer> deque) {
        while (deque.size() > 1) {
            deque.poll();
            deque.offer(deque.poll());
        }
        return deque.poll();
    }

}
