import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 평균 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strScores = br.readLine().split(" ");
        int[] scores = new int[N];
        int maxScore = 0;
        for(int i = 0; i < N; i++) {
            int score = Integer.parseInt(strScores[i]);
            scores[i] = score;
            maxScore = Math.max(score, maxScore);
        }

        double newSum = 0;
        for(int i = 0; i < N; i++) {
            double newScore = (double) scores[i] / maxScore * 100;
            newSum += newScore;
        }
        System.out.println(newSum / N);
    }

}
