package 트리;
import java.util.*;

class Node {
	String root;
	String left;
	String right;
	
	public Node() { }
	public Node(String r, String l, String ri) {
		root = r; left = l; right = ri;
	}
}	

public class ss1991 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Node[] tree = new Node[N];
		
		for(int i = 0; i < N; i++) {
			tree[i] = new Node(sc.next(), sc.next(), sc.next());
		}
		
	}
	
	//preorder(전위순회): root-left-right
	public static void preorder(Node[] t, int i) {
		if(!t[i].left.equals(".")) {
			t[i].left = "";
		}
	}

}
