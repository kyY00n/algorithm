#include <stdio.h>
int memo[1000];

int main(void) {
    int N;
    scanf("%d", &N);
    int** costs = (int**) malloc(sizeof(int*)*N);
    for(int i = 0; i < N; i++){
        costs[i] = malloc(sizeof(int)*3);
    }
    for(int i = 0; i < N; i++){
        scanf("%d%d%d", &costs[i][0], &costs[i][1], &costs[i][2]);
    }



    for(int i = 0; i < N; i++) free(costs(i));
    free(costs);
    return 0;
}
