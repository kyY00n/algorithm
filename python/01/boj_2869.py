"""A, B, V = map(int, input().split())

print(int(V /(A-B)) + 1) ㅜㅜㅜㅜㅜㅜㅜ"""

a,b,v = map(int,input().split())
k = (v-b)/(a-b)
print(int(k) if k == int(k) else int(k)+1)
#파이썬 삼항연산자!
#(true 일 때 값) if (조건문) else (false일 때 값)