package edoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class 대출요청 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 대출 요청의 개수
        int N = Integer.parseInt(br.readLine());

        /**
         * {
         * (1, 2)
         * (3, 6)
         * (5, 8)
         * }
         */
        List<List<Integer>> requests = new ArrayList<>();

        //N개의 줄에 한 사람의 대출일과 반납일이 주어
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            requests.add(List.of(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        requests.sort(comparingInt(a -> a.get(0)));

        // 책의 개수
        int K = Integer.parseInt(br.readLine());
        int[] books = new int[K];

        for(int i = 0; i < N; i++) {
            Arrays.sort(books);
            List<Integer> curr = requests.get(i);
            Integer 대출일 = curr.get(0);
            Integer 반납일 = curr.get(1);
            boolean succeed = false;
            for(int j = K-1; j >= 0; j--) {
                if (books[j] <= 대출일) {
                    books[j] = 반납일;
                    succeed = true;
                    break;
                }
            }
            if (succeed) {
                continue;
            }
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }

}
