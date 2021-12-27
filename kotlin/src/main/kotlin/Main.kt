// BOJ 1920. 수 찾기
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val N = br.readLine().toInt()
    var arr: List<Int> = br.readLine().split(" ").map { it.toInt() }
    arr = arr.sorted()
    br.readLine()
    val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in input) {
        val res: String = if (arr.binarySearch(i) >= 0) "1" else "0"
        bw.write(res)
        bw.newLine()
    }
    bw.flush()
    bw.close()
    br.close()
}