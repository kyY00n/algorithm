import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClassroomDistribution { // boj 11000. 강의실 배정

    // 이 문제는 우선순위 큐에 남아있는 갯수를 활용하는 것이 포인트!
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> timeslots = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int t = Integer.parseInt(line[1]);
            timeslots.add(List.of(s, t));
        }

        Collections.sort(timeslots, Comparator.comparingInt(a -> a.get(0)));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>(); // 기본값으로 해도 됨
        endTimes.offer(timeslots.get(0).get(1));

        for (int i = 1; i < N; i++) {
            List<Integer> timeslot = timeslots.get(i);
            Integer start = timeslot.get(0);
            Integer end = timeslot.get(1);
            if (endTimes.peek() <= start) {
                endTimes.poll();
            }
            endTimes.offer(end);
        }

        System.out.println(endTimes.size());
    }

}
