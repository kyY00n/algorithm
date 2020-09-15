def fact(n):
    if n == 1 or n == 0: #0도 처리해줘야함
        return 1
    else:
        return n*fact(n-1)

N = int(input())
print(fact(N))