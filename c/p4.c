#include <stdio.h>
#define MAX_TERMS 100

typedef struct {
    int row;
    int col;
    int value;
}element;

typedef struct {
    element data[MAX_TERMS];
    int rownum;
    int colnum;
    int term;
}sparseMatrix;

sparseMatrix transpose2(sparseMatrix A) {
    sparseMatrix B;
    B.rownum = A.colnum;
    B.colnum = A.rownum;
    B.term = A.term;
    if (A.term > 0) {
        int index = 0;
        for (int j = 0; j < A.colnum; j++) {
            for (int i = 0; i < A.term; i++) { //정렬이 되어있지 않으니까 다 순회한다.
                if (A.data[i].col == j) {
                    B.data[index].row = A.data[i].col;
                    B.data[index].col = A.data[i].row;
                    B.data[index].value = A.data[i].value;
                    index++;
                }
            }
        }
    }
    return B;
}

void print(sparseMatrix X) {
    for(int i = 0; i < X.term; i++)
        printf("%3d%3d%3d\n", X.data[i].row, X.data[i].col, X.data[i].value);
    putchar('\n');
}

int main(void)
{
    sparseMatrix A = {
        { {0, 3, 7}, {1, 0, 9}, {1, 2, 8}, {3, 0, 6}, {4, 1, 4} },
        5,
        4,
        5
    };
    sparseMatrix B;
    B = transpose2(A);
    print(A);
    print(B);
}
