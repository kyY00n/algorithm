import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 문자열_판별 {

    static String[] A;
    static int N;
    static Map<String, Boolean> dp = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
            dp.put(A[i], true);
        }
        System.out.println(doesExist(S) ? 1 : 0);
    }

    private static boolean doesExist(String hi) {
        if (dp.containsKey(hi)) {
            return dp.get(hi);
        }
        boolean answer = false;
        for(int i = 0; i < N; i++) {
            if (hi.endsWith(A[i])) {
                answer = doesExist(hi.substring(0, hi.length() - A[i].length()));
                if (answer) {
                    break;
                }
            }
        }
        dp.put(hi, answer);
        return answer;
    }

}
