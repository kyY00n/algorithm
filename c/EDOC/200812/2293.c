#include <stdio.h>

//모르겠어서 구글링한 코드
int main() {

    int i, j, n, k;
    int dp[10001] = { 0 }; //memoization

    scanf("%d%d", &n, &k);

    int coins[n]; //동전 가치를 저장할 배열.

    for (i = 0; i < n; i++) scanf("%d", &coins[i]);

    dp[0] = 1; //k=0 이면 방법은 1가지이므로.

    for (i = 0; i < n; i++) { //동전 종류마다 반복
        for (j = coins[i]; j <= k; j++) {
            if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]]; // 차곡차곡 방법의 수를 저장합니다. 이해가 안됨요
    }
    printf("%d\n", dp[k]);
    return 0;

}
