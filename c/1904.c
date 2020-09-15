#include <stdio.h>
#define MOD 15746

//1904. 01타일, 훌륭한 풀이: http://blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787441430

int dp[1000000+1]; //N<=1,000,000 이다.

int sol(int n) { //그냥 피보나치 수열같은 그런,,거였다.
    if(dp[n]==0) {
        return dp[n] = (sol(n-1) + sol(n-2)) % MOD;
    }
    return dp[n];
}

int main(void) {
    int N;
    scanf("%d", &N);

    dp[0] = -1; dp[1] = 1; dp[2] = 2;
    printf("%d", sol(N));

    return 0;
}
