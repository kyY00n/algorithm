#좌표 정렬하기
import sys

points = []
N = int(sys.stdin.readline())
for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    point = (x, y)
    points.append(point)

#여기까지 좌표를 튜플로 입력 완료, 이제 정렬하면 됩니다욧.

points.sort()

for p in points:
    sys.stdout.write(str(p[0])+" "+str(p[1])+"\n")

"""
예제 입력:
5
3 4
1 1
1 -1
2 2
3 3
"""