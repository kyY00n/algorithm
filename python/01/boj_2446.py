N = int(input())
for i in range(N):
    print(" " * i + "*" * ((N - 1 - i) * 2 + 1))
for i in reversed(range(0,N-1)):
    print(" " * i + "*" * ((N - 1 - i) * 2 + 1))