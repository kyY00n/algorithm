xPoint = []
yPoint = []
for _ in range(3):
    x, y = map(int, input().split())
    xPoint.append(x)
    yPoint.append(y)
for i in range(3):
    if xPoint.count(xPoint[i]) == 1:
        x = xPoint[i]
    if yPoint.count(yPoint[i]) == 1:
        y = yPoint[i]

print(x,y)