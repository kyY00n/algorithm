#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void* a, const void* b) {
    int x = *(int*)a, y = *(int*)b;
    if(x > y) return 1;
    else if (x < y) return -1;
    else return 0;
}
int main(void) {
    int N, i, j;
    float sum = 0.0;
    scanf("%d", &N);
    int* arr = malloc(sizeof(int)*N);

    //산술평균 구하기
    for(i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }
    printf("%.1lf\n", round(sum*100/N)/100);

    //중앙값 찾기
    qsort(arr, N, sizeof(int), compare);
    printf("%d\n", arr[N/2+1]);

    //최빈값 찾기
    int max = 0;
    int maxNums[3] = { 0 }; //두번째로 작은 값까지만 저장하면 되잖아! ^_^
    int* p1, p2;
    for(i = 0; i < N; i++) {
        p1 = &arr[i];

        for(j = i+1; j < N; j++){
            p2 = &arr[j];
            if(*p1 != *p2) break;
        }
        if(max == (p2 - p1)) {

        }
        if(max < (p2 - p1)) {
            maxNums[0] = *p1;
            maxNums[1] = 0;
            maxNums[2] = 0;
        }
    }
    printf("%d\n", maxNum);

    free(arr);
    return 0;
}
