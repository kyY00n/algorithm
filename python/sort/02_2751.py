"""
def quickSort(data: list, start: int, end: int):
    if start >= end:
        return
    key = start
    i = start + 1
    j = end
    while i <= j:
        while data[i] <= data[key]:
            i += 1
        while data[j] >= data[key] and j > start:
            j -= 1
        if i > j:
            temp = data[j]
            data[j] = data[key]
            data[key] = temp
        else:
            temp = data[j]
            data[j] = data[i]
            data[i] = temp
    quickSort(data, start, j - 1)
    quickSort(data, j + 1, end)

a = []
for _ in range(int(input())):
    a.append(int(input()))
#a.sort(): O(N*logN)의 시간복잡도 정렬 알고리즘 - 퀵정렬
quickSort(a, 0, len(a) - 1)
for i in a:
    print(i)
"""
import sys
n = int(input())
l = []
for i in range(n):
    l.append(int(sys.stdin.readline()))
for i in sorted(l):
    sys.stdout.write(str(i)+'\n')