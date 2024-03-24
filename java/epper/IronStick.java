import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class IronStick {

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // 여는 괄호이면 스택에 넣기만 한다.
                stack.push('(');
                continue;
            }
            stack.pop();
            if (str.charAt(i-1) == '(') { // 레이저 (포함되는 막대의 개수만큼 카운트)
                answer += stack.size();
                continue;
            }
            answer++; // 막대의 끝 (이미 잘려있으니까 카운트)
        }
        return answer;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(solution(str));
    }
}
