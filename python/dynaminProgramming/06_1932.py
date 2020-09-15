#정수삼각형
import sys
n = int(sys.stdin.readline())

nums = []

for _ in range(n):
    l = list(map(int, sys.stdin.readline().split()))
    nums.append(l)

maxSum = [[0 for j in range(i + 1)] for i in range(n)]

maxSum[0][0] = nums[0][0]

def calcMax(row, idx):
    if row == 0:
        return maxSum[0][0]
    if idx == 0:
        if maxSum[row][0] == 0:
            maxSum[row][0] = calcMax(row - 1, 0) + nums[row][0]
        return maxSum[row][0]
    if idx == row:
        if maxSum[row][idx] == 0:
            maxSum[row][idx] = calcMax(row - 1, idx - 1) + nums[row][idx]
        return maxSum[row][idx]
    if maxSum[row][idx] == 0:
        maxSum[row][idx] = max(calcMax(row-1, idx-1), calcMax(row-1, idx+1)) + nums[row][idx]
    return maxSum[row][idx]

sol = 0
for i in range(n):
    tmp = calcMax(n-1, i)
    if sol < tmp:
        sol = tmp

sys.stdout.write(sol)
