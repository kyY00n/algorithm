T = int(input())
for _ in range(T):
    H, W, N = map(int, input().split())

    if N % H == 0:
        roomNum = H * 100 + int(N / H)
    else:
        roomNum = N % H * 100 + int(N / H) + 1

    print(roomNum)

""" 숏코딩
for _ in range(int(input())):
    H,W,N=map(int,input().split())
    a=N%H;b=N//H+1
    if a==0 : a=H;b-=1
    print(a*100+b)


출처: https://leedakyeong.tistory.com/entry/백준-10250번-ACM-호텔-in-python [슈퍼짱짱]
"""