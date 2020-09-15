N=int(input())

arr = list(map(int, input().split())) #숫자 여러 개를 한 줄에 입력받을 때 '배열'에 저장하는 법^_^

max = min = arr[0]

for i in range(1,N):
    if max < arr[i]:
        max = arr[i]
    if min > arr[i]:
        min = arr[i]

print(min, max)