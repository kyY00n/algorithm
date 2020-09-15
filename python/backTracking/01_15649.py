#백트래킹 입문 문제 1: N과 M
import sys
N, M = map(int, sys.stdin.readline().split())
visited = [False] * N #방문 여부
out = [] #출력할 수열

def solve(depth, N, M):
    if depth == M:
        sys.stdout.write(' '.join(map(str, out))+'\n')
        return
    for i in range(N):
        if not visited[i]: #방문한 적이 없다면
            visited[i] = True #방문 처리
            out.append(i+1) #출력할 수열에 추가
            solve(depth+1, N, M) #다음 깊이 재귀함수
            #여기서 이제 다 출력이 됐을거고

            visited[i] = False #최상단 노드의 방문을 다시 false로 돌리고
            out.pop() #수열에서 빼기

solve(0, N, M)