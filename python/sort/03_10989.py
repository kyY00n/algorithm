#sorted(series)는 메모리 초과

import sys
N = int(input())
series = [0] * 10001 #이런식으로 미리 리스트를 선언

for i in range(N):
    a = int(sys.stdin.readline())
    series[a] = series[a] + 1

for b in range(len(series)):
    if series[b] != 0:
        for c in range(series[b]):
            print(b)

"""
딕셔너리를 쓴 소스코드

import sys
N = int(input())

dic = {}

for i in range(N):
    a = int(sys.stdin.readline())
    
    if a in dic:
        dic[a] += 1
    else:
        dic[a] = 1

for t in sorted(dic.items()): #items 함수는 Key와 Value의 쌍으로 이뤄진 튜플을 원소로 가지는 리스트를 반환한다.
    for i in range(t[1]): #튜플은 (key, value) 형태이므로 t[1]은 value를, t[0]은 key를 뜻한다.
        print(t[0])
"""