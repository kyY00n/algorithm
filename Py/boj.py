N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))


# 그래. 판을 뒤집자 하..

def solve():
    ans = 0
    li = [[4, 1], [2, 2], [2, 3], [2, 3], [3, 2]]
    for i in range(5):
        for j in range(M - li[i][0] + 1):
            for k in range(N - li[i][1] + 1):
                if i == 0:
                    ans = max(ans, arr[j][k] + arr[j][k + 1], arr[j][k + 2], arr[j][k + 3])
                elif i == 1:
                    ans = max(ans, arr[j][k] + arr[j][k + 1] + arr[j + 1][k] + arr[j + 1][k + 1])
                elif i == 2:
                    ans = max(ans, arr[j][k] + arr[j + 1][k] + arr[j + 2][k] + arr[j + 1][k + 2])
                elif i == 3:
                    ans = max(ans, arr[j][k] + arr[j][k + 1], arr[j + 1][k + 1], arr[j + 2][k + 1])
                else:
                    ans = max(ans, arr[j][k] + arr[j][k + 1] + arr[j][k + 2] + arr[j + 1][k + 1])
    return ans


print(solve())
