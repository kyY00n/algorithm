#include <stdio.h>
int arr[14];
int arr2[14];
int K;

void DFS(int Start, int Depth)
{
    int i;
    if (Depth == 6)
    {
        for (i = 0; i < 6; i++)
        {
            printf("%d ", arr2[i]);
        }
        printf("\n");
    }
    else
    {
        for (i = Start; i < K; i++) //K는 전역변수, main에서 입력받는 숫자의 개수!
        {
            arr2[Depth] = arr[i]; //여기서 배열에 저장하는 거임 
            //출력은 한 줄 단위!
            DFS(i + 1, Depth + 1);
        }

    }
}

int main()
{
    int i;

    while (1)
    {
        scanf("%d", &K);
        if (K == 0)
            break;
        for (i = 0; i < K; i++)
            scanf("%d", &arr[i]);
        DFS(0, 0);
        printf("\n");
    }
}