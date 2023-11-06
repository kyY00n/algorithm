public class DeliveryAndPickUp {

    // https://school.programmers.co.kr/learn/courses/30/lessons/150369
    public static void main(String[] args) {
        /**
         * 4	5	[1, 0, 3, 1, 2]	[0, 3, 0, 4, 0]	16
         * 2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
         */
//        long solution = solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        long solution = solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(solution);
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // delivery 를 센다.
        // pickup을 센다.
        int d = 0;
        int p = 0;

        for(int i = n; i > 0; i--) { // 가장 먼 곳부터 반복한다.
            d += deliveries[i-1];
            p += pickups[i-1];
            int count = 0;

            while (d > 0 || p > 0) {
                d -= cap;
                p -= cap;
                count += 1;
            }
            answer += count * i * 2; // 다녀온 곳을 왕복하는 거리는 *2.
        }

        return answer;
    }

}
