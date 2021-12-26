import java.util.*
import kotlin.collections.ArrayList

var visited = BooleanArray(1001)
val adjList = Array(1001) { ArrayList<Int>() }

fun dfs(n: Int) {
    print("$n ")
    visited[n] = true
    for (i in adjList[n]) {
        if (!visited[i]) {
            dfs(i)
        }
    }
}

fun bfs(n: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    visited[n] = true
    while (queue.isNotEmpty()) {
        val i = queue.remove()
        print("$i ")
        for (j in adjList[i]) {
            if (!visited[j]) {
                queue.add(j)
                visited[j] = true
            }
        }
    }


}

// BOJ 1260. DFS와 BFS
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val M = nextInt()
    val V = nextInt()

    repeat(M) {
        val s = nextInt()
        val e = nextInt()
        adjList[s].add(e)
        adjList[e].add(s)
    }
    dfs(V)
    visited = BooleanArray(1001)
    println()
    bfs(V)
}

// linkedlist로 하면 문제점: 인접리스트에 있는 애들 중에 가장 먼저 pop되어야 하는 애가 min값이어서 굳이굳이 우선순위 큐로 만들어야함
// 그래서 지금 코드로 하면 수가 작은 정점부터 가지 않고 먼저 간선으로 등록된 정점부터 방문하게 됨.