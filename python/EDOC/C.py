import sys

N=int(input())
money = 0
l = []
while N != 0:
    for i in range(N):
        l[i] = input().split() #다 저장함 l = [["E", "0", "1"]] 이런식으로 저장

def solve(list, roomNum, money):
    for l in list:
        if l[0] == "T":
            if money < int(l[1]):
                print("No")
                return
            else:
                solve(list, roomNum+1, money-l[1])