"""
0 0
1 1
2 00 2 = 1+1
3 01 3 = 2+1
4 10 4 = 2+2
5 11 5 = 4+1
6 000 arr[6] = arr[2] + "0"
7 001 7 = 6 +1
8 010 arr[8] = arr[3] + "0"
9 011
10 100 arr[10] = arr[4] + "0"
11 101 arr[11] = arr[4] + "1"
12 110 arr[12] = arr[5] + "0"
13 111
14 0000 arr[14] = arr[6] + "0"

n이 홀수
arr[n] = arr[n-1][:-2] + "1"

n이 짝수
arr[n] = arr[n//2-1] + "0"

"""


def getNthElement(n):
    if n == 0:
        return "4"
    elif n == 1:
        return "7"
    else:
        if n % 2 == 0:
            return getNthElement(n // 2 - 1) + "4"
        else:
            return getNthElement(n - 1) + "7"


n = int(input())

print(getNthElement(n))
