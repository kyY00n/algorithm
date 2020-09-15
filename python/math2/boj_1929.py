N, M = map(int, input().split())
for i in range(N, M+1):
    isPrime = 1
    for j in range(2, int(i**0.5)+1): #소수판별할 때 int(제곱근) + 1 까지만 돌리면 된다^__^
        if i%j == 0:
            isPrime = 0
            break
    if isPrime:
        if i != 1:
            print(i)

"""
N, M = map(int, input().split())
numList = list(range(N, M+1))
for i in range(N, M+1):
    if i == 1:
        numList.remove(i)
    else:
        for j in range(2, i):
            if i%j == 0:
                numList.remove(i)
                break
numList.sort()
for i in numList:
    print(i)
"""