import java.util.*

// BOJ 2747. 피보나치 수
fun main() = with(Scanner(System.`in`)) {
    val dp = IntArray(46) { 0 }
    dp[0] = 0
    dp[1] = 1
    for (i in 2..45) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    val n = nextInt()
    println(dp[n])
}