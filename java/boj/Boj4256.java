import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj4256 {

    private static int[] pre;
    private static int[] in;
    private static Map<Integer, Integer> indexMap;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            pre = new int[N];
            in = new int[N];
            indexMap = new HashMap<>();
            sb = new StringBuilder();

            String[] preStr = br.readLine().split(" ");
            String[] inStr = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                pre[i] = Integer.parseInt(preStr[i]);
                in[i] = Integer.parseInt(inStr[i]);
                indexMap.put(in[i], i);
            }

            postOrder(0, N - 1, 0, N - 1);
            System.out.println(sb.toString().trim());
        }
    }

    private static void postOrder(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return;
        }

        int root = pre[preStart];
        int rootIdxIn = indexMap.get(root);
        int leftTreeSize = rootIdxIn - inStart;

        postOrder(preStart + 1, preStart + leftTreeSize, inStart, rootIdxIn - 1);
        postOrder(preStart + leftTreeSize + 1, preEnd, rootIdxIn + 1, inEnd);

        sb.append(root).append(' ');
    }
}
