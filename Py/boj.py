from collections import deque

N, M = map(int, input().split())  # 사다리 개수, 뱀 개수

ans = [0] * 100  # 각 점으로 가는 최소 경로
ans[0] = 0

op = [i for i in range(100)]

for _ in range(N + M):
    x, y = map(int, input().split())
    op[x - 1] = y - 1


def solve():
    que = deque([0])
    while que:
        n = que.popleft()
        if n == 99:
            break
        curr = op[n]
        ans[curr] = ans[n]
        for i in range(1, 7):
            if curr + i > 99:
                continue
            if ans[curr + i] == 0:
                que.append(curr + i)
                ans[curr + i] = ans[curr] + 1

    return ans[99]


print(solve())

# for i in range(10):
#     for j in range(10):
#         print(ans[i*10+j], end=' ')
#     print()
