T = int(input())

for i in range(T):
    R, S = input().split()
    R = int(R)
    ans=""
    for j in range(len(S)):
        ans += S[j]*R
    print(ans)
