M = int(input())
N = int(input())
numList = list(range(M, N+1))

for i in range(M, N+1):
    if i == 1:
        numList.remove(i)
    else:
        for j in range(2, i):
            if i % j == 0:
                numList.remove(i)
                break

if len(numList) == 0:
    print(-1)
else:
    print(sum(numList)) #리스트의 전체 합을 알고 싶을 때는 그냥 이름만 써주면 된다.
    print(numList[0])