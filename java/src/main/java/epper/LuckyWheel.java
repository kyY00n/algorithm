package epper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class LuckyWheel {

    private static HashSet<String> already = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        // 바퀴 칸의 수
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        String[] wheel = new String[N]; // 글자를 거꾸로 저장해놓는 배열
        Arrays.fill(wheel, "?");

        int targetIndex = 0;
        for(int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            int S = Integer.parseInt(line[0]);
            String stopped = line[1];

            targetIndex = (targetIndex + S) % N; // 이전 타겟에 더해줘야함

            // !를 해야하는 경우
            if (!isValid(wheel, targetIndex, stopped)) {
                System.out.println("!");
                return;
            }

            wheel[targetIndex] = stopped;
            already.add(stopped);
        }

        // 거꾸로 출력해야함!!!!
        for(int i = 0; i < N; i++) {
            System.out.print(wheel[(targetIndex - i + N) % N]);
        }
    }

    private static boolean isValid(String[] wheel, int targetIndex, String stopped) {
        if (!wheel[targetIndex].equals("?")) { // 비어있지 않으면
            return wheel[targetIndex].equals(stopped); // 같은 문자면 괜찮다.
        }
        if (already.contains(stopped)) { // 이미 나온 문자이면 안된다
            return false;
        }
        return true;
    }

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int K = Integer.parseInt(s[1]);
//
//        String[] wheel = new String[N];
//        Arrays.fill(wheel, "?"); // 물음표로 초기화
//
//        /*
//         * ! 케이스
//         * 이미 할당된 알파벳이 새로운 위치에 나오는 경우
//         * 이미 할당된 곳에 다른 알파벳이 나오는 경우
//         *
//         */
//        HashSet<String> already = new HashSet<>();
//        int index = 0;
//        for (int i = 0; i < K; i++) {
//            String[] s1 = br.readLine().split(" ");
//            int S = Integer.parseInt(s1[0]);
//            String alphabet = s1[1];
//            index = (index + S) % N;
//            if (already.contains(alphabet) && !wheel[index].equals(alphabet) || !wheel[index].equals("?") && !wheel[index].equals(alphabet)) {
//                System.out.println("!");
//                return;
//            }
//            already.add(alphabet);
//            wheel[index] = alphabet;
//        }
//        for (int i = 0; i < N; i++) {
//            System.out.print(wheel[(index - i + N) % N]);
//        }
//    }

}
