#백트래킹 입문 문제 4: N과 M
#3과 다른 점: 수열이 비내림차순이여야 함

import sys
N, M = map(int, sys.stdin.readline().split())
out = []

def solve(depth, N, M):

    if depth == M:
        sys.stdout.write(' '.join(map(str, out))+'\n')
        return

    for i in range(N):
        #추가 조건: 앞에 있는 원소보다 크지 않아야함.
        if depth != 0 and out[len(out) - 1] > i+1:
            continue
        else:
            out.append(i + 1)
            solve(depth+1, N, M)
            out.pop()

solve(0, N, M)