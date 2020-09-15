def isPrime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

t = int(input())
for _ in range(t):
    n = int(input())
    for j in reversed(range(2, int(n/2)+1)):
        if isPrime(j) and isPrime(n-j):
            print(j,n-j)
            break
