#피보나치함수
#망했음
import sys
T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    if N == 0:
        sys.stdout.write('1 0\n')
    else:
        f = 0
        b = 1
        for _ in range(N-1):
            tmp = f
            f = b
            b = tmp + b
        sys.stdout.write(str(f) + ' ' + str(b) + '\n')

"""
0의 갯수: 1 0 1 1 2 ...
1의 개수:   0 1 1 2 3 ...
"""