#백트래킹 입문 문제 3: N과 M
#1과 다른 점: 중복 가능 -> 방문 검사 필요 없음.
import sys
N, M = map(int, sys.stdin.readline().split())
out = [] #출력할 수열

def solve(depth, N, M): #N은 숫자 개수, M은 길이
    if depth == M:
        sys.stdout.write(' '.join(map(str, out))+'\n')
        return
    for i in range(N):
        out.append(i+1) #출력할 수열에 추가
        solve(depth+1, N, M) #다음 깊이 재귀함수
        #여기서 이제 다 출력이 됐을거고
        out.pop() #수열에서 빼기

solve(0, N, M)