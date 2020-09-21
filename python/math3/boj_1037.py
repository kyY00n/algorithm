import sys

N = int(sys.stdin.readline())

if N == 1:
    sys.stdout.write(str(int(sys.stdin.readline().rstrip())**2))
else:
    divs = list(map(int, sys.stdin.readline().split()))
    sys.stdout.write(str(divs[0]*divs[-1]))
                
#왜 틀렸지.....................................................................
