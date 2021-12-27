import java.util.*

var visited = BooleanArray(1001)
val adjList = Array(1001) { PriorityQueue<Int>() }

fun dfs(n: Int) {
    print("$n ")
    visited[n] = true
    val adjListIter = adjList[n].iterator()
    while (adjListIter.hasNext()) {
        val curr = adjListIter.next()
        if (!visited[curr]) {
            dfs(curr)
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
        val adjListIter = adjList[i].iterator()
        while (adjListIter.hasNext()) {
            val curr = adjListIter.next()
            if (!visited[curr]) {
                queue.add(curr)
                visited[curr] = true
            }
        }
    }


}

// BOJ 1260. DFS와 BFS
fun main() = with(Scanner(System.`in`)) {
    nextInt()
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

// priorityQueue 씀