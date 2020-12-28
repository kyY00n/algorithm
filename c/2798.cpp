#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int main(void) {
    int N, M;
    scanf("%d%d", &N, &M);
    int* arr = (int*)malloc(sizeof(int)*N);
    for(int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    int min = INT_MAX, sum, sol;
    for(int i = 0; i < N-2; i++) {
        for (int j = i+1; j < N-1; j++) {
            for (int k = j+1; k < N; k++){
                sum = arr[i] + arr[j] + arr[k];
                if (((M - sum) >= 0) && ((M - sum) < min)) {
                    min = M - sum;
                    sol = sum;
                }
            }
        }
    }

    printf("%d", sol);

    return 0;
}
