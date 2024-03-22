public class StringCompression {

    public static void main(String[] args) {
        StringCompressionSolution solution = new StringCompressionSolution();
        solution.solution("aabbaccc");
    }
}

class StringCompressionSolution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        for(int i = 1; i < length / 2 + 1; i++) {
            // 단축 길이별로 초기화, 어느 부분 읽고 있는지
            int idx = 0;
            String prev = s.substring(idx, idx + i);
            String compressed = "";
            int times = 1;

            // 뒤에서부터 확인
            while (idx + i < length) {
                String curr = idx + i*2 < length ? s.substring(idx + i, idx + i*2) : s.substring(idx + i, length);
                if (prev.equals(curr)) {
                    times++;
                    idx += i;
                    prev = curr;
                    continue;
                }
                compressed += (times == 1 ? "" : times) + prev;
                prev = curr;
                times = 0; // 여기가 왜 0이 되어야하는지를 모르겠음
            }
            compressed += (times == 1 ? "" : times) + prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
