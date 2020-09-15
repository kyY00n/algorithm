#include <stdio.h>
#include <stdlib.h>

int main()
{
    int N, n;
    scanf_s("%d", &N);
    int a = 0;
    int l = 0;

    n = N;
    while (l < n / 3) {
        if (a > n / 3 && a < n - (n / 3)) {
            for (int j = 0; j < n; j++) {
                if (j > n / 3 - 1 && j < n - (n / 3))
                    printf(" ");
                else
                    printf("*");
            }
            printf("\n");
            a++;
            for (int j = 0; j < n / 3; j++) {
                if (j > (n / 3) / 3 - 1 && j < (n / 3) - ((n / 3) / 3))
                    printf("   ");
                else
                    printf("* *");
            }
            printf("\n");
            a++;
            for (int j = 0; j < n; j++) {
                if (j > n / 3 - 1 && j < n - (n / 3))
                    printf(" ");
                else
                    printf("*");
            }
            printf("\n");
            a++;
        }
        else {
            for (int j = 0; j < n; j++) {
                printf("*");
            }
            printf("\n");
            a++;
            for (int j = 0; j < n / 3; j++)
                printf("* *");
            printf("\n");
            a++;
            for (int j = 0; j < n; j++) {
                printf("*");
            }
            printf("\n");
            a++;

        }
        a++;
        l++;
    }

    return 0;
}