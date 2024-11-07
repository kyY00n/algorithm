package programmers.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능_개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int needDays = remain / speeds[i];
            if (remain % speeds[i] != 0) {
                needDays += 1;
            }
            queue.offer(needDays);
        }
        List<Integer> deployments = new ArrayList<>();
        int day = 1;
        while(!queue.isEmpty()) { // one loop stands for one day.
            int count = 0;
            while (!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
                count++;
            }
            if (count > 0) {
                deployments.add(count);
            }
            day++;
        }
        int[] answer = new int[deployments.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = deployments.get(i);
        }
        return answer;
    }
}
