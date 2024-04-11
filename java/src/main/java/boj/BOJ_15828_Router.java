package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_15828_Router {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>(N);

        while(true) {
            int packet = Integer.parseInt(br.readLine());
            if (packet == -1) {
                break;
            }
            if (packet == 0) {
                Integer polled = queue.poll();
                continue;
            }
            if (queue.size() == N) {
                continue;
            }
            queue.add(packet);
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
            return;
        }

        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

}
