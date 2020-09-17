#include <stdio.h>
#define ROWS 3
#define COLS 3

void print(int A[ROWS][COLS])
{
    for (int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++)
            printf("%3d", A[i][j]);
        putchar('\n');
    }
    putchar('\n');
}

void transpose(int A[ROWS][COLS], int B[ROWS][COLS])
{
    for (int i = 0; i < ROWS; i++)
    {
        for (int j = 0; j < COLS; j++) B[i][j] = A[j][i];
    }
}

int main(void)
{
    int A[ROWS][COLS] = {
        {2, 3, 0}, {8, 9, 1}, {7, 0, 5}
    };
    int B[ROWS][COLS];
    print(A); //³»°¡ Àú À§¿¡´Ù ¼±¾ðÇØ³ùÀÝ¾Æ....ÇÏ ±ô³î
    transpose(A, B);
    print(B);

    return 0;
}
