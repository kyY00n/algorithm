n = int(input())
for i in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    d = ((x1 - x2) ** 2 + (y1 - y2) ** 2) ** (1 / 2)
    R = [r1, r2, d]
    m = max(R)
    R.remove(m)
    print(-1 if (d == 0 and r1 == r2) else 1 if (d == r1 + r2 or m == sum(R)) else 0 if (m > sum(R)) else 2)

""" 이거랑 같은 뜻임요
if d == 0 and r1 == r2:
    print('-1')
else:
    if d == r1 + r2 or m*2 == sum(R):
        print('1')
    else:
        if m > sum(R):
            print('0')
        else:
            print('2')
"""
