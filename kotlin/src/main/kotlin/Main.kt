import java.util.*

var visited = BooleanArray(1001)
val adjMat = Array(1001) { IntArray(1001) { 0 } }

fun dfs(n: Int, size: Int) {
    print("$n ")
    visited[n] = true
    for (i in 0..size) {
        if (adjMat[n][i] == 1) {
            if (!visited[i]) {
                dfs(i, size)
            }
        }
    }
}

fun bfs(n: Int, size: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(n)
    visited[n] = true
    while(queue.isNotEmpty()) {
        val head = queue.poll()
        print("$head ")
        for (i in 0..size) {
            if (adjMat[head][i] == 1) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
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
        adjMat[s][e] = 1
        adjMat[e][s] = 1
    }

    dfs(V, N)
    visited = BooleanArray(1001)
    println()
    bfs(V, N)
}