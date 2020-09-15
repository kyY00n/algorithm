#include <stdio.h>

int cmb(int, int);

int dp[30][30] = { 0 }; //memoization

int main(void) {

    int R, C, W;
    scanf("%d%d%d", &R, &C, &W);

    int sum = 0;

    for(int i = 0; i < W; i++){
        for(int j = 0; j < i+1; j++){
            printf("cmb(%d, %d) = %d\n", R+i, C+j, cmb(R+i, C+j));
            sum += cmb(R+i, C+j);
        }
    }
    printf("%d\n", sum);
    return 0;
}

int cmb(int n, int r) { //nCr 결과를 반환하는 함수! 파스칼의 삼각형 이용.
    if (dp[n][r] != 0) {
        return dp[n][r];
    }

    if (r == 1) return dp[n][r] = n;
    if (n == r) return dp[n][r] = 1;

    return dp[n][r] = cmb(n-1, r-1) + cmb(n-1, r);

}
