import java.util.*
import kotlin.collections.ArrayList

class BOJ1920 {
    fun binarySearch(arr: List<Int>, target: Int, left: Int, right: Int): Int {
        if (left > right) return 0

        val mid = (left + right) / 2
        if (arr[mid] == target) return 1

        if (arr[mid] < target) return binarySearch(arr, target, left + 1, right)
        return binarySearch(arr, target, left, right - 1)
    }
}


// BOJ 1920. 수찾기
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arr: MutableList<Int> = ArrayList()
    repeat(N) {
        arr.add(nextInt())
    }
    arr.sort()
    val M = nextInt()
    val targets: MutableList<Int> = ArrayList()
    repeat(M) {
        targets.add(nextInt())
    }
    BOJ1920().run {
        targets.forEach {
            println(binarySearch(arr, it, 0, N-1))
        }
    }
}