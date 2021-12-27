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

// BOJ 1920. 수 찾기
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val N = br.readLine().toInt()
    val arr: IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    br.readLine()
    val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in input) {
        bw.write(binarySearch(i, arr, N).toString())
        bw.newLine()
    }
    bw.flush()
    bw.close()
    br.close()
}