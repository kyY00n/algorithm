import java.util.*;
class Graph {
	int nodeNum;
	private LinkedList<Integer> adjList[];
	int[] depth;
	
	public Graph() {}
	public Graph(int n)
	{
		nodeNum = n;
		adjList = new LinkedList[n];
		depth = new int[n];
		for(int i = 0; i<n; i++) {
			adjList[i] = new LinkedList();
			depth[i] = -1;
		}
		
	}
	
	void edge(int v1, int v2) {
		adjList[v1].add(v2);
	}
	
	void bfs(int root) {
		int count = 0;
		depth[root] = 0;
		
		boolean visited[] = new boolean[nodeNum];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[root] = true;
		queue.add(root);
		
		while(queue.size() != 0) {
			root = queue.poll();
			
			Iterator<Integer> i = adjList[root].listIterator();
			while(i.hasNext()) {
				count++;
				int n = i.next();
				
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
					
					if(depth[n] == -1 || Math.min(depth[n], count) == count) {
						depth[n] = count;
					}
					
				}
			}
		}
		
	}
}
public class ucpc_G {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Graph g = new Graph(N);
		
		int v = -1;
		
		for(int i = 0; i < N; i++) {
			while((v = sc.nextInt())!=0) {
				g.edge(i, v);
			}
		}
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			g.bfs(sc.nextInt());
		}
		
		for(int i = 0; i< N; i++) {
			System.out.print(g.depth[i]+" ");
		}
	}
	
	
}
