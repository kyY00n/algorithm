package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Sixth {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int comp = Math.abs(o1) - Math.abs(o2);
            if (comp == 0) {
                return o1 - o2;
            }
            return comp;
        });

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println("0");
                    continue;
                }
                Integer polled = priorityQueue.poll();
                System.out.println(polled);
                continue;
            }
            priorityQueue.add(x);
        }
    }
}
