#include<stdio.h>

void main() {
    int i = 0, n, a; char c;

    /*
        for문을 이용해 입력 및 조건식 처리
        1) 초기화: 식의 첫번째 숫자를 입력받음
        2) 조건식: 덧셈/뺄셈 기호를 c에 입력받음 -> c가 개행문자가 아닐 때
    */

    for (scanf_s("%d", &n); c != '\n'; ) { //10: '/n'

        //-일때 i=1로 바꿔준다.
        if (c == '-') i = 1;
        scanf_s("%d", &a);

        //i=1일때, 즉, -부호가 최초로 들어왔을 때 n에서 계속 빼준다.
        if (i) n -= a;

        //i=0, 즉 아직 -부호가 들어오지 않았거나, 처음 입력받았을 땐 n에 입력받은 수를 더해준다.
        else n += a;

        scanf_s("%c", &c);
    }
    printf("%d", n);
}