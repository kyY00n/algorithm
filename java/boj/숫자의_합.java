import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자의_합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int answer = Arrays.stream(br.readLine().split(""))
                .mapToInt(number -> Integer.parseInt(number)).sum();
        System.out.println(answer);
    }
}
