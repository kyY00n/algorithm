import sys

N, x = map(int, sys.stdin.readline().split())
CEs = [0]*(N+1)
for _ in range(N+1):
	ce, idx = map(int, sys.stdin.readline().split())
	CEs[idx] = ce

res = CEs[N] * x + CEs[N-1]
for i in range(N-1, 0, -1):
	res = x * res + CEs[i-1]

sys.stdout.write(str(res % 1000000007))