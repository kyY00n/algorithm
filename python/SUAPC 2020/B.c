#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n, x;
    scanf("%d %d", &n, &x);

    int *CEs = malloc(sizeof(int)*(n+1));
    int a, b;
    for(int i = 0; i < n+1; i++) {
        scanf("%d%d", &a, &b);
        CEs[b] = a;
    }

    int res = CEs[n] * x + CEs[n-1];
    for(int i = n-1; i > 0; i--) {
        res = x * res + CEs[i-1];
    }

    printf("%d", res % 1000000007);
    return 0;
}
