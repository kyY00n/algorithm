import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Boj4256 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while ( T-- > 0 ) {
            int N = Integer.parseInt(br.readLine());
            String[] preStr = br.readLine().split(" ");
            String[] inStr = br.readLine().split(" ");
            List<String> pre = List.of(preStr);
            List<String> in = List.of(inStr);
            post(pre, in);
            System.out.println();
        }
    }

    private static void post(List<String> pre, List<String> in) {
        if (pre.isEmpty() && in.isEmpty()) {
            return;
        }
        if (pre.size() == 1 && in.size() == 1) {
            System.out.printf("%s ", pre.get(0));
            return;
        }

        String root = pre.get(0);
        int rootIdxIn = in.indexOf(root);

        List<String> leftPre = pre.subList(1, rootIdxIn + 1);
        List<String> leftIn = in.subList(0, rootIdxIn);

        post(leftPre, leftIn);

        List<String> rightPre = pre.subList(rootIdxIn+1, pre.size());
        List<String> rightIn = in.subList(rootIdxIn+1, in.size());
        post(rightPre, rightIn);

        System.out.printf("%s ", root);
    }

}
