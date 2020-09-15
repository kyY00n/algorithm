max = 0
maxInd = 0
for i in range(9):
    inp = int(input())
    if max < inp:
        max = inp
        maxInd = i+1
print(max)
print(maxInd)