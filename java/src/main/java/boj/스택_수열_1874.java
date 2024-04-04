package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * 제한시간: 2초 입력: - n개의 요소, 1 ≤ n ≤ 100,000
 */
public class 스택_수열_1874 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] seq = new int[N];

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        int 마지막으로_넣은_수 = 1;
        for(int i = 0; i < N; i++) {
            int 이번에_비교할_수 = seq[i];
            if (마지막으로_넣은_수 <= 이번에_비교할_수) {
                while(마지막으로_넣은_수 <= 이번에_비교할_수) {
                    stack.push(마지막으로_넣은_수++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                continue;
            }
            int 스택의_top = stack.pop();
            if (스택의_top > 이번에_비교할_수) { // 비교할 수보다 큰 건 아직 나오면 안되는데!
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }
        br.close();
        System.out.println(sb);
    }
}

/**
 * bufferedwriter를 사용하면 출력초과가 뜬다.
 * 참고: https://velog.io/@ahn_s/JAVA-BufferedWriter-%EC%B6%9C%EB%A0%A5%EC%B4%88%EA%B3%BC-%EC%9D%B4%EC%9C%A0
 */
class 출력초과 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int[] seq = new int[N];

        for(int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++) {
            int su = seq[i];
            if (num <= su) {
                while(num <= su) {
                    stack.push(num++);
                    bw.write("+\n");
                }
                stack.pop();
                bw.write("-\n");
                continue;
            }
            int top = stack.pop();
            if (top > su) {
                System.out.println("NO");
                return;
            }
            bw.write("-\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
