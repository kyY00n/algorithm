import java.util.*

fun binarySearch(arr: IntArray, target: Int, left: Int, right: Int): Int {
    if (left > right) return 0

    val mid = (left + right) / 2
    if (arr[mid] == target) return 1

    if (arr[mid] < target) return binarySearch(arr, target, left + 1, right)
    return binarySearch(arr, target, left, right - 1)
}

// BOJ 1920. 수찾기
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = nextInt()
    }
    arr.sort()
    val M = nextInt()
    val targets = IntArray(M)
    for (i in 0 until M) {
        targets[i] = nextInt()
    }
    targets.forEach {
        println(binarySearch(arr, it, 0, N-1))
    }
}