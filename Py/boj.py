import sys
input = sys.stdin.readline

N, M = map(int, input().split())
password = dict()
for _ in range(N):
    site, pw = input().split()
    password[site] = pw

ans = []
for _ in range(M):
    site = input()[:-1]
    ans.append(password[site])

print('\n'.join(ans))