import sys
while True:
    f, s = map(int, sys.stdin.readline().split())
    if f == 0:
        break
    if s % f == 0:
        sys.stdout.write('factor\n')
    elif f % s == 0:
        sys.stdout.write('multiple\n')
    else:
        sys.stdout.write('neither\n')
