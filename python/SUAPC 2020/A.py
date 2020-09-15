import sys

d1, d2, d3 = map(int, sys.stdin.readline().strip().split())

if d2 != d3 and d1/(d2-d3) == 1:
    sys.stdout.write('-1')
    sys.exit(1)

a1 = round((d1+d2-d3)/2, 1)
a2 = round((d1-d2+d3)/2, 1)
a3 = round((d2-d1+d3)/2, 1)

if a1 < 1 or a2 < 1 or a3 < 1:
    sys.stdout.write('-1')
    sys.exit(1)

sys.stdout.write('1')
sys.stdout.write('\n'+str(a1)+' '+str(a2)+' '+str(a3))
