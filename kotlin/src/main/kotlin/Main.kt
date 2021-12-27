import java.util.*

fun binarySearch(n: Int, arr: IntArray, s: Int): Int { // return if n is in arr of s elements
    var mid: Int = s / 2
    var left = 0
    var right = s - 1
    while (left <= right) {
        if (arr[mid] == n) {
            return 1
        }
        if (arr[mid] > n) {
            right = mid
            mid = (left + right) / 2
        } else {
            left = mid + 1
            mid = (left + right) / 2
        }
    }
    return 0
}

// BOJ 1920. 수찾기
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = nextInt()
    }
    arr.sort()
    repeat(nextInt()) {
        print("${binarySearch(nextInt(), arr, N)} ")
    }
    bw.flush()
    bw.close()
    br.close()
}