import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class LuckyWheel {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        String[] wheel = new String[N];
        Arrays.fill(wheel, "?");

        /*
         * ! 케이스
         * 이미 할당된 알파벳이 새로운 위치에 나오는 경우
         * 이미 할당된 곳에 다른 알파벳이 나오는 경우
         *
         */
        HashSet<String> already = new HashSet<>();
        int index = 0;
        for (int i = 0; i < K; i++) {
            String[] s1 = br.readLine().split(" ");
            int S = Integer.parseInt(s1[0]);
            String alphabet = s1[1];
            index = (index + S) % N;
            if (already.contains(alphabet) && !wheel[index].equals(alphabet) || !wheel[index].equals("?") && !wheel[index].equals(alphabet)) {
                System.out.println("!");
                return;
            }
            already.add(alphabet);
            wheel[index] = alphabet;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(wheel[(index - i + N) % N]);
        }
    }

}
