package programmers;

import java.util.*;

class 프로세스 {
    public int solution(int[] priorities, int location) {
        Queue<Element> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(new Element(priorities[i], i));
            pq.offer(priorities[i]);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            Element polled = queue.poll();
            if (polled.priority == pq.peek()) {
                pq.poll();
                count++;
                if (polled.isLocated(location)) {
                    return count;
                }
                continue;
            }
            queue.offer(polled);
        }
        return count;
    }
}

class Element {
    public int priority;
    public int location;

    public Element(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

    boolean isLocated(int location) {
        return location == this.location;
    }
}
