#include <stdio.h>
#include <stdlib.h>
#define MAX_TERMS 101

struct {
    float coef;
    int expon;
} terms[MAX_TERMS] = { { 4, 7 }, { 8, 6 }, { 1, 1 }, { 10, 3 }, { -7, 1 }, { 1, 0 } };

int avail = 7;

void add (float coef, int expon) {
    if (avail > MAX_TERMS) {
        printf("저장 불가\n");
        exit(1);
    }
    terms[avail].coef = coef;
    terms[avail].expon = expon;
    avail++;
}

void print_poly (int s, int e) {
    for (int i = s; i < e; i++) {
        printf("%.1fx^%d + ", terms[i].coef, terms[i].expon);
    }
    printf("%.1f^x%d\n", terms[e].coef, terms[e].expon); //이건 꼭 마지막이 상수라는 보장이 없으니까!
}

void poly_add2 (int As, int Ae, int Bs, int Be, int* Cs, int* Ce) {
    *Cs = avail;
    while (As <= Ae && Bs <= Be) {
        if (terms[As].expon > terms[Bs].expon) {
            add(terms[As].coef, terms[As].expon);
            As++;
        }
        else if (terms[As].expon == terms[Bs].expon) {
            add(terms[As].coef+terms[Bs].coef, terms[As].coef);
            As++; Bs++;
        }
        else {
            add(terms[Bs].coef, terms[Bs].expon);
            Bs++;
        }
    }
    for(; As <= Ae; As++) {
        add(terms[As].coef, terms[As].expon);
    }
    for(; Bs <= Be; Bs++) {
        add(terms[Bs].coef, terms[Bs].expon);
    }

    //마지막에 add 함수에서 avail이 한 번 더 증가 했으므로 1을 빼준 값이 Ce의 인덱스가 된다.
    *Ce = avail-1;
}

int main(void) {
    int As = 0, Ae = 3, Bs = 4, Be = 6, Cs, Ce;
    poly_add2(As, Ae, Bs, Be, &Cs, &Ce);
    print_poly(As, Ae);
    print_poly(Bs, Be);
    printf("-----------------------------------------------------\n");
    print_poly(Cs, Ce);
}
