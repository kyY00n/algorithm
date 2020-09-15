a = []
for _ in range(int(input())):
    a.append(int(input()))

#a.sort() : O(N^2) 의 시간복잡도 정렬 - 버블 정렬 이용

for i in range(len(a)):
    for j in range(len(a)-1-i):
        if a[j] > a[j+1]:
            tmp = a[j]
            a[j] = a[j+1]
            a[j+1] = tmp

for i in a:
    print(i)
