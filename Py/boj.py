import copy
from collections import deque

N = int(input())
graph = [[] for _ in range(N + 1)]  # graph[n] : t_n번째 사람 주변인이 저장된 리스트
for i in range(1, N + 1):
    inp = list(map(int, input().split()))
    graph[i] = copy.deepcopy(inp[:-1])

input()
start = list(map(int, input().split()))

ans = [-1] * (N + 1)

for s in start:
    ans[s] = 0

trust = [0]*(N+1)  # 믿는 주변인의 수를 저장하는 배열

def solve():
    que = deque()
    que.extend(start)
    while que:
        curr = que.popleft()
        for e in graph[curr]:
            trust[e] += 1
            # 주변인의 절반 이상이 루머를 믿는다
            if ans[e] == -1 and trust[e] >= (len(graph[e])+1)//2:
                ans[e] = ans[curr] + 1
                que.append(e)


solve()

for i in range(1, len(ans)):
    print(ans[i], end=' ')