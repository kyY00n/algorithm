import java.util.*
import kotlin.collections.ArrayList

fun getInterval(n: Int): MutableList<Int> {
    val first = n % 10
    val list: MutableList<Int> = ArrayList()
    if (first == 0) {
        list.add(10)
        return list
    }
    list.add(first)
    while (list[0] != list[list.size - 1] * first % 10) {
        list.add(list[list.size - 1] * first % 10)
    }
    return list
}

// BOJ 1009.분산처리
fun main() = with(Scanner(System.`in`)) {
    val res: MutableList<Int> = ArrayList()
    repeat(
        nextInt()
    ) {
        val a = nextInt()
        val b = nextInt()
        val intervalSeq = getInterval(a)
        val intervalSize = intervalSeq.size
        res.add(intervalSeq[(b - 1) % intervalSize])
    }
    res.forEach { println(it) }
}