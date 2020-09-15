#include <stdio.h>

int weightNValue[100][2];
int bagWeight[100];
int main(void){
    int N, K; scanf("%d%d", &N, &K);

    for(int i = 0; i < N; i++){
        scanf("%d%d", &weightNValue[i][0], &weightNValue[i][1]);
    }
    int weightSum = 0;

    return 0;
}
