#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <vector>
using namespace std;

int n;
int *Ceil, *Bottom, *result;
int tmp = 0;
vector <int> *graph;

int main(void) {
   scanf("%d", &n);
   Ceil = (int *)malloc(sizeof(int)*(n + 2));
   Bottom = (int *)malloc(sizeof(int)*(n + 2));
   result = (int *)malloc(sizeof(int)*(n + 2)); 
   graph = new vector<int>(n + 1);

   for (int i = 1; i <= n; i++) {
      scanf("%d ", &Ceil[i]);
   }
   for (int i = 1; i <= n; i++) {
      scanf("%d ", &Bottom[i]);
   }//입력받기

   for (int i = 1; i <= n; i++) {
      for (int j = Bottom[i] + 1; j <= Ceil[i] - 1; j++) {
         graph[i].push_back(j);
      }
   }//배열에 넣기

   for (int i = 1; i <= n; i++) {
      int t_min = 2001; //최소값은 최대로 설정
      int next;
      for (next = 0; next < graph[i].size(); next++) { //y좌표에 대해 모두 반복
         int d = abs(tmp - graph[i][next]); //현재 y좌표와의 거리 계산
         if (t_min > d) { 
            t_min = d; //최소값 갱신
         }
      }
      tmp = graph[i][next]; //현재 y좌표 갱신
      result[i] = graph[i][next]; //배열에 저장
      printf("%d ", result[i]); //출력
   }
   return 0;
}