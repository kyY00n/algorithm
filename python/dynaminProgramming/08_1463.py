import sys

x = int(sys.stdin.readline())
array = [0 for _ in range(x+1)]
array[0] = 0
array[1] = 0

#for문으로 dp 구현~
for i in range(2,x+1):
    if i%3 == 0 and i%2 == 0:
      array[i] = min(array[i//3], array[i//2], array[i-1]) + 1
      continue
    elif i%3 == 0 and i%2 != 0:
      array[i] = min(array[i//3], array[i-1]) + 1
      continue
    elif i%3 != 0 and i%2 == 0:
      array[i] = min(array[i//2], array[i-1]) + 1
      continue
    else:
      array[i] = array[i-1] + 1

print(array[x])

