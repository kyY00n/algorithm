#미리 소수를 구해서 저장해 놓기. n<=123456
import sys

# 소수리스트 만들어주기
prime_ox = [True for _ in range(123457 * 2)]

for i in range(2, int((123457 * 2) ** 0.5)):
    if prime_ox[i]:
        for j in range(i + i, 123457 * 2, i):
            prime_ox[j] = False

prime_list = [i for i, j in enumerate(prime_ox) if j and i >= 2]

# 소수 출력하기
num = int(sys.stdin.readline())

while num != 0:

    answer = 0
    for i in prime_list:
        if i <= num:
            continue
        elif num * 2 >= i > num:
            answer += 1
        else:
            break

    print(answer)

    num = int(sys.stdin.readline())


"""
이게 왜 시간초과가 뜨나..

while 1:
    n = int(input())
    if n == 0:
        break
    cnt = n
    for i in range(n+1, 2*n+1):
        for j in range(2, int(i**0.5)+1):
            if i%j == 0:
                cnt -= 1
                break
    print(cnt)
"""