x, y, a0, a1, n = map(int, input().split())

l = [0]*(n+1)
l[0] = a0
l[1] = a1

for i in range(2, n+1):
    l[i] = x*l[i-1] + y*l[i-2]

sol = l[n] % 100
if sol < 10:
    print('0'+sol)
else:
    print(sol)
