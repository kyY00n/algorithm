A=int(input())
B=int(input())
C=int(input())
prd = A*B*C

numCount = [0,0,0,0,0,0,0,0,0,0]
while 1:
    if prd == 0:
        break
    numCount[prd%10] += 1
    prd = int(prd/10)

for i in range(10):
    print(numCount[i])