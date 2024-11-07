package programmers.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class 같은_숫자는_싫어 {

    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if (deque.getLast() == arr[i]) {
                continue;
            }
            deque.addLast(arr[i]);
        }
        int[] answer = new int[deque.size()];
        for(int i = 0; i< answer.length; i++) {
            answer[i] = deque.removeFirst();
        }
        return answer;
    }

}
