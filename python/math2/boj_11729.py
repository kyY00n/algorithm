#하노이탑 입력 n: 판의 개수
#설명: https://yeol2.tistory.com/39

"""
의사코드:
def hanoi(N, From, By, To):
    if N == 1:
        print('From To') #원반을 1번째에서 3번째로 이동
    else:
        #step 1
        function(N-1, From, To, By) #N-1개의 원반을 1번에서 2번으로 이동

        #step 2
        print('From To') #가장 큰 원반 N을 1번째 에서 3번째로 옮긴다.

        #step 3
        function(N-1, By, From, To) #N-1개의 원반을 2번에서 3번으로 옮긴다.
"""
step = []

def hanoi(N, From, By, To):
    if N == 1:
        step.append([From, To])
    else:
        hanoi(N-1, From, To, By)
        step.append([From, To])
        hanoi(N-1, By, From, To)

n = int(input())
hanoi(n, 1, 2, 3)

print(len(step))
print('\n'.join(([' '.join(str(i) for i in row) for row in step])))