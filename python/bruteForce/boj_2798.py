import sys

N, M = map(int, sys.stdin.readline().split())

cardNums = list(map(int, sys.stdin.readline().split()))

min = 300000

frstIdx = 0
scndIdx = 1
thrdIdx = 2

while True:
    n = cardNums[frstIdx]+cardNums[scndIdx]+cardNums[thrdIdx]
    if  M-n < min:
        min = M-n
        ans = n

sys.stdout.write(str(ans))
sys.stdout.flush()
