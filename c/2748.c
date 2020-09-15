#include <stdio.h>


long long dp[90+1] = { 0 };

long long fibo(int);

int main(void) {
    int n;
    scanf("%d", &n);

    dp[1]=1;

    printf("%lld\n", fibo(n));

}

long long fibo(int N) {
    if (N < 2) return N;
    if (dp[N] == 0)
        dp[N] = fibo(N-1) + fibo(N-2);
    return dp[N];
}
