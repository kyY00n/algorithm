import bisect

N = input()
M = int(input())
broken = list(map(int, input().split()))
btn = [i for i in range(10)] - broken

ans = 500000


def solve(N, strN):
    strN = N
    ans = 0
    length = len(strN)
    while length and strN[0] in btn:
        ans += 1
        length -= 1
        strN = strN[1:]

    if length == 0:
        return ans

    idx = bisect.bisect_left(btn, )