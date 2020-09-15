"""
C = int(input())

for i in range(C):
    rankNum = 0
    scores = list(map(int, input().split))
    stuNum = scores.pop(0)
    for j in range(stuNum):
        sum += scores[j]
    avg = sum/stuNum
    for j in range(stuNum):
        if scores[j] > avg:
            rankNum += 1
    rankPer = rankNum / stuNum * 100
    print(format(rankPer, ".3f"),"%")
"""

C = int(input())
for i in range(C):
    N = list(map(int, input().split()))
    avg = sum(N[1:]) / N[0]
    cnt = 0
    for j in N[1:]:
        if j > avg : 
            cnt += 1
            
    print(str("%.3f" %round((cnt/N[0])*100, 3))+"%")